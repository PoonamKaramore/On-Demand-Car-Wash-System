import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { RatingService } from 'src/app/service/rating.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-rating',
  templateUrl: './add-rating.component.html',
  styleUrls: ['./add-rating.component.css']
})
export class AddRatingComponent implements OnInit {

  ratings={
    "rating": "",
    "comment": ""
  }

  constructor(private snack:MatSnackBar,private add:RatingService) { }

  ngOnInit(): void {
  }
  addRating()
  {
    if(this.ratings.comment.trim()=='' || this.ratings.comment==null)
    {
      this.snack.open("Rating is Required","",{
        duration:3000,

      });
      return;
    }
    //to add data from server
    this.add.addRating(this.ratings).subscribe(
      (data)=>{
        Swal.fire('Success','Thanks For giving Rating','success');
        this.ratings={
          // "washerName":"",
          "rating": "",
          "comment": ""
        }

      },
    (error)=>{
      Swal.fire("Error!!",'Error while adding WashPack','error')
      console.log(error)
    })
  }

}
