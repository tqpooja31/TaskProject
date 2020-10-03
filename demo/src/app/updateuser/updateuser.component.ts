import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { ServletService } from '../servlet.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-updateuser',
  templateUrl: './updateuser.component.html',
  styleUrls: ['./updateuser.component.css']
})
export class UpdateuserComponent implements OnInit {

  // userform: FormGroup;
  constructor(public sc:ServletService,private a:ActivatedRoute,private r:Router) { }

  tp:number;
  task: any[] = [];

  list:any={}; 

  ngOnInit() {

    this.tp=this.a.snapshot.params['i'];

    this.sc.Viewdata().subscribe((d: any) =>
    {
      this.task = d

      for(let i=0;i<this.task.length;i++)
      {
        if(i==this.tp)
        {
          this.list=this.task[i];
          break;
        }
      }
    });

 
  }

  addtask()
  {
    
    this.sc.updateTask(this.list).subscribe(d=>
      {
         this.r.navigate(['/use']);
      });   

  }

}



