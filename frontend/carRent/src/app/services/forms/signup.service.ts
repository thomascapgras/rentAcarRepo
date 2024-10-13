import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserRegistration } from 'src/app/entities/shares/user.registration';
import { SHARESCONST } from 'src/app/url-constantes';

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  constructor(private http : HttpClient) { }

   signup(user:UserRegistration):Observable<any>{
    const url = SHARESCONST.urlSignUp;
    return this.http.post<any>(url, user, { observe: 'response', withCredentials: true , responseType: 'text' as 'json' });
   }

   storeToken(token:string):void{
    localStorage.setItem('currentUserToken', token);
  }
}
