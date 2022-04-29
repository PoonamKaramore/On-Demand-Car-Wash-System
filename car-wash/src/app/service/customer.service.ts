import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl1 from './helper1';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http:HttpClient) { }

  // public getcustomer(id:any){
  //   return this.http.get(`${baseUrl1}/customer/profile/${id}`)
  // }

  public createUser(Customer:any){

    return this.http.post(`${baseUrl1}/customer/add-profile`,Customer);

  }
  
}
