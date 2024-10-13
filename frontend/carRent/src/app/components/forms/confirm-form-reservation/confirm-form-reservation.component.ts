import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { ReservationService } from 'src/app/services/car/reservation.service';
import { UserService } from 'src/app/services/shares/user.service';
import { CarsService } from 'src/app/services/car/cars.service';
import { LoginModalComponent } from '../modal/login-modal/login-modal.component';
import { ReservationDto } from 'src/app/entities/shares/reservation.interface';
import { User } from 'src/app/entities/shares/user.interface';
import { CarDto } from 'src/app/entities/car/car.interface';



@Component({
  selector: 'app-confirm-form-reservation',
  templateUrl: './confirm-form-reservation.component.html',
  styleUrls: ['./confirm-form-reservation.component.css']
})
export class ConfirmFormReservationComponent implements OnInit,OnDestroy {

  reservation : ReservationDto;
  isAuthenticate : boolean;
  user : User;
  car : CarDto;
  constructor(private reservationService : ReservationService, private userService : UserService,private carService : CarsService
    , private router : Router,public dialog: MatDialog) { 
    this.isAuthenticate = this.userService.getIsAuthenticate();
    this.reservation = this.reservationService.getReservation();
    this.user = this.userService.getUser();
    this.car = this.carService.getCar();
    
  }


  ngOnInit(): void {
  }

  ngOnDestroy(): void {
    this.reservationService.resetReservation();
  }

  confirmReservation() {

    if (this.isAuthenticate){
      console.log("faire reservation");
      this.reservation.carDto=  this.car;
      this.reservationService.saveReservation(this.reservation,this.user.id).subscribe({
        next:response=>{
          if (response.status === 201 || response.status === 200) {
            console.log(response.body);
            this.router.navigate(['/']);
          }
        },
        error:err=>{
          console.log(err);
        }
      })
    }else{
      this.openDialog();
    }
  }

  openDialog(): void {
    this.dialog.open(LoginModalComponent, {
      width: '50%'
    });

    
  }

}
