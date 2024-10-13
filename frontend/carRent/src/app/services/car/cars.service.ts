import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SHARESCONST } from 'src/app/url-constantes';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Brand } from 'src/app/entities/car/brand.interface';
import { CarFactory } from 'src/app/entities/car/car.factory';
import { CarDto } from 'src/app/entities/car/car.interface';
import { FiltersService } from '../forms/filters.service';


@Injectable({
  providedIn: 'root'
})
export class CarsService {
  private car : CarDto;
  private cars : CarDto[]=[];
  private brands : Brand[]=[
    {brand:'Toyota',picture:'/assets/images/toyota.jpg'},
    {brand:'Renault',picture:'/assets/images/renault.jpg'},
    {brand:'Peugeot',picture:'/assets/images/peugeot.jpg'}
  ]

  constructor(private http: HttpClient, private filtresService : FiltersService) {
    this.car = CarFactory.createCar();
   }

   getAvailableCarsByCity(city: string): Observable<CarDto[]> {
    const url = `${SHARESCONST.urlGetAvailableCarsByCity}/${city}`;
    const filters = this.filtresService.getFilters(); 
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });

    return this.http.post<CarDto[]>(url, filters, { headers: headers, withCredentials: true });
  }


   getAvailableCarsByBrand(brand:string):Observable<CarDto[]> {
    const url = SHARESCONST.urlGetAvailableCarsByBrand + "/" + brand;
    return this.http.get<CarDto[]>(url,{withCredentials:true});
   }

   getAvailableCars():Observable<CarDto[]> {
    const url = SHARESCONST.urlGetAvailableCars;
    return this.http.get<CarDto[]>(url,{withCredentials:true});
   }

   getCarById(carId : number):Observable<CarDto>{
    const url = SHARESCONST.urlGetCarById+ "/" + carId;
    return this.http.get<CarDto>(url,{withCredentials:true});
   }


   getCar():CarDto{
    return this.car;
   }

   setCar(car: CarDto):void{
    this.car = car;
   }

   getCars():CarDto[]{
    return this.cars;
   }

   setCars(cars : CarDto[]):void{
    this.cars =  cars;
   }

   getBrands():Brand[]{
    return this.brands;
   }

}
