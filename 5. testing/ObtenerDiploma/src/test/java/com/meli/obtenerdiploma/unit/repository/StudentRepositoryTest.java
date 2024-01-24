package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class StudentRepositoryTest {

    //Crear una instancia de la capa a testear
    IStudentRepository studentRepository = new StudentRepository();

    private final Subject subjectToTest = new Subject(
            "Programacion",
            7.0
    );
    private final Student studentToTest = new Student(
            2L,
            "Diego",
            Set.of(subjectToTest));

    private final Subject subject1 = new Subject("Matemática", 10.0);
    private final Subject subject2 = new Subject("Física", 8.0);
    private final Subject subject3 = new Subject("Química", 4.0);
    private final Student studentToSearch = new Student(
            2L,
            "Pedro",
            Set.of(subject1, subject2, subject3));

    @Test
    @DisplayName("Test validates that find the students correctly")
    public void findAll(){
        //Arrange
        int cantExpected = 2;

        //act
        var result = studentRepository.findAll();

        //assert
        Assertions.assertEquals( cantExpected, result.size(), "Error in the total of students" );
    }

    @Test
    @DisplayName("Test validates that students are saved correctly")
    public void save(){
        //Arrange
        Student expectedStudent = new Student(
                studentToTest.getId(),
                studentToTest.getStudentName(),
                studentToTest.getSubjects()
        );
        boolean expected = expectedStudent.equals(studentToTest);
        //Act

        var result = studentRepository.save(studentToTest);

        //Assert
        Assertions.assertEquals( expected, result, "Student not saved correctly" );
    }

    @Test
    @DisplayName("Test validates that students are deleted correctly")
    public void delete(){
        //Arrange
            //Se prepara el entorno con el estudiante que se espera guardar
        Student expectedStudent = new Student(
                studentToTest.getId(),
                studentToTest.getStudentName(),
                studentToTest.getSubjects()
        );
            //Se compara si el estudiante que se espera guardar es igual al que se va a guardar.
        boolean expected = expectedStudent.getId().equals(studentToTest.getId());
        //Act
        var result = studentRepository.delete(studentToTest.getId());
        //Assert
        Assertions.assertEquals( expected, result, "Student not deleted correctly" );
    }

    @Test
    @DisplayName("Test validates that exception of delete student is correctly")
    public void deleteSadPath(){
        //Arrange
            //se representa el estudiante que se espera que no exista.
        Student expectedStudent = new Student(
                4L,
                studentToTest.getStudentName(),
                studentToTest.getSubjects()
        );
        boolean expected = expectedStudent.getId().equals(studentToTest.getId());
        //Act & Asert
            //Metodo para comprobar que una operacion lanza una excepcion.
            //Si lanza una excep se considera un test exitoso.
        Assertions.assertThrows(
                StudentNotFoundException.class,
                () -> studentRepository.delete(expectedStudent.getId())
        );
    }

    @Test
    @DisplayName("Test validates that student is updated correctly")
    public void update() {
        //arrange
        Subject subjectToUpdate = new Subject(
                "Matemáticas",
                10.0
        );
        Student studentToUpdate = new Student(
                2L,
                "Diego",
                Set.of(subjectToUpdate)
        );

        Student expectedStudent = new Student(
                studentToTest.getId(),
                studentToTest.getStudentName(),
                Set.of(subjectToUpdate)
        );
        boolean expected = expectedStudent.equals(studentToUpdate);
        //act
        var result = studentRepository.update(studentToUpdate);

        //assert
        Assertions.assertEquals(expected, result, "Student not updated correctly");
    }

    @Test
    @DisplayName("Test validates that exception of update student is correctly")
    public void updateSadPath() {
        //arrange
        //arrange
        Subject subjectToUpdate = new Subject(
                "Matemáticas",
                10.0
        );
        Student studentToUpdate = new Student(
                4L,
                "Diego",
                Set.of(subjectToUpdate)
        );

        //act && assert
        Assertions.assertThrows(
                NullPointerException.class,
                () -> studentRepository.update(studentToUpdate)
        );
    }

    @Test
    @DisplayName("Test validates that student is finded correctly")
    public void findById() {
        //Arrange
        Student expectedStudent = new Student(
                studentToSearch.getId(),
                studentToSearch.getStudentName(),
                studentToSearch.getSubjects()
        );
        //Act
        var result = studentRepository.findById(studentToSearch.getId());

        //Asserge
        Assertions.assertEquals(expectedStudent, result, "Student isn't expected");
    }



}
