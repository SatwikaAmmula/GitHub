import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RtoService {

  private officerLoginUrl = 'http://localhost:8080/rtoofficer/officerlogin';
  private viewAllPendingApplicationsUrl = 'http://localhost:8080/rtoofficer/list/Pending/Applications';
  private viewAllApprovedApplicationsUrl = 'http://localhost:8080/rtoofficer/list/Approved/Applications';
  private viewAllRejectedApplicationsUrl = 'http://localhost:8080/rtoofficer/list/Rejected/Application';
  private baseUrl = 'http://localhost:8080/rtoofficer';
  private generateLearnerLicenseUrl = 'http://localhost:8080/rtoofficer/LearnerLicense';
  private generateDrivingLicensegenerUrl = 'http://localhost:8080/rtoofficer/DrivingLicense';
  
  
  

  constructor(private http: HttpClient) { }

  getApplications():Observable<any>{
    return this.http.get(this.baseUrl);
  }
}
