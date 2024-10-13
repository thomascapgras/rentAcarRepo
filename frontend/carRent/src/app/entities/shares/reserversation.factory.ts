import { CarFactory } from "../car/car.factory";
import { ReservationDto } from "./reservation.interface";



export class ReservationFactory{
    public static createReservation():ReservationDto{
        return {
            id:0,
            carDto : CarFactory.createCar(),
            city : "None",
            departureDate : new Date().toISOString().split('T')[0],
            returnDate : new Date().toISOString().split('T')[0],
        }
    }
}