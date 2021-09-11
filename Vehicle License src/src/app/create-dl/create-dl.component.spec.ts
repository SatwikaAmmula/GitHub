import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateDLComponent } from './create-dl.component';

describe('CreateDLComponent', () => {
  let component: CreateDLComponent;
  let fixture: ComponentFixture<CreateDLComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateDLComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateDLComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
