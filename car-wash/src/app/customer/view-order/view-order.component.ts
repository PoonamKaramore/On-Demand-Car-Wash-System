import { Component, OnInit } from '@angular/core';
import { OrderService } from 'src/app/service/order.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-order',
  templateUrl: './view-order.component.html',
  styleUrls: ['./view-order.component.css']
})
export class ViewOrderComponent implements OnInit {
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
    this.order.getorder().subscribe(
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

}
