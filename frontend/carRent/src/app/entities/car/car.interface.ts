import { CarCaracteristicsDto } from "./carCaracteristics.interface";


export interface CarDto{

    id:number;
    brand:string;
    model:string ;
    licenceNumber:string;
    price:number;
    available:boolean;
    rating:number;
    latitude:number;
    longitude : number;
    carCaracteristicsDto  : CarCaracteristicsDto;
    city : string;


}