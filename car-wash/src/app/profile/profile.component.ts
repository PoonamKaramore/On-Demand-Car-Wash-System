import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { AdminserviceService } from '../service/adminservice.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  profile = [{
    id: '',
    email:'',
    name:'',
    phone:'',
    role:''
  }];
  constructor(private admin:AdminserviceService) { }

  ngOnInit(): void {
    this.admin.getadmin().subscribe(
      (data:any)=>{
        this.profile=data;
        console.log(this.profile)
      },
      (error)=>{
        console.log(error);
        Swal.fire('Error',"Error in loading data");
      }

    )
  }

}
