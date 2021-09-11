import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/models/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private userRegistrationUrl= 'http://localhost:8080/user/registration';
  private userLogin  = 'http://localhost:8080/user/login';
  private changePasswordUrl= 'http://localhost:8080/user/changePassword';
  private forgotPassword= 'http://localhost:8080/user/forgotPassword';
  private viewAllUsers = 'http://localhost:8080/user/viewall';
  
  constructor(private http: HttpClient) { }

  userRegistration(user:User):Observable<any>{
    return this.http.post(this.userRegistrationUrl,user)
  }

}
