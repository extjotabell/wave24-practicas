package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.exception.InvalidDuplicatedDataException;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class StudentRepositoryTest {
    // Pedro Data for testing. First student, always charged.
    Subject pedroMath = new Subject("Matemática", 10.0);
    Subject pedroPhysics = new Subject("Física", 8.0);
    Subject pedroChemistry = new Subject("Química", 4.0);
    Set<Subject> pedroSubjects = new HashSet<>(){
        {
            add(pedroMath);
            add(pedroPhysics);
            add(pedroChemistry);
        }
    };
    Student pedroId1 = new Student(
            1L,
            "Pedro",
            pedroSubjects
    );
    IStudentRepository studentRepository = new StudentRepository(new HashSet<>(){
        {
            add(pedroId1);
        }
    });

    // Juan Data for testing. Second student, It can be used to save.
    Subject JuanMath = new Subject("Matemática", 9.0);
    Subject JuanPhysics = new Subject("Física", 7.0);
    Subject JuanChemistry = new Subject("Química", 6.0);
    Set<Subject> JuanSubjects = new HashSet<>(){
        {
            add(JuanMath);
            add(JuanPhysics);
            add(JuanChemistry);
        }
    };

    @Test
    @DisplayName("Students: Find All.")
    void findAllTest() {
        //Arrange
        Integer resLength = 1;

        //Act
        var results = studentRepository.findAll();

        //Assert
        Assertions.assertEquals(results.size(), resLength);
    }

    @Test
    @DisplayName("Students: Find By Existing Id.")
    void findByExistingIdTest() {
        //Arrange
        String name = "Pedro";
        Long id = 1L;

        //Act
        var results = studentRepository.findById(id);

        //Assert
        if (results.isPresent()) {
            var resultName = results.get().getStudentName();
            var resultId = results.get().getId();

            Assertions.assertTrue(resultName.equals(name) && resultId.equals(id));
        }
    }

    @Test
    @DisplayName("Students: Find By Non Existing Id.")
    void findByNonExistingIdTest() {
        //Arrange
        String name = "Pedro";
        Long id = 10L;

        //Act
        var results = studentRepository.findById(id);

        //Assert
        Assertions.assertTrue(results.isEmpty());
    }

    @Test
    @DisplayName("Students: Save Unknown Id.")
    void saveUnknownIdTest() {
        //Arrange
        Student juanId2 = new Student(
                2L,
                "Juan",
                JuanSubjects
        );

        // Act
        var results = studentRepository.save(juanId2);

        // Assert
        Assertions.assertTrue(results);
    }

    @Test
    @DisplayName("Students: Save Existing Id.")
    void saveExistingIdTest() {
        //Arrange
        Student juanId1 = new Student(
                1L,
                "Juan",
                JuanSubjects
        );

        // Act
        // Assert
        Assertions.assertThrows(
                InvalidDuplicatedDataException.class,
                () -> studentRepository.save(juanId1)
        );
    }

    @Test
    @DisplayName("Students: Update Unknown Id.")
    void updateUnknownIdTest() {
        //Arrange
        Student juanId2 = new Student(
                2L,
                "Juan",
                JuanSubjects
        );

        // Act
        // Assert
        Assertions.assertThrows(
                StudentNotFoundException.class,
                () -> studentRepository.update(juanId2)
        );
    }

    @Test
    @DisplayName("Students: Update Existing Id.")
    void updateExistingIdTest() {
        //Arrange
        Student juanId1 = new Student(
                1L,
                "Juan",
                JuanSubjects
        );

        // Act
        var results = studentRepository.update(juanId1);

        // Assert
        Assertions.assertTrue(results);
    }

    @Test
    @DisplayName("Students: Delete Existing Id.")
    void deleteExistingIdTest() {
        //Arrange
        Long id = 1L;

        // Act
        var results = studentRepository.delete(id);

        // Assert
        Assertions.assertTrue(results);
    }

    @Test
    @DisplayName("Students: Delete Non Existing Id.")
    void deleteNonExistingIdTest() {
        //Arrange
        Long id = 10L;

        // Act
        // Assert
        Assertions.assertThrows(
                StudentNotFoundException.class,
                () -> studentRepository.delete(id)
        );
    }
}
