import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ServletService {

  constructor(public hc: HttpClient) { }



  AddData(value) {
    return this.hc.post("http://localhost:8080/MiniServletProject/Addsignup", value);
  }


  chklogin(x) {
    
    return this.hc.post("http://localhost:8080/MiniServletProject/LoginServet", x);
  }


  AddTask(value) {
    
    return this.hc.post("http://localhost:8080/MiniServletProject/AddTaskServlet", value);
  }

  
  Viewdata()
  {
    return this.hc.get("http://localhost:8080/MiniServletProject/ViewServlet");
  }

  DeleteTask(x) {
    
    return this.hc.post("http://localhost:8080/MiniServletProject/DeleteTaskServlet",x);
  }

  

  updateTask(x)
  {
    
    return this.hc.post("http://localhost:8080/MiniServletProject/UpdateTaskServlet",x);
  }

  ViewloginUser()
  {
    return this.hc.get("http://localhost:8080/MiniServletProject/UserDataServlet");
  }

  updateStatus(x)
  {
    
    return this.hc.post("http://localhost:8080/MiniServletProject/updateStatusServlet",x);
  }

  updateAdminStatus(x)
  {
    return this.hc.post("http://localhost:8080/MiniServletProject/UpdateAdminServlet",x);
  }

  ViewChart()
  {
    return this.hc.get("http://localhost:8080/MiniServletProject/ChartServlet");
  }

  EmailVerification(x)
  {
    return this.hc.post("http://localhost:8080/MiniServletProject/EmailVerificationServlet",x);
  }
}

