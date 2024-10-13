import { TestBed } from '@angular/core/testing';

import { GardianUserService } from './gardian-user.service';

describe('GardianUserService', () => {
  let service: GardianUserService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GardianUserService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
