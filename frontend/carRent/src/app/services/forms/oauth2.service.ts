import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthConfig, OAuthService } from 'angular-oauth2-oidc';
import { Observable } from 'rxjs';
import { SHARESCONST } from 'src/app/url-constantes';

export const authConfig: AuthConfig = {
  issuer: 'https://accounts.google.com',
  redirectUri: window.location.origin + '/authorized',
  clientId: '608984754576-5shgask4fm69npgqlc8aem4ao4q8sfjv.apps.googleusercontent.com',
  scope: 'openid profile email',
  strictDiscoveryDocumentValidation: false,
  showDebugInformation: true,
};

@Injectable({
  providedIn: 'root'
})
export class Oauth2Service {

  constructor(private oauthService: OAuthService, private http: HttpClient) {
    this.configure();
  }

  public configure() {
    this.oauthService.configure(authConfig);
    this.oauthService.setupAutomaticSilentRefresh();

    this.oauthService.events.subscribe(event => {
      if (event.type === 'token_received') {
        this.storeTokens();
      }
    });

    this.oauthService.loadDiscoveryDocumentAndTryLogin().then(() => {
      if (this.oauthService.hasValidAccessToken()) {
        this.storeTokens();
      }
    });
  }

  public login() {
    this.oauthService.initCodeFlow();
  }

  public logout() {
    this.clearTokens();
    this.oauthService.logOut();
  }

  private storeTokens() {
    const accessToken = this.oauthService.getAccessToken();
    const idToken = this.oauthService.getIdToken();
    if (accessToken && idToken) {
      localStorage.setItem('accessToken', accessToken);
      localStorage.setItem('idToken', idToken);
    }
  }

  private clearTokens() {
    localStorage.removeItem('accessToken');
    localStorage.removeItem('idToken');
  }

  public get identityClaims() {
    return this.oauthService.getIdentityClaims() || null;
  }

  public get accessToken() {
    return localStorage.getItem('accessToken') || this.oauthService.getAccessToken();
  }

  public get idToken() {
    return localStorage.getItem('idToken') || this.oauthService.getIdToken();
  }

  public loadDiscoveryDocumentAndTryLogin() {
    return this.oauthService.loadDiscoveryDocumentAndTryLogin();
  }

  public hasValidAccessToken() {
    return this.oauthService.hasValidAccessToken();
  }

  public saveOauth2User(token: string): Observable<HttpResponse<any>> {
    const url = SHARESCONST.urlSaveOauth2User;
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });

    return this.http.post<any>(url, null, { headers: headers, observe: 'response' });
  }
}
