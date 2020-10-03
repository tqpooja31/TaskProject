import { TestBed } from '@angular/core/testing';

import { ServletService } from './servlet.service';

describe('ServletService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ServletService = TestBed.get(ServletService);
    expect(service).toBeTruthy();
  });
});
