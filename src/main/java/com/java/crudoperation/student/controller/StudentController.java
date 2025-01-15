package com.java.crudoperation.student.controller;

import com.java.crudoperation.student.model.Student;
import com.java.crudoperation.student.service.StudentServiceImpl;
import com.java.crudoperation.utils.RestHelper;
import com.java.crudoperation.utils.RestResponse;
import com.java.crudoperation.utils.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentServiceImpl.getAllStudent(); // Get all students
        if (students.isEmpty()) {
            return ResponseEntity.ok(new ArrayList<>());  // Return an empty list with a 200 OK status
        }
        return ResponseEntity.ok(students);  // Return the list of students with a 200 OK status
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovieById(@PathVariable long id) {
        try {
            studentServiceImpl.deleteById(id);
            return ResponseEntity.ok("Student deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Student not found.");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<RestResponse> getMovieId(@PathVariable long id) {
        try {
            Student student = studentServiceImpl.findById(id);  // This will throw NotFoundException if not found
            Map<String, Object> response = new HashMap<>();
            response.put("student", student);
            return RestHelper.responseSuccess(response);  // Return success response
        } catch (NotFoundException e) {  // Catch the custom NotFoundException
            return RestHelper.responseError(e.getMessage());  // Return the error with the exception message
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateMovie(@PathVariable Long id, @Validated @RequestBody Student studentDetails) {
        Student updatedStudent = studentServiceImpl.updateStudent(id, studentDetails);
        return ResponseEntity.ok(updatedStudent);
    }

}
