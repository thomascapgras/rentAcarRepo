import { Component, OnInit } from '@angular/core';
import {  Router } from '@angular/router';
import { LoginService } from 'src/app/services/forms/login.service';
import { UserService } from 'src/app/services/shares/user.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  email : string;
  password:string;
  constructor(private userService : UserService, private loginService : LoginService, private router : Router) {
    this.email="";
    this.password="";
   }

  ngOnInit(): void {
  }


  onSubmit():void{
    this.loginService.authenticate(this.email,this.password).subscribe({
      next: (response) => {
        const authHeader = response.headers.get('Authorization');
        console.log(response);
        if (authHeader) {
          const token = authHeader.replace('Bearer ', '');
          this.loginService.storeToken(token);
          const responseBody = JSON.parse(response.body);
          this.userService.setUser(responseBody) ;
          this.router.navigate(['/authorized']);
        }
      },
      error: (error) => {
        console.error(error);
  }});
  }

}
