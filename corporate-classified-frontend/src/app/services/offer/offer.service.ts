import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Offer } from 'src/app/interfaces/offer';

@Injectable({
  providedIn: 'root'
})
export class OfferService {

  springUrl:string = "http://localhost:8080/";
  constructor(private http: HttpClient) { }

  /* passed to employee-home*/
  getAllOffers(): Observable<Offer[]>{
    console.log(this.springUrl+"offer-all");
    return this.http.get<Offer[]>(this.springUrl+"offer-all");
  }

  getOffer(id: number): Observable<Offer>{
    return this.http.get<Offer>(this.springUrl+"offer-by-id/"+id)
  }

  getOfferById(id: number): Observable<Offer[]>{
    return this.http.get<Offer[]>(this.springUrl+"offer-by-employee/"+id)
  }
}
