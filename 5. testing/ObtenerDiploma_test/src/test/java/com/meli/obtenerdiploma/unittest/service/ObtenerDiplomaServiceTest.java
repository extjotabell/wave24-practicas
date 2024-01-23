package com.meli.obtenerdiploma.unittest.service;

import com.meli.obtenerdiploma.dto.StudentWithMessageDTO;
import com.meli.obtenerdiploma.dto.SubjectDTO;
import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.Optional;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("analyzeScores: should return StudentWithMessageDTO when analyzed Scores")
    public void analyzeScores(){
        Long studentId = 2L;
        StudentWithMessageDTO studentWithMessageDTO = new StudentWithMessageDTO(
                2L,
                "Pedro",
                Set.of(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0)),
                "El alumno Pedro ha obtenido un promedio de 7.33. Puedes mejorar.",
                7.333333333333333);
        Student student = new Student(2L,
                "Pedro",
                Set.of(
                        new Subject("Física", 8.0),
                        new Subject("Química", 4.0),
                        new Subject("Matemática", 10.0)
                        ));

        Mockito.when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));
        var result = obtenerDiplomaService.analyzeScores(studentId);

        Assertions.assertEquals(studentWithMessageDTO, result);
    }

    @Test
    @DisplayName("analyzeScores: should return StudentNotFoundException when not found student id")
    public void notAnalyzeScores(){
        Long studentId = 3L;
        Assertions.assertThrows(StudentNotFoundException.class, ()->{
            obtenerDiplomaService.analyzeScores(studentId);
        });
    }


    }
