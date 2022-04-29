import { Component, OnInit } from '@angular/core';
import { RatingService } from 'src/app/service/rating.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-rating',
  templateUrl: './view-rating.component.html',
  styleUrls: ['./view-rating.component.css']
})
export class ViewRatingComponent implements OnInit {

  ratings=[{
    rating: "",
    comment: ""
 }
 ]

  constructor(private rate:RatingService) { }

  ngOnInit(): void {
  //   this.rate.getRatings().subscribe(
  //     (data:any)=>{
  //       this.ratings=data;
  //       console.log(this.ratings)
  //     },
  //     (error)=>{
  //       console.log(error);
  //       Swal.fire('Error',"Error in loading data");
  //     }

  //   )
   }

}
