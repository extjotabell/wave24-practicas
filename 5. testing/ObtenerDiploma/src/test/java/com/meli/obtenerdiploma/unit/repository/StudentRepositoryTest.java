package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Set;

public class StudentRepositoryTest {
    private IStudentRepository studentRepository = new StudentRepository();

    @Test
    public void findById() {
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
        Optional<Student> result = studentRepository.findById(id);
        Assertions.assertEquals(expected, result.get());
    }

    @Test
    public void findByIdNotFound() {
        // Arrange
        Long id = 4L;
        Optional<Student> result = studentRepository.findById(id);
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void save() {
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
    public void delete() {
        // Arrange
        Long id = 1L;
        // Act
        boolean result = studentRepository.delete(id);
        // Assert
        Assertions.assertTrue(result);
    }

}
