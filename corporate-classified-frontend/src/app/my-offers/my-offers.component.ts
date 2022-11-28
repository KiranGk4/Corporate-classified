import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-my-offers',
  templateUrl: './my-offers.component.html',
  styleUrls: ['./my-offers.component.css']
})
export class MyOffersComponent implements OnInit {

  pageTitle: string = "My Offers";
  post: string = "19/11/2022";
  engage: string = "not yet";
  status: string = "open";
  category: string = "Apartments";
  price: string = "20K";
  Negotiable: string = "Yes";
  Likes: number = 3;
  constructor() { }

  ngOnInit(): void {
    
  }

}
