import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ServletService } from '../servlet.service';
import { Router } from '@angular/router';
import { DatePipe } from '@angular/common'

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
  providers: [DatePipe]
})
export class SignupComponent implements OnInit {

  genders = [
    { name: 'Male ', val: 'Male' },
    { name: 'Female ', val: 'Female' },


  ];

  signupForm: FormGroup;

  constructor(public sc: ServletService, private r: Router, public datepipe: DatePipe) { }

  ngOnInit() {
    this.signupForm = new FormGroup({
      firstname: new FormControl('', [Validators.required]),
      lastname: new FormControl('', [Validators.required]),
      gender: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required]),
      dob: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required,
      Validators.pattern('(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!#^~%*?&]).{8,}')]),
      confirmpassword: new FormControl('', [Validators.required]),
      otp: new FormControl('', [Validators.required]),
    }

    );


  }
  adduser() {


    var dt = new Date(this.signupForm.value.dob);

    var year = dt.getFullYear();

    let d = new Date().getFullYear();

    var dif = d - year;


    alert(JSON.stringify(this.signupForm.value));


    if (dif >= 18) {
      alert("you are able to signup");

      if (this.generatedOTP == this.signupForm.value.otp)
       {
        if (this.signupForm.value.password == this.signupForm.value.confirmpassword)
         {

          this.sc.AddData(this.signupForm.value).subscribe((d) => { 
            this.my(d);
           });  
        } 
        else
         {
          alert("password nd confirmpassword should not be matched");
        }

      }
      else
       {
        alert("please verify your OTP");
      }
    }
    else 
    {
      alert("you are are not able to signup...your age is less than 18");
    }

  }

  my(d) {
    if (d.Msg == "successfully") {
      alert("successfully");
      this.r.navigate(['/login']);
    }
    else {
      alert("not successfully");
    }
  }

  generatedOTP;
  sendEmailVerification() {

    alert(this.signupForm.value.email);
    this.sc.EmailVerification(this.signupForm.value.email).subscribe((res: any) => {
      alert(JSON.stringify(res));
      this.generatedOTP = res.msg;
      alert(this.generatedOTP);

    });
  }


}


