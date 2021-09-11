import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Challan } from 'src/models/Challan';
import { LicenseService } from '../service/license.service';

@Component({
  selector: 'app-getchallan',
  templateUrl: './getchallan.component.html',
  styleUrls: ['./getchallan.component.css']
})
export class GetchallanComponent implements OnInit {

  message: string = null;
  validationMessages: any;
  msgClass:string;
  vehicleNumber:string
  failMessage:string
  challan:Challan={challanNumber: null,
  vehicleNumber: null,
  amount: null
  }
  constructor(private service: LicenseService,
    private route:ActivatedRoute) { }

  ngOnInit() {
    this.route.paramMap.subscribe(
      (params)=>{
        this.vehicleNumber = params.get('vehicleNumber')
        console.log(this.vehicleNumber)
         this.service.checkChallan(this.vehicleNumber).subscribe(
           (data)=> {
           this.challan=data
           },
           (fail)=>{
             this.failMessage=fail.error.errorMessage
           }
         )
      }  
    )
  }
 
}
