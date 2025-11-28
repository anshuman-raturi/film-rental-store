
import { Component, ViewChild, AfterViewInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header';
import { ProfileComponent } from './profile/profile';
import { EmployeeProfileComponent } from './employee-profile/employee-profile';
import { PipesDemoComponent } from './pipes-demo/pipes-demo';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    HeaderComponent,
    ProfileComponent,
    EmployeeProfileComponent,
    PipesDemoComponent
  ],
  templateUrl: './app.html',
  styleUrls: ['./app.css']
})
export class AppComponent implements AfterViewInit {
  // For Parent-Child Demo
  parentname: string = 'App Component Parent';
  isParent: boolean = true;

  messageFromChildViaOutput: string = '(no message yet)';
  countFromChildViaOutput: number = 0;

  messageFromChildViaViewChild: string = '';
  countFromChildViaViewChild: number = 0;

  @ViewChild(HeaderComponent) childComponent!: HeaderComponent;

  // ✅ For Profile Component Demo
  profileName: string = 'John Smith';
  showProfile: boolean = true;

  ngAfterViewInit(): void {
    this.messageFromChildViaViewChild = this.childComponent.childMessage;
    this.countFromChildViaViewChild = this.childComponent.countFromChild;
  }

  onMessageChange(newMessage: string) {
    this.messageFromChildViaOutput = newMessage;
  }

  onCountChange(newCount: number) {
    this.countFromChildViaOutput = newCount;
  }

  changeProfileName() {
    this.profileName = this.profileName === 'John Smith' ? 'Alice Johnson' : 'John Smith';
  }

  toggleProfile() {
    this.showProfile = !this.showProfile;
  }
}
