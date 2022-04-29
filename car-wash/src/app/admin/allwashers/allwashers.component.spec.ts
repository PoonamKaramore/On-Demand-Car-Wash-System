import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllwashersComponent } from './allwashers.component';

describe('AllwashersComponent', () => {
  let component: AllwashersComponent;
  let fixture: ComponentFixture<AllwashersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllwashersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllwashersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
