import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { PostOfferComponent } from './post-offer/post-offer.component';
import { OfferDetailComponent } from './offer-detail/offer-detail.component';
import { ProfileComponent } from './profile/profile.component';
import { MyOffersComponent } from './my-offers/my-offers.component';
import { ContactComponent } from './contact/contact.component';
import { HomeComponent } from './home/home.component';
import { EmployeeHomeComponent } from './employee-home/employee-home.component';
import { MainPageComponent } from './main-page/main-page.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http'
import { ReactiveFormsModule } from '@angular/forms';
import { EditOfferComponent } from './edit-offer/edit-offer.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    PostOfferComponent,
    OfferDetailComponent,
    ProfileComponent,
    MyOffersComponent,
    ContactComponent,
    HomeComponent,
    EmployeeHomeComponent,
    MainPageComponent,
    PageNotFoundComponent,
    EditOfferComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
