import { Component, OnDestroy, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { BasketFactory } from 'src/app/entities/shares/basket.factory';
import { BasketDto } from 'src/app/entities/shares/basket.interface';
import { ReservationDto } from 'src/app/entities/shares/reservation.interface';
import { User } from 'src/app/entities/shares/user.interface';
import { BasketService } from 'src/app/services/car/basket.service';
import { ReservationService } from 'src/app/services/car/reservation.service';
import { UserService } from 'src/app/services/shares/user.service';

@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',
  styleUrls: ['./my-profile.component.css']
})
export class MyProfileComponent implements OnInit, OnDestroy {

  isAuthenticate : boolean;
  user : User;
  reservations : ReservationDto[]=[];
  basket : BasketDto;
  constructor(private userService : UserService, private router : Router, private reservationService : ReservationService,
    private basketService : BasketService) { 
    this.isAuthenticate = this.userService.getIsAuthenticate();
    this.user = userService.getUser();
    this.basket = BasketFactory.createBasket();
    }

  ngOnDestroy(): void {
    this.reservationService.clearReservations();
    this.basketService.clearBasket();
  }

  ngOnInit(): void {
    if (!this.isAuthenticate){
      this.router.navigate(['/login']);
    }
    this.getReservations();
    this.getBasket();
  }

  getReservations(): void {
    this.reservationService.getReservationsByUserId(this.user.id).subscribe({
        next: response => {
          console.log(response);
          this.reservationService.setReservations(response);
        },
        error: err => {
            console.log(err);
        }
    });
}

  getBasket(){
    const id = this.user.id;
    this.basketService.getBasketByUserId(id).subscribe({
      next : response=>{
        console.log(response);
        this.basketService.setBasket(response);

      },
      error:err=>{
        console.log(err);
      }
    })

  }



}
