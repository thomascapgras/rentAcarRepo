import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarShowedComponent } from './car-showed.component';

describe('CarShowedComponent', () => {
  let component: CarShowedComponent;
  let fixture: ComponentFixture<CarShowedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CarShowedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CarShowedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
