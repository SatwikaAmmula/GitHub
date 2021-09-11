import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Application } from 'src/models/Application';
import { LicenseService } from '../service/license.service';

@Component({
  selector: 'app-application',
  templateUrl: './application.component.html',
  styleUrls: ['./application.component.css']
})
export class ApplicationComponent implements OnInit {
  message: string = null;
  failMessage: string;
  validationMessages:string
  msgClass: string;
  applicationNumber: number
  application:Application={
    address: null,
    addressProof: null,
    applicationNumber: null,
    dateOfBirth: null,
    firstName: null,
    gender: null,
    idProof: null,
    lastName: null,
    mobile: null,
    nationality: null,
    type: null,
    vehicleNumber: null,
    vehicleType: null,
    status: null
  }


  constructor(private service: LicenseService,
    private router: Router,
    private route:ActivatedRoute,
    ) { }

  ngOnInit() {
    this.route.paramMap.subscribe(
      (params)=>{
        this.applicationNumber = parseInt(params.get('applicationNumber'))
        console.log(this.applicationNumber)
         this.service.getApplication(this.applicationNumber).subscribe(
           (data)=> {
            this.application=data
            console.log(this.application)
            
           },
           (fail)=>{
             this.failMessage=fail.error.errorMessage
           }
         )
      }  
    )
  }

 update(){
    this.service.renewLL(this.application).subscribe(
      (data)=>{
        this.message= data.message
        this.msgClass = 'alert alert-success'
        this.validationMessages=null;
      },
      (fail)=>{
       this.message = fail.error.errorMessage;
       this.validationMessages=fail.error.errors;
       this.msgClass = 'alert alert-danger'
 
      }
    )
  }
  goToHome(){
    this.router.navigate(["home"])
  }
  }

