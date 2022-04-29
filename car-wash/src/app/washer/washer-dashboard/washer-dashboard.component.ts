import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-washer-dashboard',
  templateUrl: './washer-dashboard.component.html',
  styleUrls: ['./washer-dashboard.component.css']
})
export class WasherDashboardComponent implements OnInit {

  // @Output() togglesidebarf: EventEmitter<any> = new EventEmitter(); 
  // constructor(private router:Router) { }

  ngOnInit(): void {
  }
  // togglesidebar(){
  //   this.togglesidebarf.emit();
  // }

}
