import { HttpClient, HttpParams, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Contact } from 'src/app/entities/shares/contact.interface';
import { SHARESCONST } from 'src/app/url-constantes';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  constructor(private http: HttpClient) { }

  sendContact(contact : Contact): Observable<HttpResponse<any>> {
    const url = SHARESCONST.urlSaveContact;
    return this.http.post<any>(url, contact, { observe: 'response' });
  }
}
