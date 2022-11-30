import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { Category } from '../interfaces/category';
import { Offer } from '../interfaces/offer';
import { OfferService } from '../services/offer/offer.service';

@Component({
  selector: 'app-employee-home',
  templateUrl: './employee-home.component.html',
  styleUrls: ['./employee-home.component.css']
})
export class EmployeeHomeComponent implements OnInit {

  offers: Offer[] = [];
  //category: Category[] = [];
  constructor(private offerService: OfferService,private route:Router) { }

  ngOnInit(): void {
    
    // this.offerService.getCategory().subscribe(
    //   data => {
    //     this.category = data;
    //   }
    // )

    this.offerService.getAllOffers().subscribe(
      data => {
        this.offers = data;
        console.log(this.offers);
      }
    )
    

  }
  //get Offer by Category
  filterByCategory(categoryId:number):void{
   console.log(categoryId);
   this.offerService.getOfferByCategory(categoryId).subscribe(
    data => {
      this.offers = data;
      console.log(this.offers);
    }
  )
  // console.log(categoryId);
  // this.route.navigate(['/main-page/employee-home/'+categoryId]);
  }
  filterByDate(date:string):void{
    console.log(date);
    this.offerService.getOfferByDate(date).subscribe(
     data => {
       this.offers = data;
       console.log(this.offers);
    }
    )
  }

  goToOfferDetail(offerId: number){
    this.route.navigate(['/main-page/offer-detail/'+offerId]);
  }
}
