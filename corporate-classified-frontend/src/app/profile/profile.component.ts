import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Employee } from '../interfaces/employee';
import { OfferService } from '../services/offer/offer.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  
   employee: Employee | any;
   employeeId: number = 1;
  constructor(private activatedRoute: ActivatedRoute, private offerService:OfferService) { }

  ngOnInit(): void {

    this.offerService.getEmployeeDetails(this.employeeId).subscribe(
      data => {
        this.employee = data;
        console.log(this.employee);
      }
    )
  }
    
}

