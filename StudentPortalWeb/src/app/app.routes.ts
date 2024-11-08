import { Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { StudentComponent } from './student/student.component';
import { LoginComponent } from './login/login.component';

export const routes: Routes = [
    { path: '', redirectTo: 'login', pathMatch: 'full' },
    { path: 'register', component: RegisterComponent },
    {path:'student',component:StudentComponent},
    {path:'login',component:LoginComponent}

];
