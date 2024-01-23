package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.dto.StudentWithMessageDTO;
import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    private IStudentRepository studentRepository;
    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analyzeScores(){
// Arrange
        Long id = 1L;
        // Act
        when(studentRepository.findById(id)).thenReturn(Optional.of(new Student(
                1L,
                "Juan",
                Set.of(
                        new Subject("Matemática", 9D),
                        new Subject("Física", 7D)
                )
        )));
        // Assert
        StudentWithMessageDTO result = obtenerDiplomaService.analyzeScores(id);
        System.out.println(result);
        Assertions.assertEquals("Juan", result.studentName());
    }
}
