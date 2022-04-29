import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class WashpackService {

  constructor(private http:HttpClient) { }

  //This is to get washPack
  public washpacks()
  {
    return this.http.get(`${baseUrl}/admin/allwashpacks`)
  }
  //add washpack
  public addWashPack(pack:any)
  {
    return this.http.post(`${baseUrl}/admin/addwashpacks`,pack)
  }
  // delete washpack by id
  public deletewashpack(id:any){
    return this.http.delete(`${baseUrl}/admin/delete/${id}`,id);
  }
  // get washpack by id
  public getwashpack(id:any){
    return this.http.get(`${baseUrl}/admin/getwashpack/${id}`)
  }

  public updatewashpack(wash:any){
    return this.http.put(`${baseUrl}/admin/update-pack`,wash);
  }


}
