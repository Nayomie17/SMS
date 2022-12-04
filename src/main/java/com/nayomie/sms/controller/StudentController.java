package com.nayomie.sms.controller;

import com.nayomie.sms.model.Student;
import com.nayomie.sms.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/sms")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = studentService.findAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id){
        Student student = studentService.findStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student newStudent = studentService.addStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }
    

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Integer id, @RequestBody Student student){
        Student updateStudent = studentService.findStudentById(id);
        updateStudent.setFirstName(student.getFirstName());
        updateStudent.setLastName(student.getLastName());
        updateStudent.setAge(student.getAge());
        updateStudent.setEmail(student.getEmail());
        updateStudent.setCourse(student.getCourse());
        Student updatedStudent = studentService.save(updateStudent);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
//    public void deleteStudent(@PathVariable("id") Integer id){
//        studentService.deleteStudent(id);
//    }
    public ResponseEntity<?> deleteStudent(@PathVariable("id") Integer id){
        Student student = studentService.findStudentById(id);
        studentService.delete(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
