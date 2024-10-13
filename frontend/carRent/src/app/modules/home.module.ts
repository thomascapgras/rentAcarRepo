
import { CommonModule } from '@angular/common';

import { NgModule } from '@angular/core';
import { CarouselComponent } from '../components/home/carousel/carousel.component';
import { AllCarsComponent } from '../components/home/all-cars/all-cars.component';
import { HttpClientModule } from '@angular/common/http';






@NgModule({
  declarations: [
    CarouselComponent,
    AllCarsComponent
   
  ],
  imports: [
    CommonModule,
    HttpClientModule,
  
  ],
  providers: [

  ],
  exports: [
    CarouselComponent,
    AllCarsComponent
  ]
})
export class HomeModule { }
``
