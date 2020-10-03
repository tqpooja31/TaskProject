import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServletService } from '../servlet.service';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  constructor(private r:Router,private c:ServletService) { }

  ngOnInit() {  }
  res:any={};
  
  go()
  {
    this.r.navigate(['/sign']);
  }

   add(x)
   {
   
    this.c.chklogin(x).subscribe(
      (e:any)=>
    {
      this.res=e;
      console.log("recieve response"+this.res+"="+e);
      if(this.res.result=="successfully")
      {
        localStorage.setItem("curr",JSON.stringify(x.email));
        alert("user is logging successfully");
        this.r.navigate(['/use']);
      }
      else if(this.res.result=="admin")
      {
        localStorage.setItem("curr",JSON.stringify(x.email));
        alert("admin is logging successfully");
        this.r.navigate(['/admin']);
      }
      else{
        alert("sorry,u cannot login...your account is deactivated");
      }
   
    });

    }

  }




