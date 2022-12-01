import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  constructor(private route: Router, private toast: NgToastService) { }

  ngOnInit(): void {
  }

  logout(){
    sessionStorage.clear();
    this.route.navigate(['/login']);
    this.toast.success({detail:"LogoutSuccess", summary:"Login again to post", duration:5000})
  }

  goToProfile(): void{
    this.route.navigate(['/main-page/profile/'])
  }

  goToPostAnOffer(): void{
    this.route.navigate(['/main-page/post-offer/'])
  }

  goToMyOffers(): void{
    this.route.navigate(['/main-page/my-offers/'])
  }
}
