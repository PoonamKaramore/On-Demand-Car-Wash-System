import { Component, HostListener, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { OrderService } from 'src/app/service/order.service';
import { WashpackService } from 'src/app/service/washpack.service';
import Swal from 'sweetalert2';
declare var Razorpay: any;
@Component({
  selector: 'app-add-order',
  templateUrl: './add-order.component.html',
  styleUrls: ['./add-order.component.css']
})
export class AddOrderComponent implements OnInit {

  Order = {
    "orderId":"",
      "customername":"",
      "address":"",
      "phoneNo":"",
      "carname":"",
      "carnumber":"",
      "washpack":"",
      "date":"",
      "time":"",
      "totalamount":"",
      "paymentStatus":""
  }
  constructor(private _wash:WashpackService,private _add:OrderService , private route:ActivatedRoute, private snack:MatSnackBar ) { }
  
  id= 0;
  wash:any;
  ngOnInit(): void {
    this.id = this.route.snapshot.params['wid'];
   this._wash.getwashpack(this.id).subscribe(
     (data:any)=>{
       this.wash=data;
       console.log(this.wash);
       this.Order.washpack = this.wash.name;
        this. Order.totalamount= this.wash.cost;
     },
     (error)=>{
       console.log(error);
     }
   )
  }
  addOrder()
  {
    if(this.Order.customername.trim()=='' || this.Order.customername==null)
    {
      this.snack.open("WashPack Name Required","",{
        duration:3000,

      });
      return;
    }
    //to add data from server
    this._add.addorders(this.Order).subscribe(
      (data)=>{
        Swal.fire('Success','Order is Added','success');
        this. Order=
        {
          "orderId":"",
          "customername":"",
          "address":"",
          "phoneNo":"",
          "carname":"",
          "carnumber":"",
          "washpack":"",
          "date":"",
          "time":"",
          "totalamount":"",
          "paymentStatus":""
      }

      },
    (error)=>{
      Swal.fire("Error!!",'Error while adding Order','error')
      console.log(error)
    })
  }

  //payment 

  message:any = "Not yet stared";
  paymentId = "";
  error = "";
  title = 'angular-razorpay-intergration';
  options = {
    "key": "rzp_test_YYTI03jzBeqehR",
    "amount": "200000",
    "name": "Poonam Karamore",
    "description": "Web Development",
    "image": "/assets/default_image.png",
    "order_id": "",
    "handler": function (response: any) {
      var event = new CustomEvent("payment.success",
        {
          detail: response,
          bubbles: true,
          cancelable: true
        }
      );
      window.dispatchEvent(event);
    },
    "postfill": {
      "amount":"",
      "name": "",
      "email": "",
      "contact": ""
    },
    "notes": {
      "address": ""
    },
    "theme": {
      "color": "#3399cc"
    }
  };

  paynow() {
    this.paymentId = '';
    this.error = '';
    this.options.postfill.amount = ""; 
    this.options.postfill.name = "";
    this.options.postfill.email = "";
    this.options.postfill.contact = "";
    var rzp1 = new Razorpay(this.options);
    rzp1.open();
    rzp1.on('payment.failed', function (response: any) {
      //this.message = "Payment Failed";
      // Todo - store this information in the server
      console.log(response.error.code);
      console.log(response.error.description);
      console.log(response.error.source);
      console.log(response.error.step);
      console.log(response.error.reason);
      console.log(response.error.metadata.order_id);
      console.log(response.error.metadata.payment_id);
      //this.error = response.error.reason;
    }
    );
  }
  @HostListener('window:payment.success', ['$event'])
  onPaymentSuccess(event: any): void {
    this.message = "Success Payment";
  }

}
