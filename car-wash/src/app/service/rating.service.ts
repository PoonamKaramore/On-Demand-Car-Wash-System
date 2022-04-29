import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl2 from './helper2';
import baseUrl1 from './helper1';

@Injectable({
  providedIn: 'root'
})
export class RatingService {

 
  constructor(private http:HttpClient) { }

  //This is to get Rating
  public getRatings()
  {
    return this.http.get("http://localhost:8083/customer/get-ratings");
  }

   // to add rating
   public addRating(rate:any)
   {
     return this.http.post(`${baseUrl1}/customer/add-ratings`,rate);
   }
}
