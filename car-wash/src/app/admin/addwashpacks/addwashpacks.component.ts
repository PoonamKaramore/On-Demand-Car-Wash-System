import { ReturnStatement } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { WashpackService } from 'src/app/service/washpack.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-addwashpacks',
  templateUrl: './addwashpacks.component.html',
  styleUrls: ['./addwashpacks.component.css']
})
export class AddwashpacksComponent implements OnInit {

  
  WashPackData={
    id: '',
    name: '',
    cost: '',
    description:''
  }

  constructor(private _snack:MatSnackBar,private _add:WashpackService) { }

  ngOnInit(): void {
  }

  addWashPack()
  {
    if(this.WashPackData.id =='' || this.WashPackData.id==null)
    {
      this._snack.open("Id is Required","",{
        duration:3000,

      });
      return;
    }
    if(this.WashPackData.name.trim()=='' || this.WashPackData.name==null)
    {
      this._snack.open("WashPack Name Required","",{
        duration:3000,

      });
      return;
    }
    if(this.WashPackData.cost == '' || this.WashPackData.cost == null){
      this._snack.open("Cost is Required !! " , "",{
        duration:3000,
      });
      return;
    }
    if(this.WashPackData.description == '' || this.WashPackData.description == null){
      this._snack.open("Description is Required !! " , "",{
        duration:3000,
      });
      return;
    }
    //to add data 
    this._add.addWashPack(this.WashPackData).subscribe(
      (data)=>{
        Swal.fire('Success','WashPack Added','success');
        this.WashPackData={
           "id": '',
           "name": '',
           "cost": '',
          "description":''         
        }

      },
    (error)=>{
      Swal.fire("Error!!",'Error while adding WashPack','error')
      console.log(error)
    })
  }

}
