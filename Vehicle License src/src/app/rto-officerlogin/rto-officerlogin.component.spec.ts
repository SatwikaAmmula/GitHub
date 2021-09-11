import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RtoOfficerloginComponent } from './rto-officerlogin.component';

describe('RtoOfficerloginComponent', () => {
  let component: RtoOfficerloginComponent;
  let fixture: ComponentFixture<RtoOfficerloginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RtoOfficerloginComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RtoOfficerloginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
