import {
  Component,
  Input,
  OnInit,
  OnChanges,
  DoCheck,
  AfterContentInit,
  AfterContentChecked,
  AfterViewInit,
  AfterViewChecked,
  OnDestroy,
  SimpleChanges
} from '@angular/core';
import { CommonModule } from '@angular/common'

@Component({
  selector: 'app-employee-profile',
  standalone: true,
  imports: [CommonModule], // ✅ Add thi
  templateUrl: './employee-profile.html',
  styleUrls: ['./employee-profile.css']
})
export class EmployeeProfileComponent
  implements OnInit, OnChanges, DoCheck, AfterContentInit, AfterContentChecked, AfterViewInit, AfterViewChecked, OnDestroy {

  @Input() employeeName: string = '';
  @Input() employeeRole: string = '';
  @Input() employeeSalary: number = 0;

  intervalId: any;

  constructor() {
    console.log('constructor: EmployeeProfileComponent created');
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log('ngOnChanges:', changes);
  }

  ngOnInit(): void {
    console.log('ngOnInit: Component initialized');
    // Practical example: start a timer to simulate resource allocation
    this.intervalId = setInterval(() => {
      console.log(`Checking updates for ${this.employeeName}`);
    }, 2000);
  }

  ngDoCheck(): void {
    console.log('ngDoCheck: Change detection run');
  }

  ngAfterContentInit(): void {
    console.log('ngAfterContentInit: Content initialized');
  }

  ngAfterContentChecked(): void {
    console.log('ngAfterContentChecked: Content checked');
  }

  ngAfterViewInit(): void {
    console.log('ngAfterViewInit: View initialized');
  }

  ngAfterViewChecked(): void {
    console.log('ngAfterViewChecked: View checked');
  }

  ngOnDestroy(): void {
    console.log('ngOnDestroy: Cleaning up resources');
    clearInterval(this.intervalId); // Cleanup example
  }
}
