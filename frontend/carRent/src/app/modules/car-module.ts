import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CarsListComponent } from '../components/car/cars-list/cars-list.component';
import { CarDetailsComponent } from '../components/car/car-details/car-details.component';
import { CarShowedComponent } from '../components/car/car-showed/car-showed.component';
import { MapCarComponent } from '../components/car/map-car/map-car.component';
import { CarCaracteristicsComponent } from '../components/car/car-caracteristics/car-caracteristics.component';
import { CustomFormsModule } from './forms.module';
import { CarReservationComponent } from '../components/car/car-reservation/car-reservation.component';
import { CarReservationsListComponent } from '../components/car/car-reservations-list/car-reservations-list.component';
import { CarBasketListComponent } from '../components/car/car-basket-list/car-basket-list.component';
import { CarBasketComponent } from '../components/car/car-basket/car-basket.component';


@NgModule({
  declarations: [
   CarsListComponent,
   CarDetailsComponent,
   CarShowedComponent,
   MapCarComponent,
   CarCaracteristicsComponent,
   CarReservationComponent,
   CarReservationsListComponent,
   CarBasketListComponent,
  CarBasketComponent

  ],
  imports: [
    CommonModule,
    CustomFormsModule

  ],
  providers: [
   
  ],
  exports: [
    CarsListComponent,
    CarDetailsComponent,
    CarShowedComponent,
    MapCarComponent,
    CarCaracteristicsComponent,
    CarReservationComponent,
    CarReservationsListComponent,
    CarBasketListComponent,
    CarBasketComponent

  ]
})
export class CarModule { }
``
