
import { Component, Input, OnInit, OnDestroy } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './profile.html',
  styleUrls: ['./profile.css']
})
export class ProfileComponent implements OnInit, OnDestroy {
  @Input() profileName: string = '';

  ngOnInit(): void {
    console.log(`Profile component initialized with name: ${this.profileName}`);
  }

  ngOnDestroy(): void {
    console.log(`Profile component destroyed for name: ${this.profileName}`);
  }
}
