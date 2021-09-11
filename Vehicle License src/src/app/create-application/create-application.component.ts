import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Application} from 'src/models/Application';
import { LicenseService } from '../service/license.service';


@Component({
  selector: 'app-create-application',
  templateUrl: './create-application.component.html',
  styleUrls: ['./create-application.component.css']
})
export class CreateApplicationComponent implements OnInit {
  message: string = null;
  failMessage: string;
  msgClass: string;
  applicationNumber:number;

  constructor(private service: LicenseService, 
    private route: ActivatedRoute,
    private router: Router,
    ) { }

  ngOnInit() {
    
      }
    

  createNewLL(data: Application){
    //let application = Object.assign(data,applicant)
    if(data.type == 'DL'){
    this.createNewDL(data)
    }
    else{
    this.service.applyForLL(data).subscribe(
      (success)=> {
        this.message = success.message
        this.msgClass = 'alert alert-success'
        console.log(this.message)
        console.log(data)
      },
      (fail)=> {
        this.message= fail.error.errorBody
        this.msgClass = 'alert alert-danger'
        console.log(fail)
      }
    )
    }
  }
  createNewDL(data: Application){
    this.service.applyForDL(data).subscribe(
      (success)=> {
        this.message = success.message
        this.msgClass = 'alert alert-success'
        console.log(success)
      },
      (fail)=> {
        this.failMessage=fail.error.errorMessage
        this.msgClass = 'alert alert-danger'
        console.log(fail)
      }
    )
  }

  btnClick(){
   /* this.route.paramMap.subscribe(
      (params)=>{
        this.applicationNumber = parseInt(params.get('applicationNumber'))
        console.log(this.applicationNumber)
      }
    )*/
    this.service.getApplication(this.applicationNumber).subscribe(
      (success)=> {
        this.message = success.message
        this.msgClass = 'alert alert-success'
        console.log(success)
      },
      (fail)=> {
        this.failMessage=fail.error.errorMessage
        this.msgClass = 'alert alert-danger'
        console.log(fail)
      } 
    )
  }
  goTo(){
    console.log(this.applicationNumber)
    this.router.navigate(["/","applicationNumber"])

  }
}

