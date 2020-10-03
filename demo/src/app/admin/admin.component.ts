import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServletService } from '../servlet.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(public sc:ServletService,private r:Router) { }
 admin:any=[];
 
  ngOnInit() {
    this.fetchdata();
  }
  fetchdata()
  {
    this.sc.ViewloginUser().subscribe((d:any) => this.admin=d);
  }

  go()
     {
       this.r.navigate(['/login'])
     }


     changeValue(e)
     {
       alert(e);
       this.sc.updateAdminStatus(e).subscribe((d)=>{ 
     
        this.fetchdata();
       });

       }

       report()
       {
        this.r.navigate(['/chart'])
       }
    }