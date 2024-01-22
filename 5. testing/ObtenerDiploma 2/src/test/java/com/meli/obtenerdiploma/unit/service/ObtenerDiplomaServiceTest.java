package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.dto.StudentWithMessageDTO;
import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    private final Student student = new Student(
            1L,
            "Juan",
            new HashSet<>(Arrays.asList(
                    new Subject("Matemática", 9.0),
                    new Subject("Física", 7.0),
                    new Subject("Química", 6.0)
            ))
    );

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analizeScoreTest() {

        Long idParam = 1L;

        Mockito.when(studentRepository.findById(idParam)).thenReturn(Optional.ofNullable(student));
        StudentWithMessageDTO result = obtenerDiplomaService.analyzeScores(idParam);

        Assertions.assertEquals(7.333333333333333, result.averageScore());
        Assertions.assertEquals("El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.", result.message());
    }
}
