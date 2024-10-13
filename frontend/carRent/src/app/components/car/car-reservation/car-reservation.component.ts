import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ReservationDto } from 'src/app/entities/shares/reservation.interface';
import { ReservationFactory } from 'src/app/entities/shares/reserversation.factory';
import { DeleteReservationModalComponent } from '../../forms/modal/delete-reservation-modal/delete-reservation-modal.component';

@Component({
  selector: 'app-car-reservation',
  templateUrl: './car-reservation.component.html',
  styleUrls: ['./car-reservation.component.css']
})
export class CarReservationComponent implements OnInit {
  @Input() reservation : ReservationDto;
  totalPrice : number;
  constructor(private dialog: MatDialog) { 
    this.reservation = ReservationFactory.createReservation();
    this.totalPrice=0;
  }
  ngOnInit(): void {
    this.totalPriceCompute()
  }

  openDialog(): void {
    console.log("toto");
    const dialogRef = this.dialog.open(DeleteReservationModalComponent, {
      width: '30%', 
      data: { reservationId: this.reservation.id }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('the modal has been closed');
    });
  }

  totalPriceCompute():void{
    const departureDate = new Date(this.reservation.departureDate);
    const returnDate =new Date(this.reservation.returnDate);
    const price = this.reservation.carDto.price;
    const difference = returnDate.getTime() - departureDate.getTime();
    const nbday =  (difference / (1000 * 3600 * 24))+1;
    this.totalPrice=nbday*price;

  }

}
