import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public loginData={
    username:'',
    password:'',
  }

  constructor(private snack:MatSnackBar,private login:LoginService , private router:Router) { }

  ngOnInit(): void {
  }
  formSubmit()
  {
    console.log("login form submitted");
    if(this.loginData.username.trim()=='' || this.loginData.username==null)
    {
      this.snack.open("username is required !!",'',{
        duration:3000,
      });
      return;
    }
    if(this.loginData.password.trim()=='' || this.loginData.password==null)
    {
      this.snack.open("Password is required !!",'',{
        duration:3000,
      });
      return;
    }
    //Request Server To generate Token

    this.login.generateToken(this.loginData).subscribe(
      (data:any)=>{
        console.log('success');
        console.log(data);

        //login
        this.login.loginUser(data.token);
        this.login.getCurrentUser().subscribe(
          (user:any)=>{
            this.login.setUser(user);
            console.log(user);
            //redirect to ADMIN dashboard
            //redirect to CUSTOMER dashboard
            //redirect to WASHER dashboard
            if(this.login.getUserRole()=="Admin")
            {
              //Admin DashBoard
              this.login.loginstatus.next(true);
              window.location.href='/admin' 
              //this.router.navigate(['admin'])
            }else if(this.login.getUserRole()=="Customer")
            {
              //Customer Dashboard
              this.login.loginstatus.next(true);
              window.location.href='/customer'
            }else if(this.login.getUserRole()=="Washer")
            {
              //Washer Dashboard
              this.login.loginstatus.next(true);
              window.location.href='/washer'
            }
            else{
              this.login.logout.call('/login');
              window.location.href = '/login'
          
            }
          }
        )

      },
      (error)=>{
        console.log('Error !');
        console.log(error);
        this.snack.open("invalid Details!! Try Again",'',{
          duration:3000,
        })
      }
    );

  }
}
