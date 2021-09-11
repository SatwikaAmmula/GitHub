import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Application } from 'src/models/Application';
import { Appointment } from 'src/models/Appointment';
import { LicenseService } from '../service/license.service';

@Component({
  selector: 'app-create-appointment',
  templateUrl: './create-appointment.component.html',
  styleUrls: ['./create-appointment.component.css']
})
export class CreateAppointmentComponent implements OnInit {

  message: string = null;
  msgClass: string;
  failMessage:string;
  validationMessages:string[]=null;
  applicationNumber:number;
  application:Application

  constructor(private service: LicenseService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.route.paramMap.subscribe(
      (params)=>{
        this.applicationNumber = parseInt(params.get('applicationNumber'))
         this.service.getApplication(this.applicationNumber).subscribe(
           (data)=> {

            this.applicationNumber = parseInt(params.get('applicationNumber'))
           },
           (fail)=>{
             this.failMessage=fail.error.errorMessage
           }
         )
      }  
    )
  }

  bookSlot(data:Appointment){
    this.service.bookSlot(this.applicationNumber,data).subscribe(
      (success)=>{
        this.message=success.message
       this.msgClass = 'alert alert-success'
       this.validationMessages=null;
       },
       (fail)=>{
       this.message = fail.error.errorMessage
       this.validationMessages=fail.error.errors
        this.msgClass = 'alert alert-danger' 
      }
    )
      
  }
}
