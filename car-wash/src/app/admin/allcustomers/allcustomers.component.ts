import { Component, OnInit } from '@angular/core';
import { AdminserviceService } from 'src/app/service/adminservice.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-allcustomers',
  templateUrl: './allcustomers.component.html',
  styleUrls: ['./allcustomers.component.css']
})
export class AllcustomersComponent implements OnInit {
  Customer = [{
    customername:'',
    email:'',
    password:'',
    address:'',
    phoneNo:''
  }
]

  constructor(private admin: AdminserviceService) { }

  ngOnInit(): void {
    this.admin.allcustomers().subscribe(
      (data:any)=>{
        this.Customer=data;
        console.log(this.Customer)
      },
      (error)=>{
        console.log(error);
        Swal.fire('Error',"Error in loading data");
      }
    );
  }

}
