import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl2 from './helper2';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http:HttpClient) { }

  public getallorders(){
    return this.http.get(`${baseUrl2}/washer/getallorders`);
  }
  public getorder(){
    return this.http.get(`http://localhost:8086/order/get-orders`)
  }
  public addorders(order:any){
    return this.http.post(`http://localhost:8086/order/add-order`,order);
  }
}
