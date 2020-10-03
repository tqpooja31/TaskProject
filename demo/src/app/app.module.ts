import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignupComponent } from './signup/signup.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';

import { UserComponent } from './user/user.component';
import { Routes,RouterModule } from '@angular/router';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { UpdateuserComponent } from './updateuser/updateuser.component';
import { AddtaskComponent } from './addtask/addtask.component';
import { AdminComponent } from './admin/admin.component';
import { ServletService } from './servlet.service';

import { AdminchartComponent } from './adminchart/adminchart.component';

const approutes: Routes = [
 { path: 'login', component: LoginComponent },
 { path: 'sign', component: SignupComponent },
 { path: 'admin', component: AdminComponent },
 { path: 'add', component: AddtaskComponent },
  { path: 'use', component: UserComponent },
 { path: 'chart', component: AdminchartComponent },
 { path: 'user/:i', component: UpdateuserComponent },
 { path: '', redirectTo: '/login', pathMatch: 'full' },
 { path: '**', component: PagenotfoundComponent }
];



@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    LoginComponent,
    UserComponent,
    PagenotfoundComponent,
    UpdateuserComponent,
    AddtaskComponent,
    AdminComponent,
   
    AdminchartComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,HttpClientModule,FormsModule,ReactiveFormsModule,RouterModule.forRoot(approutes)
  ],
  providers: [ServletService],
  bootstrap: [AppComponent]
})
export class AppModule { }
