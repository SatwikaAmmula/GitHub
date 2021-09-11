import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';

import { Application } from 'src/models/Application';
import { Challan } from 'src/models/Challan';
import { LicenseService } from '../service/license.service';

@Component({
  selector: 'app-license',
  templateUrl: './license.component.html',
  styleUrls: ['./license.component.css']
})
export class LicenseComponent implements OnInit {

  applicationNumber:number=100;
  application: Application;
  challan:Challan
  vehicleNumber:string 
  
  

  constructor(private service:LicenseService,private router: Router) {
    
   }

  ngOnInit() {
    
  }

get(){
  console.log(this.applicationNumber);
}
}
