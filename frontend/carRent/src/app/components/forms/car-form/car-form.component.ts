import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ReservationDto } from 'src/app/entities/shares/reservation.interface';
import { ReservationFactory } from 'src/app/entities/shares/reserversation.factory';
import { CarsService } from 'src/app/services/car/cars.service';
import { ReservationService } from 'src/app/services/car/reservation.service';
import { FiltersComponent } from '../modal/filters/filters.component';

@Component({
  selector: 'app-car-form',
  templateUrl: './car-form.component.html',
  styleUrls: ['./car-form.component.css']
})
export class CarFormComponent implements OnInit {
  reservation: ReservationDto;


  constructor(
    private reservationService: ReservationService,
    private carsService: CarsService,
    private router: Router,
    public dialog: MatDialog
  ) {
    this.reservation = ReservationFactory.createReservation();
  }

  ngOnInit(): void {}

  getAvailableCarsByCity(): void {
    console.log("test");
    this.carsService.getAvailableCarsByCity(this.reservation.city).subscribe({
      next: (response) => {
        console.log(response);
        this.carsService.setCars(response);
        this.reservationService.setReservation(this.reservation);
        this.router.navigate(['/carsList']);
      },
      error: (error) => {
        console.log(error);
      }
    });
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(FiltersComponent, {
      width: '60%',
      height: '50%'
    });

  }
}
