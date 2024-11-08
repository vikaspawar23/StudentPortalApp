import { Component } from '@angular/core';
import { UserService } from '../user.service';
import { Router, RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

interface User {
  email: string;
  city: string;
  mobile: string;
  password: string;
}

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule,CommonModule,RouterOutlet],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  user: User = {
    email: '',
    city: '',
    mobile: '',
    password: ''
};
submitted: any;

constructor(private userService: UserService, private router: Router) {}

onSubmit() {
    this.userService.register(this.user).subscribe(
        (response: any) => {
            console.log('User registered successfully', response);
            this.router.navigate(['/login']);
        },
        (error: any) => {
            console.error('Registration error', error);
        }
    );
}
}
