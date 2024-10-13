import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarBasketListComponent } from './car-basket-list.component';

describe('CarBasketListComponent', () => {
  let component: CarBasketListComponent;
  let fixture: ComponentFixture<CarBasketListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CarBasketListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CarBasketListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
