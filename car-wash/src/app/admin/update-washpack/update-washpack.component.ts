import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { WashpackService } from 'src/app/service/washpack.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-washpack',
  templateUrl: './update-washpack.component.html',
  styleUrls: ['./update-washpack.component.css']
})
export class UpdateWashpackComponent implements OnInit {
  constructor(private _route:ActivatedRoute,private _wash:WashpackService) { }
  id= 0;
  wash:any;

  ngOnInit(): void {
   this.id = this._route.snapshot.params['wid'];
   this._wash.getwashpack(this.id).subscribe(
     (data:any)=>{
       this.wash=data;
       console.log(this.wash);
     },
     (error)=>{
       console.log(error);
     }
   )

  }
  //Update form Submit 
  public updateData(){
   //validate 
   this._wash.updatewashpack(this.wash).subscribe(
     (data)=>{
       Swal.fire("Success !!","WashPack Updated",'success');
     },(error)=>
     {
       Swal.fire('Error','Error in updating WashPack','error');
       console.log(error);
     })

  }

}

