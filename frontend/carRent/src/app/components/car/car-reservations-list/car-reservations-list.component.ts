import { Component, Input, OnInit } from '@angular/core';
import { ReservationDto } from 'src/app/entities/shares/reservation.interface';
import { ReservationService } from 'src/app/services/car/reservation.service';

@Component({
  selector: 'app-car-reservations-list',
  templateUrl: './car-reservations-list.component.html',
  styleUrls: ['./car-reservations-list.component.css']
})
export class CarReservationsListComponent implements OnInit {
  reservations: ReservationDto[] = [];

  constructor(private reservationService: ReservationService) { }

  ngOnInit(): void {
    this.reservationService.reservations$.subscribe(reservations => {
      this.reservations = reservations;
    });
  }
}
