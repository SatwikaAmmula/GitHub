import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateNewuserComponent } from './create-newuser/create-newuser.component';
import { CreateApplicationComponent } from './create-application/create-application.component';
import { CreateAppointmentComponent } from './create-appointment/create-appointment.component';
import { RtoOfficerloginComponent } from './rto-officerlogin/rto-officerlogin.component';
import { GetallapplicationsComponent } from './getallapplications/getallapplications.component';
import { CreateLLComponent } from './create-ll/create-ll.component';
import { CreateDLComponent } from './create-dl/create-dl.component';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { LicenseComponent } from './license/license.component';
import { ApplicationComponent } from './application/application.component';
import { GetchallanComponent } from './getchallan/getchallan.component';
import { UserloginComponent } from './userlogin/userlogin.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateNewuserComponent,
    CreateApplicationComponent,
    CreateAppointmentComponent,
    RtoOfficerloginComponent,
    GetallapplicationsComponent,
    CreateLLComponent,
    CreateDLComponent,
    HomeComponent,
    LicenseComponent,
    ApplicationComponent,
    GetchallanComponent,
    UserloginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
