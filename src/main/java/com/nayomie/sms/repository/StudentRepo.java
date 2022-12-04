package com.nayomie.sms.repository;

import com.nayomie.sms.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
public interface StudentRepo extends JpaRepository<Student, Integer> {
    void deleteStudentById(Integer id);

    Optional<Student> findStudentById(Integer id);
}
