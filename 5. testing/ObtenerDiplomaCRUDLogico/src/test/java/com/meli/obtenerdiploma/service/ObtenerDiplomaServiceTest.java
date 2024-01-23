package com.meli.obtenerdiploma.service;


import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;


    @Test
    public void testAnalyzeScoresLowAverage() {
        SubjectDTO matematica = new SubjectDTO("Matemática", 1D);
        SubjectDTO fisica = new SubjectDTO("Física", 1D);
        SubjectDTO quimica = new SubjectDTO("Química", 1D);
        List<SubjectDTO> subjects = List.of(matematica, fisica, quimica);

        StudentDTO student = new StudentDTO(1L, "Juan", null, null, subjects);

        Mockito.when(studentDAO.findById(1L)).thenReturn(student);

        StudentDTO expected = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 1. Puedes mejorar.", 1D, subjects);
        StudentDTO actual = obtenerDiplomaService.analyzeScores(1L);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testAnalyzeScoresHighAverage() {
        SubjectDTO matematica = new SubjectDTO("Matemática", 10D);
        SubjectDTO fisica = new SubjectDTO("Física", 10D);
        SubjectDTO quimica = new SubjectDTO("Química", 10D);
        List<SubjectDTO> subjects = List.of(matematica, fisica, quimica);

        StudentDTO student = new StudentDTO(1L, "Juan", null, null, subjects);

        Mockito.when(studentDAO.findById(1L)).thenReturn(student);

        StudentDTO expected = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 10. Felicitaciones!", 10D, subjects);
        StudentDTO actual = obtenerDiplomaService.analyzeScores(1L);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testAnalyzeScoresStudentNotFound() {
        Mockito.when(studentDAO.findById(100L)).thenThrow(new StudentNotFoundException(100L));
        Assertions.assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(100L));
    }
}
