import { Component, OnInit, AfterViewInit } from '@angular/core';
import * as L from 'leaflet';
import { Router } from '@angular/router';
import { CarsService } from 'src/app/services/car/cars.service';
import { CarDto } from 'src/app/entities/car/car.interface';



@Component({
  selector: 'app-map-car',
  templateUrl: './map-car.component.html',
  styleUrls: ['./map-car.component.css']
})
export class MapCarComponent implements OnInit, AfterViewInit {
  cars: CarDto[] = [];
  car : CarDto;
  constructor(
    private carService: CarsService,
    private router: Router 
  ) {
    this.cars = this.carService.getCars();
    this.car = this.carService.getCar();
  }

  ngOnInit(): void {}
  
  ngAfterViewInit(): void {
    const map = L.map('map').setView([48.8566, 2.3522], 15);
    
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      attribution: '© OpenStreetMap contributors'
    }).addTo(map);
  
    this.cars.forEach(car => {
      const imageUrl = car.carCaracteristicsDto.img; 

      const bubbleHtml = `
        <div style="background-color: white; border-radius: 50%; width: 25; height: 25px; display: flex; align-items: center; justify-content: center; box-shadow: 0 1px 6px rgba(0,0,0,0.25); font-size: 16px;">
          €${car.price}
        </div>`;

      const customIcon = L.divIcon({
        html: bubbleHtml,
        className: 'custom-price-bubble',
        iconSize: L.point(80, 80),
        iconAnchor: [40, 40]
      });
  

      const marker = L.marker([car.latitude, car.longitude], {icon: customIcon}).addTo(map);
      const popupContent = `
      <div>
      <h2>${car.brand} - ${car.model}</h2>
      <img src="${imageUrl}" alt="carImg" style="max-width: 100%; height: auto;">
      <div style="display: flex; justify-content: space-between; align-items: center;">
        <h3>price : €${car.price}</h3>
        <h3 class="rating">rating : ${car.rating}</h3>
      </div>
      <button id="navigateButton${car.id}">Plus d'infos</button>
    </div>
    
      `;
      marker.bindPopup(popupContent);
  
      marker.on('popupopen', () => {
        const navigateButton = document.getElementById(`navigateButton${car.id}`);
        if (navigateButton) {
          const clickHandler = () => this.navigateToDetails(car.id);
          navigateButton.addEventListener('click', clickHandler);
          marker.on('popupclose', () => {
            if (navigateButton) {
              navigateButton.removeEventListener('click', clickHandler);
            }
          });
        }
      });
    });
  }
  
  navigateToDetails(carId: number) {
    this.carService.getCarById(carId).subscribe({
      next:data=>{
        this.carService.setCar(data);
        this.router.navigate(['/carDetails']); 
      }
    })
  }
  
}
