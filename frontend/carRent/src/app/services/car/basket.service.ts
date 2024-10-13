import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { BasketFactory } from 'src/app/entities/shares/basket.factory';
import { BasketDto } from 'src/app/entities/shares/basket.interface';
import { SHARESCONST } from 'src/app/url-constantes';

@Injectable({
  providedIn: 'root'
})
export class BasketService {


  private basket : BasketDto;
  private basketSubject: BehaviorSubject<BasketDto> = new BehaviorSubject<BasketDto>(BasketFactory.createBasket());
  public basket$: Observable<BasketDto> = this.basketSubject.asObservable();
  constructor(private http : HttpClient) {
    this.basket = BasketFactory.createBasket();
   }

   getBasketByUserId(id : number):Observable<BasketDto>{
    const url = SHARESCONST.urlGetBasketByUserId + '/' + id;
    return this.http.get<BasketDto>(url,{withCredentials:true});
   }

   getBasket(): BasketDto {
    return this.basket;
  }

  setBasket(basket: BasketDto): void {
    this.basketSubject.next(basket);
  }

  clearBasket():void{
    this.basketSubject.next(BasketFactory.createBasket());
  }
}
