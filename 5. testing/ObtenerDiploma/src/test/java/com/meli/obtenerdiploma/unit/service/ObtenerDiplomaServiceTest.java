package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.dto.StudentWithMessageDTO;
import com.meli.obtenerdiploma.dto.SubjectDTO;
import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    private IStudentRepository studentRepository;
    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    private final Student studentId1 =
            new Student(
                    1L,
                    "Juan",
                    new HashSet<>(List.of(
                            new Subject("Matemática", 10.0),
                            new Subject("Física", 10.0),
                            new Subject("Química", 10.0)
                    ))
            );
    @Test
    @DisplayName("Test analyze scores")
    void analyzeScoresTest() {
        //Arrange
        Long idParam = 1L;
        StudentWithMessageDTO expectedStudentWithMessageDTO =
                new StudentWithMessageDTO(
                        1L,
                        "Juan",
                        new HashSet<>(List.of(
                                new SubjectDTO("Matemática", 10.0),
                                new SubjectDTO("Física", 10.0),
                                new SubjectDTO("Química", 10.0)
                        )),
                        "El alumno Juan ha obtenido un promedio de 10. Felicitaciones!",
                        10D
                );
        //Act
        Mockito.when(studentRepository.findById(idParam)).thenReturn(Optional.of(studentId1));
        StudentWithMessageDTO result = obtenerDiplomaService.analyzeScores(idParam);
        //Assert
        Assertions.assertEquals(
                expectedStudentWithMessageDTO,
                result,
                "The studentDTO resulted is not the expected");
    }
}
