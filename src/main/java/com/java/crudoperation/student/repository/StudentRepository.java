package com.java.crudoperation.student.repository;

import com.java.crudoperation.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

    boolean existsByName(String name);
    List<Student> findAll();
}
