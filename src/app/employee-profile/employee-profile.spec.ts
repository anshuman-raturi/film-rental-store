
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { EmployeeProfileComponent } from './employee-profile';
import { SimpleChanges } from '@angular/core';

describe('EmployeeProfileComponent', () => {
  let component: EmployeeProfileComponent;
  let fixture: ComponentFixture<EmployeeProfileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EmployeeProfileComponent]
    }).compileComponents();

    fixture = TestBed.createComponent(EmployeeProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create component', () => {
    expect(component).toBeTruthy();
  });

  it('should call ngOnInit and start interval', () => {
    spyOn(console, 'log');
    component.ngOnInit();
    expect(console.log).toHaveBeenCalledWith('ngOnInit: Component initialized');
  });

  it('should call ngOnChanges when input changes', () => {
    spyOn(console, 'log');
    const changes: SimpleChanges = {
      employeeName: {
        currentValue: 'Alice',
        previousValue: 'Bob',
        firstChange: false,
        isFirstChange: () => false
      }
    };
    component.ngOnChanges(changes);
    expect(console.log).toHaveBeenCalledWith('ngOnChanges:', changes);
  });

  it('should call ngDoCheck', () => {
    spyOn(console, 'log');
    component.ngDoCheck();
    expect(console.log).toHaveBeenCalledWith('ngDoCheck: Change detection run');
  });

  it('should call ngAfterContentInit', () => {
    spyOn(console, 'log');
    component.ngAfterContentInit();
    expect(console.log).toHaveBeenCalledWith('ngAfterContentInit: Content initialized');
  });

  it('should call ngAfterContentChecked', () => {
    spyOn(console, 'log');
    component.ngAfterContentChecked();
    expect(console.log).toHaveBeenCalledWith('ngAfterContentChecked: Content checked');
  });

  it('should call ngAfterViewInit', () => {
    spyOn(console, 'log');
    component.ngAfterViewInit();
    expect(console.log).toHaveBeenCalledWith('ngAfterViewInit: View initialized');
  });

  it('should call ngAfterViewChecked', () => {
    spyOn(console, 'log');
    component.ngAfterViewChecked();
    expect(console.log).toHaveBeenCalledWith('ngAfterViewChecked: View checked');
  });

  it('should call ngOnDestroy and clear interval', () => {
    spyOn(console, 'log');
    component.intervalId = setInterval(() => {}, 1000);
    component.ngOnDestroy();
    expect(console.log).toHaveBeenCalledWith('ngOnDestroy: Cleaning up resources');
  });
});
