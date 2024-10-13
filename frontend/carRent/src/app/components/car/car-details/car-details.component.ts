import { Component, OnInit } from '@angular/core';
import { CarDto } from 'src/app/entities/car/car.interface';
import { CarsService } from 'src/app/services/car/cars.service';


@Component({
  selector: 'app-car-details',
  templateUrl: './car-details.component.html',
  styleUrls: ['./car-details.component.css']
})
export class CarDetailsComponent implements OnInit {

  car : CarDto;
  constructor(private carService : CarsService) { 
    this.car = this.carService.getCar();
  }

  ngOnInit(): void {
  }

}
