import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateNewuserComponent } from './create-newuser.component';

describe('CreateNewuserComponent', () => {
  let component: CreateNewuserComponent;
  let fixture: ComponentFixture<CreateNewuserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateNewuserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateNewuserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
