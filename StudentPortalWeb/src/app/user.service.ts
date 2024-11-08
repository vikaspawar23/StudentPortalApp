import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private registerUrl = 'http://localhost:8080/api/user/register';
    private loginUrl = 'http://localhost:8080/api/user/login';

    constructor(private http: HttpClient) {}

    register(user: any): Observable<any> {
        return this.http.post(this.registerUrl, user);
    }

    login(user: any): Observable<any> {
        return this.http.post(this.loginUrl, user);
    }
}
