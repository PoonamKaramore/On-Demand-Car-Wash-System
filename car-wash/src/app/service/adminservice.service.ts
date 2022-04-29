import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';
import baseUrl1 from './helper1';

@Injectable({
  providedIn: 'root'
})
export class AdminserviceService {
  Customer() {
    throw new Error('Method not implemented.');
  }

  constructor(private http:HttpClient) { }

  // public getwashpacks(washpacks:any){

  //   return this.http.get(`${baseUrl}/admin/allwashpacks`,washpacks);

  // }
  public getadmin(){
    return this.http.get(`${baseUrl}/admin/get-profile`);
  }
  public allcustomers(){
    return this.http.get(`${baseUrl1}/customer/get-profile`);
  }

  public allwashers(){
    return this.http.get(`${baseUrl}/admin/getwashers`);
  }
}
