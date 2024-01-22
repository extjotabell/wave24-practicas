package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.dto.StudentDTO;

import java.util.List;
import java.util.Set;

public interface IStudentService {
    boolean create(StudentDTO stu);
    StudentDTO read(Long id);
    boolean update(StudentDTO stu);
    boolean delete(Long id);
    List<StudentDTO> getAll();
}
