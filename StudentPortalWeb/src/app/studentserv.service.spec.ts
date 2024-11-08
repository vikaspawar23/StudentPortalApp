import { TestBed } from '@angular/core/testing';

import { StudentservService } from './studentserv.service';

describe('StudentservService', () => {
  let service: StudentservService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StudentservService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
