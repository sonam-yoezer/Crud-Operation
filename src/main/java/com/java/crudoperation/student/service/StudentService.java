package com.java.crudoperation.student.service;

import com.java.crudoperation.student.model.Student;
import com.java.crudoperation.utils.IGenericCrudService;
import io.micrometer.common.lang.NonNull;
import java.util.List;

public interface StudentService extends IGenericCrudService<Long, Student> {
    Student save(@NonNull Student student);
    boolean existsByName(String name);

    List<Student> getAllStudent();

    Student findById(long id);

    Student updateStudent(Long id, Student movieDetails);

}
