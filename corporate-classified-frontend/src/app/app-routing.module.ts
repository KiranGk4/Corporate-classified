import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactComponent } from './contact/contact.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { MainPageComponent } from './main-page/main-page.component';
import { MyOffersComponent } from './my-offers/my-offers.component';
import { OfferDetailComponent } from './offer-detail/offer-detail.component';
import { PostOfferComponent } from './post-offer/post-offer.component';
import { ProfileComponent } from './profile/profile.component';

const routes: Routes = [
  {path: 'main-page', component: MainPageComponent,
    children: [
      { path: 'profile', component: ProfileComponent},
      {path: 'post-offer', component: PostOfferComponent},
      {path: 'offer-detail', component: OfferDetailComponent},
      {path: 'my-offers', component: MyOffersComponent},
    ],
  },
  {path: 'login', component: LoginComponent},
  {path: 'home', component: HomeComponent},
  {path: 'contact', component:ContactComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }