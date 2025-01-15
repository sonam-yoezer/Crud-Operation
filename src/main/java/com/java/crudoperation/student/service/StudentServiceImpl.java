package com.java.crudoperation.student.service;

import com.java.crudoperation.student.model.Student;
import com.java.crudoperation.student.repository.StudentRepository;
import com.java.crudoperation.utils.exceptions.GlobalExceptionWrapper;
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
    public Student save(@NonNull Student student){
        try {
            if (studentRepository.existsByName(student.getName())){
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
        return "";
    }

}
