import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LogoutService } from 'src/app/services/shares/logout.service';
import { UserService } from 'src/app/services/shares/user.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private userService : UserService, private logoutService : LogoutService, private router : Router) { }

  ngOnInit(): void {
    this.logoutService.logout().subscribe({
      next : response=>{
        console.log(response);
        this.userService.setIsAuthenticate(false);
        this.logoutService.clearTokens();
        this.router.navigate(['/']);
      },
      error:err=>{
        console.log(err);
      }
    })
 

  }
}


