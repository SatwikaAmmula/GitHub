import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetchallanComponent } from './getchallan.component';

describe('GetchallanComponent', () => {
  let component: GetchallanComponent;
  let fixture: ComponentFixture<GetchallanComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetchallanComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetchallanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
