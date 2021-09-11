import { ApplicationInitStatus, Component, OnInit } from '@angular/core';
import { Application } from 'src/models/Application';
import { RtoService } from '../service/rto.service';

@Component({
  selector: 'app-getallapplications',
  templateUrl: './getallapplications.component.html',
  styleUrls: ['./getallapplications.component.css']
})
export class GetallapplicationsComponent implements OnInit {
  applications: Application[];
  message: string = null;
  failMessage: string = null;

  constructor(private service: RtoService){}

  ngOnInit() {
    this.loadData();
  }
 
  loadData(): void {
    this.service.getApplications().subscribe(
      (data)=> { 
        this.applications =data;
      this.message=null
    },
      (errorRespnse)=>{
        this.message = errorRespnse.error.errorMessage
      }
    )
  }

}
