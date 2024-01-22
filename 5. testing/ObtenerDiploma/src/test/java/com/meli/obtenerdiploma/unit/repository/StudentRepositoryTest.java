package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Set;

public class StudentRepositoryTest {
    private final IStudentRepository studentRepository = new StudentRepository();

    @Test
    @DisplayName("Should return a student when the id is valid")
    void shouldReturnAStudentWhenTheIdIsValid() {
        // Arrange
        Long id = 1L;
        Student expected = new Student(
                1L,
                "Juan",
                Set.of(
                        new Subject("Matemática", 9D),
                        new Subject("Física", 7D),
                        new Subject("Química", 6D)
                )
        );
        // Act
        Optional<Student> result = studentRepository.findById(id);
        // Assert
        Assertions.assertEquals(expected, result.get());
    }

    @Test
    @DisplayName("Should return an empty optional when the id is invalid")
    void shouldReturnAnEmptyOptionalWhenTheIdIsInvalid() {
        // Arrange
        Long id = 10L;
        // Act
        Optional<Student> result = studentRepository.findById(id);
        // Assert
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("showld return a students set when the students list is not empty")
    void shouldReturnAStudentsListWhenTheStudentsListIsNotEmpty() {
        // Act
        Set<Student> result = studentRepository.findAll();
        // Assert
        Assertions.assertFalse(result.isEmpty());
    }

    @Test
    @DisplayName("Should return true when the student is saved")
    void shouldReturnTrueWhenTheStudentIsSaved() {
        // Arrange
        Student student = new Student(
                3L,
                "Ana",
                Set.of(
                        new Subject("Matemática", 10.0),
                        new Subject("Física", 8.0),
                        new Subject("Química", 4.0)
                )
        );
        // Act
        boolean result = studentRepository.save(student);
        // Assert
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Should return false when the student is not saved")
    void shouldReturnFalseWhenTheStudentIsNotSaved() {
        // Arrange
        Student student = new Student(
                1L,
                "Juan",
                Set.of(
                        new Subject("Matemática", 9D),
                        new Subject("Física", 7D),
                        new Subject("Química", 6D)
                )
        );
        // Act
        boolean result = studentRepository.save(student);
        // Assert
        Assertions.assertFalse(result);
    }

}