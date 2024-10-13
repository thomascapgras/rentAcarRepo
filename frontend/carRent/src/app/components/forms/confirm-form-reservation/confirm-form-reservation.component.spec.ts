import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfirmFormReservationComponent } from './confirm-form-reservation.component';

describe('ConfirmFormReservationComponent', () => {
  let component: ConfirmFormReservationComponent;
  let fixture: ComponentFixture<ConfirmFormReservationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConfirmFormReservationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ConfirmFormReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
