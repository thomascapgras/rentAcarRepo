import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ouath2Component } from './ouath2.component';

describe('Ouath2Component', () => {
  let component: Ouath2Component;
  let fixture: ComponentFixture<Ouath2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Ouath2Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Ouath2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
