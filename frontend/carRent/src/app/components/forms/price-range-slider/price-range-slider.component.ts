import { Component, OnInit } from "@angular/core";
import { FiltersService } from "src/app/services/forms/filters.service";
import {MatSliderModule} from '@angular/material/slider'



@Component({
  selector: 'app-price-range-slider',
  templateUrl: './price-range-slider.component.html',
  styleUrls: ['./price-range-slider.component.css']
})
export class PriceRangeSliderComponent implements OnInit {
  minPrice = 10;
  maxPrice = 150;
  priceRange = { min: 10, max: 150 };
  constructor(private filtresService : FiltersService ){

  }

    ngOnInit(): void {

    }

  updateMinPrice(event: any) {
    this.priceRange.min = event.value;
    this.filtresService.setMinPrice(this.priceRange.min );


  }

  updateMaxPrice(event: any) {
    this.priceRange.max = event.value;
    this.filtresService.setMaxPrice(this.priceRange.max);
  }
}
