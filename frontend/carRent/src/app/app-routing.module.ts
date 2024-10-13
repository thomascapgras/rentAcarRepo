import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/shares/home/home.component';
import { LoginComponent } from './components/shares/login/login.component';
import { LogoutComponent } from './components/shares/logout/logout.component';
import { GardianUserService } from './services/shares/gardian-user.service';
import { SignupComponent } from './components/shares/signup/signup.component';
import { MyProfileComponent } from './components/shares/my-profile/my-profile.component';
import { NavbarComponent } from './components/shares/navbar/navbar.component';
import { CarsListComponent } from './components/car/cars-list/cars-list.component';
import { CarDetailsComponent } from './components/car/car-details/car-details.component';
import { MapCarComponent } from './components/car/map-car/map-car.component';
import { AuthorizedComponent } from './components/redirections/authorized/authorized.component';
import { ContactComponent } from './components/shares/contact/contact.component';
import { CarCaracteristicsComponent } from './components/car/car-caracteristics/car-caracteristics.component';
import { PageNotFoundComponentComponent } from './components/redirections/page-not-found-component/page-not-found-component.component';
import { CarReservationComponent } from './components/car/car-reservation/car-reservation.component';
import { CarReservationsListComponent } from './components/car/car-reservations-list/car-reservations-list.component';



const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:'login',component:LoginComponent},
  {path:'logout',component:LogoutComponent,canActivate:[GardianUserService]},
  {path:'signup',component:SignupComponent},
  {path:'myProfile',component:MyProfileComponent},
  {path:'nabvar',component:NavbarComponent},
  {path:'carsList',component:CarsListComponent},
  {path:'carDetails',component:CarDetailsComponent},
  {path:'carMap',component:MapCarComponent},
  {path:'authorized',component:AuthorizedComponent},
  {path:'contacts',component:ContactComponent},
  {path:'caracteristics',component:CarCaracteristicsComponent},
  {path:'carReservation',component:CarReservationComponent},
  {path:'carReservationsList',component:CarReservationsListComponent},
  {path:'**',component:PageNotFoundComponentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
