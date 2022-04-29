import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/service/customer.service';
import { LoginService } from 'src/app/service/login.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-customer-profile',
  templateUrl: './customer-profile.component.html',
  styleUrls: ['./customer-profile.component.css']
})
export class CustomerProfileComponent implements OnInit {

  profile = [{
    id:'',
    username:'',
    password:'',
    email:'',
    customername:'',
    address:'',
    phoneNo:''
  }];
  constructor(private login:LoginService) { }
    ngOnInit(): void {
      this.login.getCurrentUser().subscribe(
        (data:any)=>{
          this.profile=data;
          console.log(this.profile);
        },
        (error : any)=>{
          console.log(error);
          Swal.fire('Error',"Error in loading data");
        }
  
      )
    }

}
