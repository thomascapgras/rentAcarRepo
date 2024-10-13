import { Component, OnInit } from '@angular/core';
import { CarDto } from 'src/app/entities/car/car.interface';
import { CarsService } from 'src/app/services/car/cars.service';
import { FiltersService } from 'src/app/services/forms/filters.service';


@Component({
  selector: 'app-cars-list',
  templateUrl: './cars-list.component.html',
  styleUrls: ['./cars-list.component.css']
})
export class CarsListComponent implements OnInit {
  cars : CarDto[]=[];
  constructor(private carsService : CarsService,private fitlersSerivice : FiltersService) { 
    this.cars = this.carsService.getCars();
  }

  ngOnInit(): void {
    console.log(this.fitlersSerivice.getFilters());
  }

}
