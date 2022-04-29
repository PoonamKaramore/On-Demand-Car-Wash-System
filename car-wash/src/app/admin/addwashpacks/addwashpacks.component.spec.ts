import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddwashpacksComponent } from './addwashpacks.component';

describe('AddwashpacksComponent', () => {
  let component: AddwashpacksComponent;
  let fixture: ComponentFixture<AddwashpacksComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddwashpacksComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddwashpacksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
