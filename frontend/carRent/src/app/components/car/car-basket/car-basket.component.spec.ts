import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarBasketComponent } from './car-basket.component';

describe('CarBasketComponent', () => {
  let component: CarBasketComponent;
  let fixture: ComponentFixture<CarBasketComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CarBasketComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CarBasketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
