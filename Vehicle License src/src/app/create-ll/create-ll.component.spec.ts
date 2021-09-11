import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateLLComponent } from './create-ll.component';

describe('CreateLLComponent', () => {
  let component: CreateLLComponent;
  let fixture: ComponentFixture<CreateLLComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateLLComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateLLComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
