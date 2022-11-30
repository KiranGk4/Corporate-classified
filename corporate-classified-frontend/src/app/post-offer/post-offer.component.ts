import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Route, Router } from '@angular/router';
//import { Offer } from '../class/offer';
import { Category } from '../interfaces/category';
import { Offer } from '../interfaces/offer';
import { OfferService } from '../services/offer/offer.service';

@Component({
  selector: 'app-post-offer',
  templateUrl: './post-offer.component.html',
  styleUrls: ['./post-offer.component.css']
})
export class PostOfferComponent implements OnInit {
  offerForm: FormGroup | any;
  category: Category[] = [];
  // offer: Offer = new Offer("","",0,0);
  //offerForm: FormGroup;
  //offerForm: Offer | undefined;
  constructor(private offerService: OfferService, private formBuilder: FormBuilder, private route:Router) { }

  ngOnInit(): void {

    this.offerService.getCategory().subscribe(
      data => {
        this.category = data;
      }
    );

    this.offerForm = this.formBuilder.group({
      offerTitle: new FormControl('', Validators.minLength(2)),
      offerDescription: new FormControl('', Validators.maxLength(100)),
      category: new FormControl(),
      offerPrice: new FormControl(),
      offerNegotiable: new FormControl(false),
      employee: new FormControl(0)
    });

    // Object.assign(
    //   {},this.offerForm.value,{
    //     category:{
    //       categoryId: this.offerForm.get('category')?.value},
    //   }
    // );
  }

 

  onSubmit(){
    //this.offer.offerDescription = this.offerForm.value.offerDescription
   this.offerService.save(Object.assign(
    {},this.offerForm.value,{
      category:{
        categoryId: this.offerForm.get('category')?.value},
        employee:{
          employeeId: sessionStorage.getItem('userId')
        }
    }
  )).subscribe(data=>{
    this.route.navigate(['/main-page/employee-home']);
   });
   console.log(JSON.stringify(this.offerForm.value))
  }
}
