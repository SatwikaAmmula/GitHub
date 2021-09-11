import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ApplicationComponent } from './application/application.component';
import { CreateApplicationComponent } from './create-application/create-application.component';
import { CreateAppointmentComponent } from './create-appointment/create-appointment.component';
import { CreateNewuserComponent } from './create-newuser/create-newuser.component';
import { GetallapplicationsComponent } from './getallapplications/getallapplications.component';
import { GetchallanComponent } from './getchallan/getchallan.component';
import { HomeComponent } from './home/home.component';
import { LicenseComponent } from './license/license.component';
import { RtoOfficerloginComponent } from './rto-officerlogin/rto-officerlogin.component';
import { UserloginComponent } from './userlogin/userlogin.component';



const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'create',component: CreateNewuserComponent},
  {path: 'userlogin', component: UserloginComponent},
  {path: 'rtoofficerlogin', component: RtoOfficerloginComponent},
  {path: 'details', component: LicenseComponent},
  {path : 'details/createNew', component: CreateApplicationComponent},
  {path : 'details/:applicationNumber', component: ApplicationComponent},
  {path: 'appointment/:applicationNumber', component: CreateAppointmentComponent},
  {path: 'challan', component: GetchallanComponent},
  {path: 'list', component: GetallapplicationsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
