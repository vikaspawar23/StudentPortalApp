import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentservService {
 
 

  private apiUrl = 'http://localhost:8080/api/student';


  constructor(private httpclient : HttpClient) { }
 
  getAllStudents() {
    return this.httpclient.get<Student[]>(this.apiUrl);
  }
 
  deleteById(email: String) {
    return this.httpclient.delete<void>(this.apiUrl+"/"+email);
  }
 
  addStudent(student: Student) {
    return this.httpclient.post<void>(this.apiUrl,student);
  }

  getStates() {
    return this.httpclient.get<String[]>(this.apiUrl+"/getstates");
  }

  getCitiesByState(state: String) {
    return this.httpclient.get<String[]>(this.apiUrl+"/getcities/"+state);
  }
}
export class Student {
  name: String ="";
	email:String ="";
	education:String="";
	state:String="";
	city:String="";
	password:String="";
  gender: string=""; 
  subjects: string="";
}