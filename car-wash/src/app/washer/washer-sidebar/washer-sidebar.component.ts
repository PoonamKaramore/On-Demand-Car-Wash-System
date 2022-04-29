import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { SidebarComponent } from 'src/app/admin/sidebar/sidebar.component';

@Component({
  selector: 'app-washer-sidebar',
  templateUrl: './washer-sidebar.component.html',
  styleUrls: ['./washer-sidebar.component.css']
})
export class WasherSidebarComponent implements OnInit {

  // collapsed = true;
  
  // togglesidebar():void{
  //   this.collapsed = !this.collapsed;
  // }
  // closesidebar():void{
  //   this.collapsed = true;
  // }
  constructor() { }


  ngOnInit(): void {}

}
