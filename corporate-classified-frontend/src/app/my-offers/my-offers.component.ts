import { Component, OnInit } from '@angular/core';
import { Offer } from '../interfaces/offer';
import { OfferService } from '../services/offer/offer.service';



@Component({
  selector: 'app-my-offers',
  templateUrl: './my-offers.component.html',
  styleUrls: ['./my-offers.component.css']
})
export class MyOffersComponent implements OnInit {

  
  offers: Offer[] = [];
  constructor(private offerService: OfferService) { }

  ngOnInit(): void {
    const id=1; 
    this.offerService.getOfferById(id).subscribe(
      data => {
        this.offers = data;
        console.log(this.offers);
      }
    )

    
  }

}
