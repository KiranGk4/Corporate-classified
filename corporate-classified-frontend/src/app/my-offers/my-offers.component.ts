import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { Offer } from '../interfaces/offer';
import { OfferService } from '../services/offer/offer.service';


@Component({
  selector: 'app-my-offers',
  templateUrl: './my-offers.component.html',
  styleUrls: ['./my-offers.component.css']
})
export class MyOffersComponent implements OnInit {

  offers: Offer[] = [];
  constructor(private offerService: OfferService,private route: Router) { }


  ngOnInit(): void {
    const id= Number(sessionStorage.getItem('userId')); 
    this.offerService.getOfferById(id).subscribe(
      data => {
        this.offers = data;
        console.log(this.offers);
      }
    )  
  }

  goToOfferDetails(offerId: number): void{
    console.log(offerId);
    this.route.navigate(['/main-page/offer-detail/'+offerId]);
  }

  goToEditOffer(offerId: number): void{
    this.route.navigate(['/main-page/edit-offer/'+offerId]);
  }
}
