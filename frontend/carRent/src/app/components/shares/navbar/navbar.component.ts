import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {  Observable } from 'rxjs';
import { UserService } from 'src/app/services/shares/user.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  isAuthenticate : Observable<boolean> ;
  constructor(private router : Router, private userService : UserService) { 
    this.isAuthenticate = this.userService.getIsAuthenticateAsObservable();
  }

  ngOnInit(): void {
  }

  clickOnLogin():void{
    this.router.navigate(['/login']);
  }

  clickOnLogout():void{
    this.router.navigate(['/logout']);
  }

  clickOnSignup():void{
    this.router.navigate(['/signup']);
  }


  clickOnMyProfile():void{
    this.router.navigate(['/myProfile']);
  }

  clickOnHome():void{
    this.router.navigate(['/']);
  }


}
