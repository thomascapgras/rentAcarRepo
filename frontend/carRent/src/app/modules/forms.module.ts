
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { MatDialogModule } from '@angular/material/dialog';
import { CarFormComponent } from '../components/forms/car-form/car-form.component';
import { ConfirmFormReservationComponent } from '../components/forms/confirm-form-reservation/confirm-form-reservation.component';
import { FormsModule } from '@angular/forms';
import { ContactFormComponent } from '../components/forms/contact-form/contact-form.component';
import { SignupFormComponent } from '../components/forms/signup-form/signup-form.component';
import { LoginFormComponent } from '../components/forms/login-form/login-form.component';
import { Ouath2Component } from '../components/forms/ouath2/ouath2.component';
import { LoginModalComponent } from '../components/forms/modal/login-modal/login-modal.component';
import { DeleteReservationModalComponent } from '../components/forms/modal/delete-reservation-modal/delete-reservation-modal.component';
import { MatIconModule } from '@angular/material/icon';
import { FiltersComponent } from '../components/forms/modal/filters/filters.component';
import { MatSliderModule } from '@angular/material/slider';
import { PriceRangeSliderComponent } from '../components/forms/price-range-slider/price-range-slider.component';
import { MatButtonModule } from '@angular/material/button';


@NgModule({
  declarations: [
    CarFormComponent,
    ConfirmFormReservationComponent,
    ContactFormComponent,
    SignupFormComponent,
    LoginFormComponent,
    Ouath2Component,
    LoginModalComponent,
    DeleteReservationModalComponent,
    FiltersComponent,
    PriceRangeSliderComponent,


  ],
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule,

    MatDialogModule,
    MatIconModule,
    MatSliderModule,
    MatButtonModule,


  
  ],
  providers: [

  ],
  exports: [
    CarFormComponent,
    ConfirmFormReservationComponent,
    ContactFormComponent,
    SignupFormComponent,
    LoginFormComponent,
    Ouath2Component,
    DeleteReservationModalComponent,
    FiltersComponent,
    PriceRangeSliderComponent
  ]
})
export class CustomFormsModule { }
``
