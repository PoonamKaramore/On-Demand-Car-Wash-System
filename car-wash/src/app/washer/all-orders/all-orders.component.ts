import { Component, OnInit } from '@angular/core';
import { OrderService } from 'src/app/service/order.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-all-orders',
  templateUrl: './all-orders.component.html',
  styleUrls: ['./all-orders.component.css']
})
export class AllOrdersComponent implements OnInit {

  orders = [{
    orderId: '',
    customername: '',
    address: '',
    phoneNo:'',
    carname:'',
    carnumber:'',
    washpack:'',
    date:'',
    time:''
  }
  ]
  constructor(private order:OrderService) { }

  ngOnInit(): void {
    this.order.getallorders().subscribe(
      (data:any)=>{
        this.orders=data;
        console.log(this.orders)
      },
      (error)=>{
        console.log(error);
        Swal.fire('Error',"Error in loading data");
      }
    )
  }

  // deleteorder(id:any){
  //   Swal.fire({
  //     icon:'warning',
  //     title:'Do you want to delete?',
  //     confirmButtonText:'Delete',
  //     showCancelButton:true,
  //   }).then((result)=>{
  //     if(result.isConfirmed){
  //       this.order.deleteorder(id).subscribe(
  //       (data)=>{
  //       this.orders = this.orders.filter((order)=>order.id != id);
  //       Swal.fire('Success','WashPack deleted','success');
  //     },
  //     (error)=>{
  //       Swal.fire('Error!!!','Error deleting WashPack','error');
  //   });
  // }

}
