import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CarFactory } from 'src/app/entities/car/car.factory';
import { CarDto } from 'src/app/entities/car/car.interface';
import { CarsService } from 'src/app/services/car/cars.service';
import { ReservationService } from 'src/app/services/car/reservation.service';


@Component({
  selector: 'app-car-showed',
  templateUrl: './car-showed.component.html',
  styleUrls: ['./car-showed.component.css']
})
export class CarShowedComponent implements OnInit {
  @Input() car : CarDto;

  constructor(private reservationService : ReservationService , private carService : CarsService, private router : Router) {
    this.car=CarFactory.createCar();
   }

  ngOnInit(): void {
  }
  navigateToDetails():void{
    this.carService.getCarById(this.car.id).subscribe({
      next:(response)=>{
        console.log(response);
        this.carService.setCar(response);
        this.reservationService.setCityReservation(this.carService.getCar().city);
        this.router.navigate(['/carDetails']); 
      },
      error : (err)=>{
        console.log(err);
      }
    })
  }

}
