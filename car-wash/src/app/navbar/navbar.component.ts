import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  isUserActive= false;
  user:any;
  constructor(public login:LoginService) { }

  ngOnInit(): void {
    this.isUserActive = this.login.isLoggedIn();
    this.user = this.login.getuser();
    this.login.loginstatus.asObservable().subscribe((data)=>{
      this.isUserActive = this.login.isLoggedIn();
      this.user = this.login.getuser();
    })
  }

  public Logout(){
    this.login.logout();
    window.location.reload();
    
  }

}
