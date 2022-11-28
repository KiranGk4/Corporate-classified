import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactComponent } from './contact/contact.component';
import { EmployeeHomeComponent } from './employee-home/employee-home.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { MainPageComponent } from './main-page/main-page.component';
import { MyOffersComponent } from './my-offers/my-offers.component';
import { OfferDetailComponent } from './offer-detail/offer-detail.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { PostOfferComponent } from './post-offer/post-offer.component';
import { ProfileComponent } from './profile/profile.component';

const routes: Routes = [
  {path: 'main-page', component: MainPageComponent,
    children: [
      { path: 'profile', component: ProfileComponent},
      {path: 'post-offer', component: PostOfferComponent},
      {path: 'offer-detail/:id', component: OfferDetailComponent},
      {path: 'my-offers', component: MyOffersComponent},
      {path: 'employee-home', component:EmployeeHomeComponent}
    ],
  },
  {path: 'login', component: LoginComponent},
  {path: 'home', component: HomeComponent},
  {path: 'contact', component:ContactComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: '**', component:PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }