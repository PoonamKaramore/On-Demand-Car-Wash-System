import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../service/customer.service';
import Swal from 'sweetalert2';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  
  constructor(private snack:MatSnackBar,private customerservice: CustomerService) { }

  public signup = {
    customername:'',
    username: '',
    email:'',
    password:'',
    address:'',
    phoneNo:'',
    role:''
  };

  ngOnInit(): void {
  }

  submitform(){
    console.log(this.signup);
    if(this.signup.email == '' || this.signup.email == null){
      this.snack.open('Email is required' , '',{
        duration:3000,
      });
      return;
    }
    if(this.signup.password == '' || this.signup.email == null){
      this.snack.open('Password is required !!!', '',{
        duration:3000,
      });
      return;
    }
    if(this.signup.customername == ''|| this.signup.customername == null){
      this.snack.open('Customer Name is required !!!', '',{
        duration:3000,
      });
      return;
    }
    if(this.signup.address == ''|| this.signup.address == null){
      this.snack.open('Address is required !!!', '',{
        duration:3000,
      });
      return;
    }
    if(this.signup.phoneNo == '' || this.signup.phoneNo == null){
      this.snack.open('Mobile Number is required !!!', '',{
        duration:3000,
      });
      return;
    }
    // if(this.signup.role == '' || this.signup.role == null){
    //   this.snack.open('Role is required !!!', '',{
    //     duration:3000,
    //   });
    //   return;
    // }

    this.customerservice.createUser(this.signup).subscribe(
    (data)=>{
      Swal.fire('Success','Registration Successful','success');
      this.signup = {
        "customername":'',
        "username":'',
        "email":'',
        "password":'',
        "address":'',
        "phoneNo":'',
        "role":''
      };
    },
    (error) =>{
      Swal.fire("Error!!",'Error while adding User','error')
      console.log(error);
    });
  }

}
