import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';
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
  likeCount: number = 0;
  constructor(
    private offerService: OfferService,
    private activatedRoute: ActivatedRoute,
    private toast: NgToastService,
    private route: Router) {   }

  ngOnInit(): void {
    const id = Number(this.activatedRoute.snapshot.paramMap.get('id'));

    this.offerService.getOffer(id).subscribe(
      data => {
        this.offer = data;
        this.likeCount = data.offerLikes;
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
    if(!this.likes)
    {
      this.likeCount = this.likeCount+1;
    }
    this.likes = true;
    //this.offer?.offerLikes = this.offer?.offerLikes + 1;
  }

  engage(offerId: number){
    this.offerService.getOffer(offerId).subscribe(
      data => {
        this.offer = data;
      }
    );
    this.toast.success({detail:"Engaged ", summary:"Offer Engaged", duration:5000});
    //console.log(JSON.stringify(Object.assign({},this.offer,{ employeeEngage: Number(sessionStorage.getItem('userId'))})))
    //this.offerService.engageOffer(offerId, Object.assign({},this.offer,{ employeeEngage: Number(sessionStorage.getItem('userId'))})).subscribe(
    //  data => {
    //  this.toast.success({detail:"Engaged ", summary:"Offer Engaged", duration:5000});
      //this.route.navigate(['/main-page/employee-home'])
    //});
  }
}