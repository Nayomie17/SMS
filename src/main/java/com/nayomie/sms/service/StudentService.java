package com.nayomie.sms.service;

import com.nayomie.sms.exception.UserNotFoundException;
import com.nayomie.sms.model.Student;
import com.nayomie.sms.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student addStudent(Student student){
        student.setStudentCode(UUID.randomUUID().toString());
        return studentRepo.save(student);
    }

    public List<Student> findAllStudents(){
        return studentRepo.findAll();
    }

    public Student updateStudent(Student student){
        return studentRepo.save(student);
    }

    public Student findStudentById(Integer id){
        return studentRepo.findStudentById(id)
                .orElseThrow(()-> new UserNotFoundException("User by id " + id + " was not found."));
    }

    public void deleteStudent(Integer id){
        studentRepo.deleteStudentById(id);
    }

    public Student save(Student updateStudent) {
        return studentRepo.save(updateStudent);
    }

    public void delete(Student student) {
        studentRepo.delete(student);
    }
}
