import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { HttpClient, HttpResponse } from '@angular/common/http';
import { SHARESCONST } from 'src/app/url-constantes';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http : HttpClient) { }

   authenticate(email:string,password:string):Observable<HttpResponse<any>>{
    const url = SHARESCONST.urlLogin;
    const formData: FormData = new FormData();
    formData.append('username',email);
    formData.append('password', password);
    return this.http.post<any>(url, formData, { observe: 'response', withCredentials: true , responseType: 'text' as 'json' });
  }

  storeToken(token:string):void{
    localStorage.setItem('currentUserToken', token);
  }


}
