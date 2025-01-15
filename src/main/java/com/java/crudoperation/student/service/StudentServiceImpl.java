package com.java.crudoperation.student.service;

import com.java.crudoperation.student.model.Student;
import com.java.crudoperation.student.repository.StudentRepository;
import com.java.crudoperation.utils.exceptions.GlobalExceptionWrapper;
import com.java.crudoperation.utils.exceptions.ResourceNotFoundException;
import io.micrometer.common.lang.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.java.crudoperation.utils.exceptions.NotFoundException;
<<<<<<< HEAD
=======

>>>>>>> 9135693 (CO03: Implemented get, getall, delete and update method)
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student save(@NonNull Student student) {
<<<<<<< HEAD
        try {
            if (studentRepository.existsByName(student.getName())) {

    public Student save(@NonNull Student student){
=======
>>>>>>> 9135693 (CO03: Implemented get, getall, delete and update method)
        try {
            if (studentRepository.existsByName(student.getName())) {
                throw new GlobalExceptionWrapper.BadRequestException("Student with name '" + student.getName() + "' already exists ");
            }
            return studentRepository.save(student);
        } catch (DataIntegrityViolationException e) {
            throw new GlobalExceptionWrapper.BadRequestException("Student with this name already exists");
        }
    }

    @Override
    public boolean existsByName(String name) {
        return false;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();  // Fetch all students from the database
    }

    @Override
    public List<Student> findAll() {
        return List.of();
    }

    @Override
    public Student save(Long entity) {
        return null;
    }

    @Override
    public Student fetchById(long id) throws Exception {
        return null;
    }

    @Override
    public String update(long id, Student entity) {
        return "";
    }

    @Override
    public String deleteById(long id) {
        // Fetch the movie by ID. Throws an exception if not found.
        Student student = findById(id);

        // Delete the movie using the repository.
        studentRepository.delete(student);

        // Return a success message.
        return "Student with ID " + id + " has been deleted successfully.";
    }

    @Override
    public Student findById(long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(  // Throw NotFoundException when not found
                        String.format("Student not found with id: %d", id)));
    }

    @Override
    public Student updateStudent(Long id, Student movieDetails) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

        // Update the fields as needed
        existingStudent.setName(movieDetails.getName());
        existingStudent.setAge(movieDetails.getAge());
        existingStudent.setCourse(String.valueOf(movieDetails.getCourse()));

        // Save the updated movie back to the database
        return studentRepository.save(existingStudent);
<<<<<<< HEAD
        return "";
=======
>>>>>>> 9135693 (CO03: Implemented get, getall, delete and update method)
    }

}
