import { CarDto } from "../car/car.interface";
import { ReservationDto } from "./reservation.interface";


export interface BasketDto{
    id : number;
    reservationDtos : ReservationDto[];

}