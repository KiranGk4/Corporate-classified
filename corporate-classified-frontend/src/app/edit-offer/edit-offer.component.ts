import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
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
  //editOffer: FormGroup | any;
    editOffer  = new FormGroup({
    offerId: new FormControl(''),
    offerTitle: new FormControl(''),
    offerDescription: new FormControl(''),
    offerNegotiable: new FormControl(false),
    offerPrice: new FormControl(0)
   });

  constructor(private offerService: OfferService,private route: ActivatedRoute) { }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.params['id']);
    this.editOfferId=id;
    console.log(id);

     this.offerService.getOffer(id).subscribe((result: any)=>{
       //console.log(result);

       this.editOffer  = new FormGroup({
        offerId: new FormControl(result['offerId']),
        offerTitle: new FormControl(result['offerTitle']),
        offerDescription: new FormControl(result['offerDescription']),
        offerNegotiable: new FormControl(result['offerNegotiable']),
        offerPrice: new FormControl(result['offerPrice'])
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
    this.offerService.updateOffer(this.editOfferId,this.editOffer.value).subscribe((result)=>{
      console.log(result);
    })
  }

  // onSubmit(){
  //   this.offerService.updateOffer(this.editOffer.value)
  // }

}
