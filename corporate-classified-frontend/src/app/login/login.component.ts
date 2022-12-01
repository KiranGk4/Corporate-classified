import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';
import { Employee } from '../interfaces/employee';
import { OfferService } from '../services/offer/offer.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup | any;
  employee: Employee | any;
  constructor(private formBuilder: FormBuilder,private offerService: OfferService, private route: Router, private toast: NgToastService) { }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group(
      {
        email: new FormControl('',Validators.required),
        password: ['',Validators.required]
      }
    );
  }

  onSubmit(){
    console.log(this.loginForm.value);
    this.offerService.employeeLogin(this.loginForm.value).subscribe(
      data=>{
        this.getEmployee(data.email);
        if(sessionStorage.getItem('userId')){
          this.route.navigate(['/main-page/employee-home']);
        }
        // this.toast.success({detail:"SuccessMessage", summary:"Login success", duration:5000})
        console.log(data.email);
    },
    error=>{ 
      this.toast.error({detail:"Error", summary:"Invalid username/password", duration:5000})
      this.route.navigate(['/login']); })
  }

  getEmployee(email: string){
    this.offerService.getEmployeeId(email).subscribe(
      data=>{
        this.employee = data;
        console.log(this.employee);
        sessionStorage.setItem('userId',this.employee?.employeeId);
      }
    )    
  }



}
