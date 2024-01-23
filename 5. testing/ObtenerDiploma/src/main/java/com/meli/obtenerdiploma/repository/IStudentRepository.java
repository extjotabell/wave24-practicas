package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.dto.StudentDTO;
import com.meli.obtenerdiploma.entity.Student;

import java.util.Optional;
import java.util.Set;

public interface IStudentRepository {

    Set<Student> findAll();

    boolean save(Student stu);

    boolean delete(Long id);

    Optional<Student> findById(Long id);

    boolean exists(Student student);
}
