package com.demospring.demo.unit.repository;

import com.demospring.demo.entity.Alumno;
import com.demospring.demo.entity.Materia;
import com.demospring.demo.repository.AlumnoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class AlumnoRepositoryTest {
    //"dni" : "1111111",
    //    "name": "Joy",
    //    "age" : 18,
    //    "birthDate": "2006-07-12",
    //    "materiasList" : [
    //      {
    //        "id" : 1,
    //        "name": "Matematicas",
    //        "promedio" : 7
    //      }
    //    ]
    private static Alumno alumnoJoy = new Alumno("1111111",
            "Joy",
            LocalDate.of(2006, 07, 12),
            18,
            List.of(new Materia(
                    "1", "Matematicas", 7D
            ))
    );


    private AlumnoRepository alumnoRepository = new AlumnoRepository();

    @Test
    @DisplayName("Test that given an id returns the correct student")
    public void getAlumnoByIdHappyPath(){
        //arrange
        String dni = "1111111";
        Optional<Alumno> expected = Optional.of(alumnoJoy);

        // act

        var result = alumnoRepository.findById(dni);

        // assert

        Assertions.assertEquals(expected, result, "El alumno expected no coincide con el resultado");
    }

    @Test
    @DisplayName("Test that given an incorrect id returns empty")
    public void getAlumnoByIdSadPath(){
        //arrange
        String dni = "1111";
        Optional<Alumno> expected = Optional.empty();

        // act

        var result = alumnoRepository.findById(dni);

        // assert

        Assertions.assertEquals(expected, result, "El alumno expected no coincide con el resultado");
    }

}
