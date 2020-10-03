import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServletService } from '../servlet.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private r:Router,public sc:ServletService) { }

  

  ngOnInit() {

    this.fetchdata();
  }

  user : any[]=[];
  userTask : any[];

  fetchdata(){
    
    let temp=JSON.parse(localStorage.getItem("curr")); 
    this.userTask=[];
    this.sc. Viewdata().subscribe((d:any) => {
      this.user = d;

      for(let i=0;i<this.user.length;i++)
      {
          if(this.user[i].email==temp)
          {
            this.userTask.push(this.user[i]);
          }
      }
    });
  }


     add(x)
     {
       this.r.navigate(['/add']);
     }

     go()
     {
       this.r.navigate(['/login'])
     }

     obj: any = {};
     deleteData(i) {
   
       this.obj.tid = this.user[i].tid;
       console.log(this.obj.tid);
   
       this.sc.DeleteTask(this.obj).subscribe(d=>
         {

           alert("deleted successfully")
           this.fetchdata();
       });
       
     }
   
     checkValue(e)
     {
       
       this.sc.updateStatus(e).subscribe((d)=>{ 
        this.fetchdata();
        alert("task status changed successfully");
       });
   
   
   }
}
