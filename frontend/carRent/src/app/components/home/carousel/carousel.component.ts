import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Brand } from 'src/app/entities/car/brand.interface';
import { CarsService } from 'src/app/services/car/cars.service';


@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.css']
})
export class CarouselComponent implements OnInit {
  brands : Brand[];
  currentImageIndex= 0;

  constructor(private carsService : CarsService,private router : Router) { 
    this.brands=this.carsService.getBrands();
  }

  ngOnInit(): void {
  }

  getAvailableCarsByBrand(brand:string):void{
    this.carsService.getAvailableCarsByBrand(brand).subscribe({
      next : (response)=>{
        this.carsService.setCars(response);
        this.router.navigate(['/carsList']);
      },
      error:(error)=>{
        console.log(error);
      }
    })
  }

  suivant(): void {
    this.currentImageIndex = (this.currentImageIndex + 1) % this.brands.length;
  }
  
  precedent(): void {
    this.currentImageIndex = (this.currentImageIndex - 1 + this.brands.length) % this.brands.length;
  }

}
