import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Offer } from '../interfaces/offer';
import { OfferService } from '../services/offer/offer.service';

@Component({
  selector: 'app-offer-detail',
  templateUrl: './offer-detail.component.html',
  styleUrls: ['./offer-detail.component.css']
})
export class OfferDetailComponent implements OnInit {

  offer: Offer | any;

  constructor(
    private offerService: OfferService,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    const id = Number(this.activatedRoute.snapshot.paramMap.get('id'));

    this.offerService.getOffer(id).subscribe(
      data => {
        this.offer = data;
        console.log(this.offer);
      }
    )
  }

  engage(offerId:number){
    this.offerService.getOffer(offerId).subscribe(
      data=>{
        this.offer=data;
      }
    );
    console.log(JSON.stringify(Object.assign({},this.offer,{employeeEngage: Number(sessionStorage.getItem('userId'))})))
    this.offerService.engageOffer(offerId, this.offer).subscribe({});
  }
}
