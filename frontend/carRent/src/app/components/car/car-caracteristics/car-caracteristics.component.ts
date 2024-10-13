import { Component, Input, OnInit } from '@angular/core';
import { CarFactory } from 'src/app/entities/car/car.factory';
import { CarDto } from 'src/app/entities/car/car.interface';


@Component({
  selector: 'app-car-caracteristics',
  templateUrl: './car-caracteristics.component.html',
  styleUrls: ['./car-caracteristics.component.css']
})
export class CarCaracteristicsComponent implements OnInit {

  @Input() car : CarDto;
  constructor() { 
    this.car = CarFactory.createCar();
  }

  ngOnInit(): void {
  }

}
