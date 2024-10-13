import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SHARESCONST } from 'src/app/url-constantes';

@Injectable({
  providedIn: 'root'
})
export class LogoutService {

  constructor(private http : HttpClient) { }

  logout(): Observable<any>{
    const url = SHARESCONST.urlLogout;
    return this.http.post<any>(url,{ observe: 'response' });
  }

  clearTokens():void{
    localStorage.clear();
  }
  
}

