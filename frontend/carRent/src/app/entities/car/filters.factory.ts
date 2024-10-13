import { FiltersDto } from "./filters.interface";



export class FiltersFactory{
    public static createFilters():FiltersDto{
        return {
            minPrice : 10,
            maxPrice : 150.0,
            gps:null,
            backupCamera : null,
            manualTransmission : null,
            bluetooth : null,
        }
    }
}