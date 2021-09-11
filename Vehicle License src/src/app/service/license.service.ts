import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Application } from 'src/models/Application';
import { Appointment } from 'src/models/Appointment';

@Injectable({
  providedIn: 'root'
})
export class LicenseService {


  private applyForLLURL= 'http://localhost:8080/license/LL';
  private applyForDLURL= 'http://localhost:8080/license/DL';
  private renewLLURL= 'http://localhost:8080/license/updateLL';
  private renewDLURL= 'http://localhost:8080/license/updateDL';
  private payFeesURL= 'http://localhost:8080/license/payFees';
  private checkChallanURL= 'http://localhost:8080/license/check';
  private payChallanUrl = 'http://localhost:8080/license/pay';
  private boolSlotUrl = 'http://localhost:8080/license/updateSlotTest';
  private cancelAppointmentUrl= 'http://localhost:8080/license/cancelAppointment';
  private getApplicationUrl= 'http://localhost:8080/license';

  constructor(private http: HttpClient) { }

  applyForLL(application: Application): Observable<any>{
   let url = `${this.applyForLLURL}`;
   return this.http.post(url,application) 
  }
  applyForDL(application: Application): Observable<any>{
    let url = `${this.applyForDLURL}`;
    return this.http.post(url,application) 
   }
   renewLL(application: Application):Observable<any>{
     let url= `${this.renewLLURL}`;
     return this.http.put(url,application)
   }
   
   renewDL(application: Application):Observable<any>{
    let url= `${this.renewDLURL}`;
    return this.http.put(url,application)
  }
  payFees(applicationNumber:number,amount:number):Observable<any>{
    let url= `${this.payFeesURL}/${applicationNumber}/${amount}`;
    return this.http.get(url);
  }

  checkChallan(vehicleNumber:string):Observable<any>{
    console.log(vehicleNumber)
    let url = `${this.checkChallanURL}/${vehicleNumber}`;
    return this.http.get(url)
  }
  payChallan(vehicleNumber: string): Observable<any>{
    let url =`${this.payChallanUrl}/${vehicleNumber}`;
    return this.http.get(url)
  }
  bookSlot(applicationNumber: number,appointment: Appointment):Observable<any>{
    let url = `${this.boolSlotUrl}/${applicationNumber}`;
    return this.http.put(url,appointment);
  }

  cancelAppointment(appointmentNumber: number):Observable<any>{
    let url= `${this.cancelAppointmentUrl}/${appointmentNumber}`;
    return this.http.delete(url)
  }

  getApplication(applicationNumber: number): Observable<any>{
    let url= `${this.getApplicationUrl}/${applicationNumber}`;
    return this.http.get(url)
  }
}
