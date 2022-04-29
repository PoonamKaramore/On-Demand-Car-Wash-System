import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { WashpackService } from 'src/app/service/washpack.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-washpacks',
  templateUrl: './washpacks.component.html',
  styleUrls: ['./washpacks.component.css']
})
export class WashpacksComponent implements OnInit {
  washpacks = [{
    id: '',
    name: '',
    cost: '',
    description:''
  }
  ];

  constructor(private wash :WashpackService) { }

  ngOnInit(): void {
    this.wash.washpacks().subscribe(
      (data:any)=>{
        this.washpacks=data;
        console.log(this.washpacks)
      },
      (error)=>{
        console.log(error);
        Swal.fire('Error',"Error in loading data");
      }
    );
  }
  deletewashpack(id:any){
    Swal.fire({
      icon:'warning',
      title:'Do you want to delete?',
      confirmButtonText:'Delete',
      showCancelButton:true,
    }).then((result)=>{
      if(result.isConfirmed){
        this.wash.deletewashpack(id).subscribe(
        (data)=>{
        this.washpacks = this.washpacks.filter((wash)=>wash.id != id);
        Swal.fire('Success','WashPack deleted','success');
      },
      (error)=>{
        Swal.fire('Error!!!','Error deleting WashPack','error');
    });
  }
})
}

}
