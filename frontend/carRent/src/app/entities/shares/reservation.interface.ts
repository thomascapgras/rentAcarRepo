import { CarDto } from "../car/car.interface";

export interface ReservationDto{
    id : number;
    city : string;
    departureDate : string;
    returnDate : string;
    carDto : CarDto;
}