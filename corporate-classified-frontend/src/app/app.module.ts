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

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    PostOfferComponent,
    OfferDetailComponent,
    ProfileComponent,
    MyOffersComponent,
    ContactComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
