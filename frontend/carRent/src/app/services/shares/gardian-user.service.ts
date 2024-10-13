import { Injectable } from '@angular/core';
import { UserService } from './user.service';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GardianUserService implements CanActivate{
  isAuthenticate : boolean;
  constructor(private userService : UserService) { 
    this.isAuthenticate = this.userService.getIsAuthenticate();
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean  {
    return  this.isAuthenticate;
  }


}
