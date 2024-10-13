import { Injectable } from '@angular/core';
import { BehaviorSubject} from 'rxjs';
import { HttpClient} from '@angular/common/http';

import {  Router } from '@angular/router';
import { User } from 'src/app/entities/shares/user.interface';
import { userFactory } from 'src/app/entities/shares/user.factory';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  private isAuthenticate = new BehaviorSubject<boolean>(false)
  private user : User;

  constructor(private http :  HttpClient, private route : Router) {
    this.user = userFactory.createUser();
  }

  getUser():User{
    return this.user;
  }

  setUser(user : User){
    this.user=user;
  }

  getIsAuthenticate():boolean{
    return this.isAuthenticate.value;
  }

  setIsAuthenticate(isAuthenticate : boolean):void{
    this.isAuthenticate.next(isAuthenticate);
  }

  getIsAuthenticateAsObservable():BehaviorSubject<boolean>{
    return this.isAuthenticate;
  }
  


}
