
import { Component, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Observable, of } from 'rxjs';
import { CustomPipePipe } from '../pipes/custom-pipe-pipe';
import { StartsWithBPipe } from '../pipes/starts-with-b-pipe';

@Component({
  selector: 'app-pipes-demo',
  standalone: true,
  imports: [CommonModule, CustomPipePipe, StartsWithBPipe],
  templateUrl: './pipes-demo.html',
  styleUrls: ['./pipes-demo.css']
})
export class PipesDemoComponent {
  today = signal(new Date());
  employeeName = 'john doe';
  employeeSalary = 30000;

  company = {
    name: 'ABC Pvt Ltd',
    address: '123 Main St, Cityville',
    employees: 150
  };

  longText = `Lorem ipsum dolor sit amet, consectetur adipiscing elit.`;

  myObservable: Observable<number> = of(42);
  myPromise = new Promise<string>(resolve => {
    setTimeout(() => resolve('Promise resolved data'), 3000);
  });

  fruits: string[] = ['apple', 'banana', 'kiwi', 'grapefruit', 'blueberry', 'mango'];
}
