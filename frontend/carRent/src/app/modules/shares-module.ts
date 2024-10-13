import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from '../components/shares/home/home.component';
import { LoginComponent } from '../components/shares/login/login.component';
import { LogoutComponent } from '../components/shares/logout/logout.component';
import { MyProfileComponent } from '../components/shares/my-profile/my-profile.component';
import { NavbarComponent } from '../components/shares/navbar/navbar.component';
import { SignupComponent } from '../components/shares/signup/signup.component';
import { FooterComponent } from '../components/shares/footer/footer.component';
import { ContactComponent } from '../components/shares/contact/contact.component';
import { ContactModalComponent } from '../components/shares/modals/contact-modal/contact-modal.component';
import { HttpClientModule } from '@angular/common/http';
import { HomeModule } from './home.module';
import { CustomFormsModule } from './forms.module';
import { CarModule } from './car-module';




@NgModule({
  declarations: [
    HomeComponent,
    LoginComponent,
    LogoutComponent,
    MyProfileComponent,
    NavbarComponent,
    SignupComponent,
    FooterComponent,
    ContactComponent,
    ContactModalComponent
   
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    HomeModule,
    CustomFormsModule,
    CarModule
   
  ],
  providers: [

  ],
  exports: [
    HomeComponent,
    LoginComponent,
    LogoutComponent,
    MyProfileComponent,
    NavbarComponent,
    SignupComponent,
    FooterComponent,
    ContactComponent,
    ContactModalComponent
  ]
})
export class SharesModule { }
``
