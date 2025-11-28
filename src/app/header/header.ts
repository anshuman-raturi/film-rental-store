
import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './header.html',
  styleUrls: ['./header.css']
})
export class HeaderComponent {
  // Inputs from parent
  @Input() parent: string = '';
  @Input() isParent: boolean = false;

  // Internal child data
  childname: string = 'Header Component Child';
  childMessage: string = 'Message from Header Child Component';
  countFromChild: number = 124;

  // Outputs to parent
  @Output() messageChange = new EventEmitter<string>();
  @Output() countChange = new EventEmitter<number>();

  // Emit a custom message to parent
  emitMessage() {
    const msg = `Hello ${this.parent}! (${new Date().toLocaleTimeString()})`;
    this.messageChange.emit(msg);
  }

  // Increment count and emit to parent
  incrementAndEmit() {
    this.countFromChild++;
    this.countChange.emit(this.countFromChild);
  }
}
