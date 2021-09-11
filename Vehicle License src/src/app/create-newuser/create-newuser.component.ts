import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/models/User';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-create-newuser',
  templateUrl: './create-newuser.component.html',
  styleUrls: ['./create-newuser.component.css']
})
export class CreateNewuserComponent implements OnInit {

  message: string = null;
  validationMessages:string[]=null

  constructor(private service: UserService, private router:Router) { }

  ngOnInit() {
  }

  msgClass:string;

  createNew(user: User) {
    this.service.userRegistration(user).subscribe(
     (resp)=>{
      this.message = resp.message
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
}
