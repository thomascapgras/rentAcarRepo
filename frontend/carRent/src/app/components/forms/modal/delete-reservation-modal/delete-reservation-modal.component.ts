import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ReservationService } from 'src/app/services/car/reservation.service';

@Component({
  selector: 'app-delete-reservation-modal',
  templateUrl: './delete-reservation-modal.component.html',
  styleUrls: ['./delete-reservation-modal.component.css']
})
export class DeleteReservationModalComponent implements OnInit {

  reservationId : number;
  constructor(public dialogRef: MatDialogRef<DeleteReservationModalComponent>,
    private reservationService : ReservationService, private router : Router,
    @Inject(MAT_DIALOG_DATA) public data: { reservationId: number }) {
      this.reservationId=this.data.reservationId;
    }

  ngOnInit(): void {

  }

  onConfirm(): void {
    this.reservationService.deleteReservationsById(this.reservationId).subscribe({
      next :response =>{
        console.log(response);
        this.dialogRef.close(true);
        this.router.navigate(['/'])
      },
      error:err=>{
        console.log(err);
      }
    })
  }

  onCancel(): void {
    this.dialogRef.close(true);
  }

}
