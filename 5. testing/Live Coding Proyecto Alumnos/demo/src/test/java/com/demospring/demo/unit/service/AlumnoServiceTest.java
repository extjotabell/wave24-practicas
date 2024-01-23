package com.demospring.demo.unit.service;

import com.demospring.demo.dto.AlumnoDTO;
import com.demospring.demo.dto.MateriaDTO;
import com.demospring.demo.entity.Alumno;
import com.demospring.demo.entity.Materia;
import com.demospring.demo.exceptions.IdNoEncontradoException;
import com.demospring.demo.repository.AlumnoRepository;
import com.demospring.demo.service.AlumnoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@AutoConfigureMockMvc
@SpringBootTest
public class AlumnoServiceTest {

    private static AlumnoDTO alumnoJoyDto = new AlumnoDTO("1111111",
            "Joy",
            LocalDate.of(2006, 07, 12),
            18,
            List.of(new MateriaDTO(
                    "1", "Matematicas", 7D
            ))
    );

    private static Alumno alumnoJoy = new Alumno("1111111",
            "Joy",
            LocalDate.of(2006, 07, 12),
            18,
            List.of(new Materia(
                    "1", "Matematicas", 7D
            ))
    );

    @Mock
    AlumnoRepository alumnoRepository;

    @InjectMocks
    AlumnoService alumnoService;

    @Test
    @DisplayName("Given an id returns a dto representation of the entity")
    public void findByIdHappyPath(){
        // arrange
        String dni = "1111111";
        AlumnoDTO expected = alumnoJoyDto;

        // act

        Mockito.when(alumnoRepository.findById(dni)).thenReturn(Optional.of(alumnoJoy));
        var result = alumnoService.findById(dni);

        // assert

        Assertions.assertEquals(expected, result, "Los alumnos no coinciden");
    }

    @Test
    @DisplayName("Given an id does not find a result")
    public void findByIdSadPath(){
        // arrange
        String dni = "1";
        AlumnoDTO expected = alumnoJoyDto;

        // act

        Mockito.when(alumnoRepository.findById(dni)).thenReturn(Optional.empty());


        // assert
        Assertions.assertThrows(
                IdNoEncontradoException.class,
                ()->{
                    alumnoService.findById(dni);
                }
        );
    }
}
