import { Component, Input, OnInit } from '@angular/core';
import { ReservationDto } from 'src/app/entities/shares/reservation.interface';
import { ReservationFactory } from 'src/app/entities/shares/reserversation.factory';

@Component({
  selector: 'app-car-basket',
  templateUrl: './car-basket.component.html',
  styleUrls: ['./car-basket.component.css']
})
export class CarBasketComponent implements OnInit {
  @Input() reservation : ReservationDto;
  constructor() { 
    this.reservation = ReservationFactory.createReservation();
  }

  ngOnInit(): void {
  }

}
