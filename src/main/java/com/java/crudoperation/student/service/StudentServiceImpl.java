package com.java.crudoperation.student.service;

import com.java.crudoperation.student.model.Student;
import com.java.crudoperation.student.repository.StudentRepository;
import com.java.crudoperation.utils.exceptions.GlobalExceptionWrapper;
import com.java.crudoperation.utils.exceptions.ResourceNotFoundException;
import com.java.crudoperation.utils.exceptions.NotFoundException;
import io.micrometer.common.lang.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student save(@NonNull Student student) {
        try {
            // Check if a student with the same name already exists
            if (studentRepository.existsByName(student.getName())) {
                throw new GlobalExceptionWrapper.BadRequestException(
                        "Student with name '" + student.getName() + "' already exists");
            }
            return studentRepository.save(student); // Save the student if no conflicts
        } catch (DataIntegrityViolationException e) {
            throw new GlobalExceptionWrapper.BadRequestException("Student with this name already exists");
        }
    }

    @Override
    public boolean existsByName(String name) {
        return studentRepository.existsByName(name); // Delegate the check to the repository
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll(); // Fetch all students from the database
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll(); // Reuse repository call to fetch all students
    }

    @Override
    public Student findById(long id) {
        // Find a student by ID, throw NotFoundException if not found
        return studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Student not found with id: %d", id)));
    }

    @Override
    public String deleteById(long id) {
        // Fetch the student by ID and throw an exception if not found
        Student student = findById(id);
        studentRepository.delete(student); // Delete the student
        return "Student with ID " + id + " has been deleted successfully.";
    }

    @Override
    public Student updateStudent(Long id, Student studentDetails) {
        // Find the student to update, throw exception if not found
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

        // Update the student details
        existingStudent.setName(studentDetails.getName());
        existingStudent.setAge(studentDetails.getAge());
        existingStudent.setCourse(studentDetails.getCourse());

        // Save and return the updated student
        return studentRepository.save(existingStudent);
    }

    // Unused methods can be removed unless they are required in the interface
    @Override
    public Student save(Long entity) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public Student fetchById(long id) throws Exception {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public String update(long id, Student entity) {
        throw new UnsupportedOperationException("Method not implemented");
    }
}
