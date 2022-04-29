import { Component, OnInit } from '@angular/core';
import { AdminserviceService } from 'src/app/service/adminservice.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-allwashers',
  templateUrl: './allwashers.component.html',
  styleUrls: ['./allwashers.component.css']
})
export class AllwashersComponent implements OnInit {

  Washer = [{
    washerId: '',
    email: '',
    password: '',
    name: '',
    phoneNo: ''
  }
  ] 
  constructor(private admin: AdminserviceService) { }

  ngOnInit(): void {
    this.admin.allwashers().subscribe(
      (data:any)=>{
        this.Washer=data;
        console.log(this.Washer)
      },
      (error)=>{
        console.log(error);
        Swal.fire('Error',"Error in loading data");
      }
    );
    }
}
