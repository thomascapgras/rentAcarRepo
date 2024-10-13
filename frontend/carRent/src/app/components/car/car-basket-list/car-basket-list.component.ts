import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { CarDto } from 'src/app/entities/car/car.interface';
import { BasketFactory } from 'src/app/entities/shares/basket.factory';
import { BasketDto } from 'src/app/entities/shares/basket.interface';
import { BasketService } from 'src/app/services/car/basket.service';


@Component({
  selector: 'app-car-basket-list',
  templateUrl: './car-basket-list.component.html',
  styleUrls: ['./car-basket-list.component.css']
})
export class CarBasketListComponent implements OnInit{
  basket : BasketDto;
  constructor(private basketService : BasketService) { 
    this.basket=BasketFactory.createBasket();
  }

  ngOnInit(): void {
    this.basketService.basket$.subscribe(basket => {
      this.basket = basket;
      console.log(this.basket);
    });
  }


}
