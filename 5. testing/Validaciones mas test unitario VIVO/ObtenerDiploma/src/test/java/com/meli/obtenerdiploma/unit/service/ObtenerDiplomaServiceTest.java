package com.meli.obtenerdiploma.unit.service;


import com.meli.obtenerdiploma.dto.StudentDTO;
import com.meli.obtenerdiploma.dto.SubjectDTO;
import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analyzeScores(){

        //agrupar
        int averageExpected = 7;

        Student s = new Student(1L, "Juan",
                Set.of(new Subject("Matematica", 7.0),
                        new Subject("Lengua", 8.0),
                        new Subject("Ciencias", 6.0)));


        //act

        Mockito.when(studentRepository.findById(1L)).thenReturn(Optional.of(s));
        var result = obtenerDiplomaService.analyzeScores(1L);

        //assert
        Assertions.assertEquals(result.averageScore(), averageExpected);
    }

}
