import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { CarModule } from './modules/car-module';
import { SharesModule } from './modules/shares-module';
import { RedirectionsModule } from './modules/redirections.mofule';
import { MatDialogModule } from '@angular/material/dialog';
import { JwtInterceptor } from './interceptors/jwtinterceptor';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { OAuthModule } from 'angular-oauth2-oidc';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';




@NgModule({
  declarations: [
    AppComponent,



  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    CarModule,
    SharesModule,
    RedirectionsModule,
    MatDialogModule,
    OAuthModule.forRoot(),



  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
