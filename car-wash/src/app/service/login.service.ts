import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import baseUrl1 from './helper1';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  public loginstatus = new Subject<boolean>();
  constructor(private http:HttpClient) { }

  // generate token
  public generateToken(user:any){

    return this.http.post(`${baseUrl1}/customer/authenticate`,user);
  }


  //current user which is loggedin 
  public getCurrentUser(){
    return this.http.get(`${baseUrl1}/customer/currentuser`);
  }

  //Login User : set token in local storage
  public loginUser(token : any){
    localStorage.setItem("token",token);
    return true;
  }

  // to check is user logged in or not
  public isLoggedIn(){
    let tokenstring = localStorage.getItem("token");
    if(tokenstring == undefined || tokenstring == '' || tokenstring == null){
      return false;
    }
    else{
      return true;
    }
  }

  //logout user by removing token from local storage
  public logout(){
    localStorage.removeItem('token');
    localStorage.removeItem('user');
    return true;
  }

  // get token
  public getToken(){
    return localStorage.getItem('token');
  }

  //set user detail
  public setUser(user:any){
    localStorage.setItem("user",JSON.stringify(user));
  }

  //get user detail
  public getuser(){
    let userstring = localStorage.getItem("user");
    if(userstring != null){
      return JSON.parse(userstring);
    }
    else{
      this.logout();
      return null;
    }
  }

  //get user role
  public getUserRole(){
    let user = this.getuser();
    return user.authorities[0].authority;
  }
}
