import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarCaracteristicsComponent } from './car-caracteristics.component';

describe('CarCaracteristicsComponent', () => {
  let component: CarCaracteristicsComponent;
  let fixture: ComponentFixture<CarCaracteristicsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CarCaracteristicsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CarCaracteristicsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
