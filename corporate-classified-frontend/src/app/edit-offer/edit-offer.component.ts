import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from '../interfaces/category';
import { Offer } from '../interfaces/offer';
import { OfferService } from '../services/offer/offer.service';

@Component({
  selector: 'app-edit-offer',
  templateUrl: './edit-offer.component.html',
  styleUrls: ['./edit-offer.component.css']
})
export class EditOfferComponent implements OnInit {

  offers: Offer[] = [];
  editOfferId: number=0;
  categorys: Category[] = [];
  
  //editOffer: FormGroup | any;
    editOffer  = new FormGroup({
    offerId: new FormControl(''),
    offerTitle: new FormControl(''),
    offerDescription: new FormControl(''),
    offerNegotiable: new FormControl(false),
    offerPrice: new FormControl(0),
    category: new FormControl(0)
   });

  constructor(private offerService: OfferService,private route: ActivatedRoute, private route1: Router) { }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.params['id']);
    this.editOfferId=id;
    console.log(id);
    
    this.offerService.getCategory().subscribe(
      data => {
        this.categorys = data;
      }
    );

     this.offerService.getOffer(id).subscribe((result: any)=>{
       //console.log(result);

       this.editOffer  = new FormGroup({
        offerId: new FormControl(result['offerId']),
        offerTitle: new FormControl(result['offerTitle']),
        offerDescription: new FormControl(result['offerDescription']),
        offerNegotiable: new FormControl(result['offerNegotiable']),
        offerPrice: new FormControl(result['offerPrice']),
        category: new FormControl(result['category'])
       });
     });

    // this.offerService.getOffer(id).subscribe((result)=>{

    //   this.editOffer=new FormGroup({
    //     //offerId:new FormControl(''),
    //     offerTitle: new FormControl(result['offerTitle']),
    //     offerDescription: new FormControl(result['offerDescription']),
    //     offerPrice: new FormControl(result['offerPrice']),
    //     offerNegotiable: new FormControl(result['offerNegotiable'])//,
    //     //category: new FormControl(result['category'])
    //   })
    // })
  }

  updateOffer(){
    console.log(this.editOffer.value);
    this.offerService.updateOffer(this.editOfferId,Object.assign(
         {},this.editOffer.value,{
           category:{
             categoryId: this.editOffer.get('category')?.value},
         }
       )).subscribe((result)=>{
      this.route1.navigate(['/main-page/my-offers'])
      console.log(result);
    })
  }

  // onSubmit(){
  //   this.offerService.updateOffer(this.editOffer.value)
  // }

}
