package com.meli.obtenerdiploma.unittest.repository;

import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Optional;
import java.util.Set;

public class StudentRepositoryTest {

    StudentRepository studentRepository = new StudentRepository();
    @Test
    @DisplayName("Save student: should return true when saved")
    public void save(){
        //arrange
        Student param = new Student(1L, "alumno1", Set.of(
                new Subject("materia1", 7.0)
        ));

        //Act
        var obtenido = studentRepository.save(param);

        //Assert
        Assertions.assertTrue(obtenido);
    }

    @Test
    @DisplayName("Save student: should return false when not saved")
    public void notSave(){
        //arrange
        Student param = new Student(2L, "Pedro", Set.of(
                new Subject("Matemática", 10.0),
                new Subject("Física", 8.0),
                new Subject("Química", 4.0)
        ));

        //Act
        var obtenido = studentRepository.save(param);

        //Assert
        Assertions.assertFalse(obtenido);
    }

    @Test
    @DisplayName("findById: should return Student when found")
    public void findById(){
        //Arrange
        Long id = 2L;

        //Act
        var devolucion = new Student(2L, "Pedro", Set.of(
                new Subject("Matemática", 10.0),
                new Subject("Física", 8.0),
                new Subject("Química", 4.0)));
        var obtenido = studentRepository.findById(id);

        //Assert
        Assertions.assertEquals(devolucion, obtenido.get());

    }


    @Test
    @DisplayName("findById: should return empty optional when not found")
    public void emptyFindById(){
        //Arrange
        Long id = 3L;

        //Act
        Optional<Student> devolucion = Optional.empty();
        var obtenido = studentRepository.findById(id);

        //Assert
        Assertions.assertEquals(devolucion, obtenido);
    }

    @Test
    @DisplayName("delete: should return true when deleted")
    public void delete(){
        Long id = 1L;

        var obtenido = studentRepository.delete(id);
        Assertions.assertTrue(obtenido);
    }

    @Test
    @DisplayName("delete: should return false when not deleted")
    public void notDelete(){
        Long id = 3L;

        Assertions.assertThrows(StudentNotFoundException.class, ()->{
            studentRepository.delete(id);
        });
    }

    @Test
    @DisplayName("findAll: should return Set<Student> when found")
    public void findAll(){
        var devolucion = Set.of(
                new Student(1L, "Juan", Set.of(
                new Subject("Matemática", 9.0),
                new Subject("Física", 7.0),
                new Subject("Química", 6.0))),
                new Student(2L, "Pedro", Set.of(
                new Subject("Matemática", 10.0),
                new Subject("Física", 8.0),
                new Subject("Química", 4.0))));
        var obtenido = studentRepository.findAll();

        Assertions.assertEquals(devolucion, obtenido);
    }
}
