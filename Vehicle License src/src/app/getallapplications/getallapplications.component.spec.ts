import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetallapplicationsComponent } from './getallapplications.component';

describe('GetallapplicationsComponent', () => {
  let component: GetallapplicationsComponent;
  let fixture: ComponentFixture<GetallapplicationsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetallapplicationsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetallapplicationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
