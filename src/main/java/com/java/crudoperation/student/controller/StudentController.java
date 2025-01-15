package com.java.crudoperation.student.controller;

import com.java.crudoperation.student.model.Student;
import com.java.crudoperation.student.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentServiceImpl;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        // Save the Student
        Student savedStudent = studentServiceImpl.save(student);
        return ResponseEntity.ok(savedStudent);
    }

}
