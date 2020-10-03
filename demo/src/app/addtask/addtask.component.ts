import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ServletService } from '../servlet.service';

@Component({
  selector: 'app-addtask',
  templateUrl: './addtask.component.html',
  styleUrls: ['./addtask.component.css']
})
export class AddtaskComponent implements OnInit {
  taskForm:FormGroup;
  constructor(private r:Router,private hp:HttpClient,public sc: ServletService) { }

  ngOnInit() {
    this.taskForm = new FormGroup({
      tname : new FormControl(''),
      desc : new FormControl(''),
      });
  
  }
  tempObj:any={};
  addtask()
  {
  
      let temp=JSON.parse(localStorage.getItem("curr")); 
      this.tempObj.email=temp;
      this.tempObj.tname=this.taskForm.value.tname;
      this.tempObj.desc=this.taskForm.value.desc;

      alert(JSON.stringify(this.tempObj)); 
      this.sc.AddTask(this.tempObj).subscribe((d=>this.my(d)));      
}
  
    my(d) 
    {
      if (d.Msg == "successfully")
       {
        alert("successfully");
        this.r.navigate(['/use']);
      }
      else {
        alert("not successfully");
      }
    }
  
  }

