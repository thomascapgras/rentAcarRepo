import { Injectable } from '@angular/core';
import { FiltersFactory } from 'src/app/entities/car/filters.factory';
import { FiltersDto } from 'src/app/entities/car/filters.interface';

@Injectable({
  providedIn: 'root'
})
export class FiltersService {

  private filters: FiltersDto;

  constructor() {
    this.filters = FiltersFactory.createFilters();
  }

  public getFilters(): FiltersDto {
    return this.filters;
  }

  public setFilters(filters: FiltersDto): void {
    this.filters = filters;
  }

  public setMaxPrice(maxPrice: number): void {
    this.filters.maxPrice = maxPrice;
  }

  public setMinPrice(minPrice: number): void {
    this.filters.minPrice = minPrice;
  }

  public setGps(gps: boolean): void {
    this.filters.gps = gps;
  }

  public setBackupCamera(backupCamera: boolean): void {
    this.filters.backupCamera = backupCamera;
  }

  public setManualTransmission(manualTransmission: boolean): void {
    this.filters.manualTransmission = manualTransmission;
  }

  public setBluetooth(bluetooth: boolean): void {
    this.filters.bluetooth = bluetooth;
  }

  public resetFilters():void{
    this.filters = FiltersFactory.createFilters();
  }
}
