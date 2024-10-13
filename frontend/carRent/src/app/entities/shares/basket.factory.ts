import { BasketDto } from "./basket.interface";


export class BasketFactory{
    public static createBasket():BasketDto{
        return {
            id : 0,
            reservationDtos : [],
        }
    }
}