import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarReservationsListComponent } from './car-reservations-list.component';

describe('CarReservationsListComponent', () => {
  let component: CarReservationsListComponent;
  let fixture: ComponentFixture<CarReservationsListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CarReservationsListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CarReservationsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
