import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from './student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private baseURL = "http://localhost:8080/sms";

  constructor(private httpClient: HttpClient) { }

  getStudentsList(): Observable<Student[]>{
    return this.httpClient.get<Student[]>(`${this.baseURL}`+ "/students");
  }

  createStudent(student: Student): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}` + "/add" , student);
  }

  getStudentById(id?: number): Observable<Student>{
    return this.httpClient.get<Student>(`${this.baseURL}` + "/find/" + `${id}`);
  }

  updateStudent( student: Student, id?: number): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}`+ "/update/" +`${id}` , student);
  }

  deleteStudent(id?: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}`+ "/delete/" +`${id}`);
  }
}
