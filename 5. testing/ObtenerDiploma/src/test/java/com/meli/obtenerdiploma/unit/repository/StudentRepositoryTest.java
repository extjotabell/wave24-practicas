package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentRepositoryTest {

    IStudentRepository studentRepository = new StudentRepository();
    private final Student studentId1 =
            new Student(
                    1L,
                    "Juan",
                    new HashSet<>(List.of(
                            new Subject("Matemática", 9.0),
                            new Subject("Física", 7.0),
                            new Subject("Química", 6.0)
                    ))
            );
    private final Student studentId2 =
            new Student(
                    2L,
                    "Pedro",
                    new HashSet<>(List.of(
                            new Subject("Matemática", 10.0),
                            new Subject("Física", 8.0),
                            new Subject("Química", 4.0)
                    ))
            );

    @Test
    @DisplayName("Test add student")
    void addStudentTest() {
        //Arrange
        Student newStudent = new Student(
                2L,
                "Enzo",
                new HashSet<>(List.of(
                        new Subject("Química", 9.0),
                        new Subject("Física", 7.0),
                        new Subject("Matemática", 6.0)
                ))
        );
        //Act
        boolean studentWasCreated = studentRepository.save(newStudent);
        //Assert
        Assertions.assertTrue(studentWasCreated,"Student was not created");
    }

    @Test
    @DisplayName("Test find student by id")
    void findByIdTest() {
        //Arrange
        Long idParam = 1L;
        //Act
        Student result = studentRepository.findById(idParam).orElse(null);
        //Assert
        Assertions.assertEquals(studentId1, result, "Student was not found");
    }

    @Test
    @DisplayName("Test modify student")
    void modifyTest(){
        //Arrange
        Student studentModify = new Student(
                1L,
                "Enzo",
                new HashSet<>(List.of(
                        new Subject("Química", 9.0),
                        new Subject("Física", 7.0),
                        new Subject("Matemática", 6.0)
                ))
        );
        //Act
        boolean studentWasModified = studentRepository.save(studentModify);
        //Assert
        Assertions.assertTrue(studentWasModified,"Student was not modified");
    }
    @Test
    @DisplayName("Test delete student")
    void deleteTest(){
        //Arrange
        Long idParam = 1L;
        //Act
        boolean studentWasDeleted = studentRepository.delete(idParam);
        //Assert
        Assertions.assertTrue(studentWasDeleted,"Student was not deleted");
    }

    @Test
    @DisplayName("Test find all students")
    void findAllTest(){
        //Arrange
        Set<Student> expectedList = new HashSet<>(List.of(studentId1, studentId2));
        //Act
        Set<Student> result = studentRepository.findAll();
        //Assert
        Assertions.assertEquals(expectedList, result, "Students were not found");
    }
}
