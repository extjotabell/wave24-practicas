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

    IStudentRepository studentRepository = new StudentRepository();
    private final Subject subjectToCreate = new Subject("POO", 9.0);
    private final Student studentToCreate = new Student(
            2L,
            "Carlos",
            Set.of(subjectToCreate)
    );

    private final Subject subject1 = new Subject("Matemática", 10.0);
    private final Subject subject2 = new Subject("Física", 8.0);
    private final Subject subject3 = new Subject("Química", 4.0);

    private final Student student2 = new Student(
            2L, "Pedro", Set.of(subject1, subject2, subject3)
    );


    @Test
    @DisplayName("Test validates that save student correctly")
    public void save() {
        //arrange
        Student expectedStudent = new Student(studentToCreate.getId(), studentToCreate.getStudentName(), studentToCreate.getSubjects());
        boolean expected = expectedStudent.equals(studentToCreate);
        //act
        var result = studentRepository.save(studentToCreate);

        //assert
        Assertions.assertEquals(expected, result, "Student not saved correctly");
    }

    @Test
    @DisplayName("Test that given a name returns the correct object")
    public void findById() {
        //arrange
        Long expected = 2L;
        Optional<Student> expectedStudent = Optional.of(student2);
        //act
        var result = studentRepository.findById(expected);
        //assert
        Assertions.assertEquals(expectedStudent, result, "Student does not correspond to the expected id");
    }

    @Test
    @DisplayName("Test validates that update student correctly")
    public void update() {
        //arrange
         Subject subjectToUpdate = new Subject("Matemáticas", 8.0);
         Student studentToUpdate = new Student(
                2L,
                "Carlos",
                Set.of(subjectToUpdate)
        );

        Student expectedStudent = new Student(studentToUpdate.getId(), studentToUpdate.getStudentName(), studentToUpdate.getSubjects());
        boolean expected = expectedStudent.equals(studentToUpdate);

        //act
        var result = studentRepository.update(studentToUpdate);

        //assert
        Assertions.assertEquals(expected, result, "Student not updated correctly");
    }

    @Test
    @DisplayName("Test validates that update student not correctly")
    public void updateFalse() {
        //arrange
        Subject subjectToUpdate = new Subject("Matemáticas", 8.0);
        Student studentToUpdate = new Student(
                4L,
                "Carlos",
                Set.of(subjectToUpdate)
        );

        Student expectedStudent = student2;
        boolean expected = expectedStudent.equals(studentToUpdate);

        //act
        var result = studentRepository.update(studentToUpdate);

        //assert
        Assertions.assertEquals(expected, result, "Student updated correctly");
    }

    @Test
    @DisplayName("Test validates that delete student correctly")
    public void delete() {
        //arrange
        Long expected = 2L;
        //act
        var result = studentRepository.delete(expected);

        //assert
        Assertions.assertEquals(true, result, "Student not deleted correctly");
    }

    @Test
    @DisplayName("Test validates that delete student not correctly")
    public void deleteException() {

        //arrange
        Long expected = 3L;

        //act & assert
        Assertions.assertThrows(
                StudentNotFoundException.class,
                () -> studentRepository.delete(expected)
        );
    }

    @Test
    @DisplayName("Test validates that find all students correctly")
    public void findAll() {
        //arrange
        int cantExpected = 2;
        //act
        var result = studentRepository.findAll();

        //assert
        Assertions.assertEquals(cantExpected, result.size(), "Students not found correctly");
    }

}
