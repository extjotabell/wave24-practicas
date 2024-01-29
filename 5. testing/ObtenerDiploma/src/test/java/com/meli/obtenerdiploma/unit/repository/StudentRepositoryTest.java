package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class StudentRepositoryTest {

    StudentRepository studentRepository;

    @Test
    @DisplayName("Test validates the list is returning something")
    public void findAllList() {

        // Arrange
        Set<Student> expected = new HashSet<>();

        // Act
        var result = studentRepository.findAll();

        // Assert
        Assertions.assertEquals(expected, result, "La lista esta vacia");


    }
}
