package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class StudentRepositoryTest {
    IStudentRepository studentRepository = new StudentRepository();
    private final Student JUAN = new Student(
            1L,
            "Juan",
            new HashSet<>(Arrays.asList(
                    new Subject("Matemática", 9D),
                    new Subject("Física", 7D),
                    new Subject("Química", 6D)
            ))
    );

    private final Student JUAN_NEW_NOTES= new Student(
            1L,
            "Juan",
            new HashSet<>(Arrays.asList(
                    new Subject("Matemática", 10D),
                    new Subject("Física", 10D),
                    new Subject("Química", 10D)
            ))
    );

    private final Student PEDRO = new Student(
            2L,
            "Pedro",
            new HashSet<>(Arrays.asList(
                    new Subject("Matemática", 10D),
                    new Subject("Física", 8D),
                    new Subject("Química", 4D)
            ))
    );

    private final Student NEW_STUDENT = new Student(
            3L,
            "Carlos",
            new HashSet<>(Arrays.asList(
                    new Subject("Matemática", 10D),
                    new Subject("Física", 9D),
                    new Subject("Química", 8D)
            ))
    );

    @Test
    @DisplayName("Test to save a new student")
    public void saveNewStudentTest() {
        // Arrange
        boolean expected = true;

        // Act
        var result = studentRepository.save(NEW_STUDENT);

        // Assert
        Assertions.assertEquals(expected, result, "No se pudo guardar el nuevo estudiante");
    }

    @Test
    @DisplayName("Test that given a ID returns the correct student")
    public void findStudentByIdTest() {
        // Arrange
        long idParam = 1;
        Optional<Student> expected = Optional.of(JUAN);

        // Act
        var result = studentRepository.findById(idParam);

        // Assert
        Assertions.assertEquals(expected, result, "El estudiante no coincide");
    }

    @Test
    @DisplayName("Test that given a non-existent ID returns a empty Optional")
    public void findStudentByNonexistentIdTest() {
        // Arrange
        long idParam = 3;

        // Act
        var result = studentRepository.findById(idParam);

        // Assert
        Assertions.assertTrue(result.isEmpty(), "El estudiante no coincide");
    }

    @Test
    @DisplayName("Test to update data of a student")
    public void updateStudentTest() {
        // Arrange
        boolean expected = true;

        // Act
        var result = studentRepository.update(JUAN_NEW_NOTES);

        // Assert
        Assertions.assertEquals(expected, result, "No se pudo eliminar al estudiante 'Juan'");
    }

    @Test
    @DisplayName("Test to delete a student")
    public void deleteStudentTest() {
        // Arrange
        boolean expected = true;

        // Act
        var result = studentRepository.delete(JUAN.getId());

        // Assert
        Assertions.assertEquals(expected, result, "No se pudo eliminar al estudiante 'Juan'");
    }

    @Test
    @DisplayName("Test to return all students")
    public void findAllStudentsTest() {
        // Arrange
        Set<Student> expected = new HashSet<>(Arrays.asList(
                PEDRO,
                JUAN
        ));

        // Act
        var result = studentRepository.findAll();

        // Assert
        Assertions.assertEquals(expected, result, "La lista no coincide");
    }
}
