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
  likes: boolean = false;
  showEngage: boolean = true;
  constructor(
    private offerService: OfferService,
    private activatedRoute: ActivatedRoute) {   }

  ngOnInit(): void {
    const id = Number(this.activatedRoute.snapshot.paramMap.get('id'));

    this.offerService.getOffer(id).subscribe(
      data => {
        this.offer = data;
        this.check(this.offer?.employee.employeeId);
      }
    )
  }

  check(id:number){
    if(id === Number(sessionStorage.getItem('userId')))
    {
      this.showEngage = false;
    }
  }
  like(): void{
    this.likes = true;
    //this.offer?.offerLikes = this.offer?.offerLikes + 1;
  }

  engage(offerId:number){
    this.offerService.getOffer(offerId).subscribe(
      data=>{
        this.offer=data;
      }
    );
    console.log(JSON.stringify(Object.assign({},this.offer,{employeeEngage: Number(sessionStorage.getItem('userId'))})))

  
    console.log(JSON.stringify(Object.assign({},this.offer,{ employeeEngage: Number(sessionStorage.getItem('userId'))})))

    this.offerService.engageOffer(offerId, this.offer).subscribe({});
  }
}