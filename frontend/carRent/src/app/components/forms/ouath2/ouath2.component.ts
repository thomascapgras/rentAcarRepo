import { Component, OnInit } from '@angular/core';
import { Oauth2Service } from 'src/app/services/forms/oauth2.service';


@Component({
  selector: 'app-ouath2',
  templateUrl: './ouath2.component.html',
  styleUrls: ['./ouath2.component.css']
})
export class Ouath2Component implements OnInit {

  constructor(private oauth2Service: Oauth2Service) {}

  ngOnInit(): void {
  }

  login() {
    this.oauth2Service.login();
  }

  logout() {
    this.oauth2Service.logout();
  }



  get accessToken() {
    return this.oauth2Service.accessToken;
  }

  get idToken() {
    return this.oauth2Service.idToken;
  }

}
