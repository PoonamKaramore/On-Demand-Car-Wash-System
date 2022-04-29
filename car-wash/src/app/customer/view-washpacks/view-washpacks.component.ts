import { Component, OnInit } from '@angular/core';
import { WashpackService } from 'src/app/service/washpack.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-washpacks',
  templateUrl: './view-washpacks.component.html',
  styleUrls: ['./view-washpacks.component.css']
})
export class ViewWashpacksComponent implements OnInit {

  washpacks = [{
    id: '',
    name: '',
    cost: '',
    description:''
  },
  ]

  constructor(private wash : WashpackService) { }

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

    )
  }

}
