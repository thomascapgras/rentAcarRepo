import { Component, OnInit } from '@angular/core';
import { ReservationService } from 'src/app/services/car/reservation.service';
import { Oauth2Service } from 'src/app/services/forms/oauth2.service';
import { UserService } from 'src/app/services/shares/user.service';



@Component({
  selector: 'app-authorized',
  templateUrl: './authorized.component.html',
  styleUrls: ['./authorized.component.css']
})
export class AuthorizedComponent implements OnInit {


  constructor(private userService: UserService, private oauth2Service: Oauth2Service, private reservationService : ReservationService) { 
  }

  ngOnInit(): void {
    this.userService.setIsAuthenticate(true);
    this.getOauth2User();
  }



  getOauth2User():void{
    this.oauth2Service.loadDiscoveryDocumentAndTryLogin().then(() => {
      const accessToken = localStorage.getItem('accessToken');
      if (accessToken != null) {
        this.oauth2Service.saveOauth2User(accessToken).subscribe({
          next: response => {
            console.log(response);
            this.userService.setUser(response.body);
          },
          error: err => {
            console.log(err);
          }
        });
      }
    });
  }

}
