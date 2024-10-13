import {  CarDto } from "./car.interface";

export class CarFactory{
    static createCar ():CarDto{
        return{
            id:0,
            brand:'brand',
            model:'model' ,
            city :'city',
            licenceNumber:'XYZ000',
            price:0,
            available:true,
            rating:5,
            latitude : 48.8566,
            longitude : 48.8566,
            carCaracteristicsDto : {
                mileage:0,
            rentNumber:0,
            fuelType:'None',
            manualTransmission:false,
            backupCamera:false,
            gps:false,
            bluetooth:false,
            horsepower:0,
            seats:0,
            doors:0,
            description:'no car model',
            img:'/assets/images/peugeot-208.jpg'
            }
            
        }
    }
}