package com.meli.obtenerdiploma.unit.repository;


import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class StudentRepositoryTest {

    //no mock , sin dependencias o sin autowided

    //repositorio desde 0 o con datos desde 0 en resources
    IStudentRepository studentRepository = new StudentRepository();


    @Test
    @DisplayName("Verify that existing students")
    public void findAllStudents(){

        //arrange : que debo declara params, variables // lo que debe dar
        int count = 2;

        //act : lo que tengo en mi codigo

        var students = studentRepository.findAll().size();
        System.out.println(students);

        //assert

        Assertions.assertEquals( count,students, "parece que no estas obteniendo todos los estudiantes");

    }

    @Test
    @DisplayName("Verify that set is empty")
    public void setEmpty(){

        //arrange : que debo declara params, variables // lo que debe dar
         Optional<Object> expected = Optional.empty();

        //act : lo que tengo en mi codigo
        var students = studentRepository.findAll();

        //assert

        // Assert: Check if the set is empty
        Assertions.assertTrue(!students.isEmpty(), "The set should be empty");

    }


@Test
@DisplayName("Find a student")
public void findByIDStudent(){



    //arrange : preparar los datos a usar : parametro , retorn
    Student student1 = new Student((long) 1, "Anderson Pedrozq",
            Set.of(new Subject("Math", 100.0), new Subject("English", 50.0)));
    System.out.println(student1);


    boolean add = true;

    //act : lo que tengo en mi codigo
    var result = studentRepository.save(student1);
    System.out.println(result);
    //assert

    // Assert: Check if the set is empty
    Assertions.assertEquals(result,add,"No se pudo agregar el estudiante ");

}

@Test
@DisplayName("Delete  students")
public void deleteStudent(){

        //arrange
    Long idStudent = (long)123;

    //act : lo que tengo en mi codigo
    //var result = studentRepository.delete(idStudent);

    //assert and act
    Assertions.assertThrows(StudentNotFoundException.class,
            ()->{ studentRepository.delete(idStudent);});

}
}
