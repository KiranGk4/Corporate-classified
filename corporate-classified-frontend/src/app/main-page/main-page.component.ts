import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  constructor(private route: Router) { }

  ngOnInit(): void {
  }

  logout(){
    sessionStorage.clear();
    this.route.navigate(['/home']);
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
