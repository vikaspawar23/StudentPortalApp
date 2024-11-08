import { Component, OnInit } from '@angular/core';
import { Student, StudentservService } from '../studentserv.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-student',
  standalone: true,
  imports: [FormsModule, CommonModule, RouterOutlet],
  templateUrl: './student.component.html',
  styleUrl: './student.component.css'
})
export class StudentComponent implements OnInit {
  deleteStudent(email: String) {
    this.studentserv.deleteById(email).subscribe();
    this.studentserv.getAllStudents().subscribe(data => this.students = data);
    this.ngOnInit()
  }
  editStudent(std: Student) {
    this.student = std;
    this.studentserv.getAllStudents().subscribe(data => this.students = data);
    this.ngOnInit()
  }

  title = 'StudentPortalWeb';

  students: Student[] = []
  states: String[] = [];
  cities: String[] = [];
  student: Student = new Student();

  isPasswordVisible = false;
  submitted = false;

  togglePasswordVisibility() {
    this.isPasswordVisible = !this.isPasswordVisible;
  }

  constructor(private studentserv: StudentservService) { }
  ngOnInit(): void {
    this.studentserv.getStates().subscribe(data => this.states = data);
    this.studentserv.getAllStudents().subscribe(data => this.students = data);

  }

  selectedSubjects: string[] = [];

  onSubjectChange(subject: string) {
    const index = this.selectedSubjects.indexOf(subject);
    if (index > -1) {
      this.selectedSubjects.splice(index, 1); 
    } else {
      this.selectedSubjects.push(subject); 
    }
    this.student.subjects = this.selectedSubjects.join(', '); 
  }

  addStudent() {
    this.studentserv.addStudent(this.student).subscribe();
    this.studentserv.getAllStudents().subscribe(data => this.students = data);
    this.ngOnInit()
  }

  getCities() {
    this.studentserv.getCitiesByState(this.student.state).subscribe(data => this.cities = data);
  }



}
