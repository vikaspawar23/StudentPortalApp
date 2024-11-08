import { Component } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { UserService } from '../user.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, CommonModule,RouterOutlet],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'] // Corrected from styleUrl to styleUrls
})
export class LoginComponent {
  user: { email: string; password: string } = {
    email: '',
    password: ''
  };

  constructor(private authService: UserService, private router: Router) { }

  onSubmit() {
    this.authService.login(this.user).subscribe(
      (response: any) => {
        console.log('Login successful', response);
        // Optionally redirect to a home page or dashboard
        this.router.navigate(['student']);
      },
      (error: any) => {
        console.error('Login error', error);
      }
    );
  }
}
