package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class StudentRepositoryTest {

    IStudentRepository repository = new StudentRepository();
    private final Student student1 = new Student(
            1L,
            "Juan",
            new HashSet<>(Set.of(new Subject(
                    "Matemática",
                    9D
            ), new Subject(
                    "Física",
                    7D
            ), new Subject(
                    "Química",
                    6D
            )))
    );
    private final Student student2 = new Student(
            2L,
            "Pedro",
            new HashSet<>(Set.of(new Subject(
                    "Matemática",
                    10D
            ), new Subject(
                    "Física",
                    8D
            ), new Subject(
                    "Química",
                    4D
            )))
    );

    @Test
    @DisplayName("Test that validates that the list is the same size")
public void findAll(){
        // arrange
        int cantResults = 2;

        // act
        var result =  repository.findAll();

        // assert
        Assertions.assertEquals(cantResults, result.size(),"Las listas no coinciden");
    }

    @Test
    @DisplayName("Test validates that list return the same objects")
    public void findAll2(){

        // arrange

        ArrayList<Student> expected = new ArrayList<>();
        expected.add(student2);

        expected.add(student1);

        // act
        var result =  repository.findAll();

        // assert
        Assertions.assertIterableEquals(expected, result, "Las listas no tienen los mismos datos");

    }

    @Test
    @DisplayName("Test that by receiving an id returns the correct object")
    public void findByIdTest(){

        //arrange
        long idParam = 1;

        Optional<Student> expected = Optional.of(student1);

        // act

        var result = repository.findById(idParam);

        // assert
        Assertions.assertEquals(expected, result, "El objeto no corresponde al id brindado.");

    }

    @Test
    @DisplayName("Test that validates the save method with a new student")
    public void saveNewStudent() {
        // arrange
        Student newStudent = new Student(
                3L,
                "Maria",
                new HashSet<>(Set.of(new Subject("Historia", 8D)))
        );

        // act
        boolean saved = repository.save(newStudent);

        // assert
        Assertions.assertTrue(saved, "El estudiante no pudo ser guardado correctamente");
        Set<Student> allStudents = repository.findAll();
        Assertions.assertTrue(allStudents.contains(newStudent), "El estudiante no está presente en la lista después de guardar");
    }

    @Test
    @DisplayName("Test that validates the save method with an existing student")
    public void saveExistingStudent() {
        // arrange
        Student existingStudent = student1;

        // act
        boolean saved = repository.save(existingStudent);

        // assert
        Assertions.assertFalse(saved, "El estudiante ya existente no debería ser guardado nuevamente");
        Set<Student> allStudents = repository.findAll();
        Assertions.assertEquals(2, allStudents.size(), "El número de estudiantes no debe cambiar después de intentar guardar uno ya existente");
    }

    @Test
    @DisplayName("Test that validates the delete method with an existing student")
    public void deleteExistingStudent() {
        // arrange
        long existingStudentId = student1.getId();

        // act
        boolean deleted = repository.delete(existingStudentId);

        // assert
        Assertions.assertTrue(deleted, "El estudiante existente no pudo ser eliminado");
        Set<Student> allStudents = repository.findAll();
        Assertions.assertEquals(1, allStudents.size(), "El número de estudiantes debe disminuir después de eliminar uno existente");
        Assertions.assertTrue(allStudents.stream().noneMatch(student -> student.getId() == existingStudentId), "El estudiante eliminado todavía está presente en la lista");
    }

    @Test
    @DisplayName("Test that validates the delete method with a non-existing student")
    public void deleteNonExistingStudent() {
        // arrange
        long nonExistingStudentId = 999L;

        // act
        boolean deleted = repository.delete(nonExistingStudentId);

        // assert
        Assertions.assertFalse(deleted, "No se debería poder eliminar un estudiante que no existe");
        Set<Student> allStudents = repository.findAll();
        Assertions.assertEquals(2, allStudents.size(), "El número de estudiantes no debe cambiar después de intentar eliminar uno que no existe");
    }


}
