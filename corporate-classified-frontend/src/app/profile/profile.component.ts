import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

   name: string="insaf";
   address:string="Panthalloor House Thelakkad Po"
   contactNo:string="9495105768"
   email:string="mohammedinsafp@gmail.com"

  constructor() { }

  ngOnInit(): void {
    
  }

}
