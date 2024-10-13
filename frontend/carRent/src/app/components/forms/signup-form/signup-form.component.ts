import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { userFactory } from 'src/app/entities/shares/user.factory';
import { User } from 'src/app/entities/shares/user.interface';
import { UserRegistration } from 'src/app/entities/shares/user.registration';
import { UserRegistrationFactory } from 'src/app/entities/shares/user.registration.factory';
import { SignupService } from 'src/app/services/forms/signup.service';
import { UserService } from 'src/app/services/shares/user.service';


@Component({
  selector: 'app-signup-form',
  templateUrl: './signup-form.component.html',
  styleUrls: ['./signup-form.component.css']
})
export class SignupFormComponent implements OnInit {

  user : User;
  userRegistration : UserRegistration;
  passwordConfirm : string;
  constructor(private signupService : SignupService, private router : Router, private userService : UserService) {
    this.user =userFactory.createUser();
    this.userRegistration = UserRegistrationFactory.createUser();
    this.passwordConfirm = "";
   }

  ngOnInit(): void {
  }

  onSubmit():void{
    if (this.userRegistration.pwd===this.passwordConfirm){
      this.signupService.signup(this.userRegistration).subscribe({
        next:response=>{
          console.log(response);
          const authHeader = response.headers.get('Authorization');
          if (authHeader) {
            const token = authHeader.replace('Bearer ', '');
            this.signupService.storeToken(token);
            this.router.navigate(['/authorized']);
            const responseBody = JSON.parse(response.body);
            this.userService.setUser(responseBody);
          }
          this.router.navigate(['/authorized'])
        },
        error : err=>{
          console.log(err);
        }
      })
    } 
    else{
      console.error("passwords are differents");
    }
  }

}
