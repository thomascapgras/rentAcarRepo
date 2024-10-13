import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CarsService } from 'src/app/services/car/cars.service';

@Component({
  selector: 'app-all-cars',
  templateUrl: './all-cars.component.html',
  styleUrls: ['./all-cars.component.css']
})
export class AllCarsComponent implements OnInit {

  constructor(private carsService : CarsService, private router : Router) { }

  ngOnInit(): void {
  }

  getAvailableCars():void{
    this.carsService.getAvailableCars().subscribe({
      next : (response)=>{
        this.carsService.setCars(response);
        console.log(this.carsService.getCars());
        this.router.navigate(['/carsList']);
      },
      error:(error)=>{
        console.log(error);
      }
    })
  }

}
