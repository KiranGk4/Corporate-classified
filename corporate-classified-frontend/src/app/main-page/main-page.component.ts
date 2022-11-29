import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  constructor(private route: Router) { }

  ngOnInit(): void {
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
