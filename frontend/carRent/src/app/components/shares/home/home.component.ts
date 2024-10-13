import { Component, OnInit } from '@angular/core';
import { ReservationService } from 'src/app/services/car/reservation.service';
import { UserService } from 'src/app/services/shares/user.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  constructor(private userService : UserService, private reservationService : ReservationService) { 
    console.log(this.userService.getUser());
    this.reservationService.resetReservation();

  }

  ngOnInit(): void {

  }


}
