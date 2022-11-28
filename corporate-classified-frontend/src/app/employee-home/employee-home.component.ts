import { Component, OnInit } from '@angular/core';
import { Offer } from '../interfaces/offer';
import { OfferService } from '../services/offer/offer.service';

@Component({
  selector: 'app-employee-home',
  templateUrl: './employee-home.component.html',
  styleUrls: ['./employee-home.component.css']
})
export class EmployeeHomeComponent implements OnInit {

  offers: Offer[] = [];
  constructor(private offerService: OfferService) { }

  ngOnInit(): void {
    this.offerService.getAllOffers().subscribe(
      data => {
        this.offers = data;
        console.log(this.offers);
      }
    )
  }

}
