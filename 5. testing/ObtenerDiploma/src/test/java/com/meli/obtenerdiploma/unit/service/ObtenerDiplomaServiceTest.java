package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.dto.StudentWithMessageDTO;
import com.meli.obtenerdiploma.dto.SubjectDTO;
import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    private final Student JUAN = new Student(
            1L,
            "Juan",
            new HashSet<>(Arrays.asList(
                    new Subject("Matemática", 9D),
                    new Subject("Física", 7D),
                    new Subject("Química", 6D)
            ))
    );
    private final Student PEDRO = new Student(
            2L,
            "Pedro",
            new HashSet<>(Arrays.asList(
                    new Subject("Matemática", 10D),
                    new Subject("Física", 9D),
                    new Subject("Química", 10D)
            ))
    );

    private final StudentWithMessageDTO JUAN_DTO = new StudentWithMessageDTO(
            JUAN.getId(),
            JUAN.getStudentName(),
            JUAN.getSubjects().stream().map(
                    subject -> new SubjectDTO(
                            subject.getName(),
                            subject.getScore()
                    )
            ).collect(Collectors.toSet()),
            "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.",
            7.333333333333333
    );

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Test that given a ID returns DTO")
    public void analyzeScoresResponseTest() {
        // Arrange
        long idParam = 1;
        StudentWithMessageDTO expected = JUAN_DTO;

        // when - then return
        Mockito.when(studentRepository.findById(idParam)).thenReturn(Optional.of(JUAN));

        // Act
        var result = obtenerDiplomaService.analyzeScores(idParam);

        // Assert
        Assertions.assertEquals(expected, result, "El resultado DTO no coincide");
    }

    @Test
    @DisplayName("Test that given a non-existent ID returns StudentNotFoundException")
    public void analyzeScoresByNonExistentIDTest() {
        // Arrange
        long nonExistentID = 3;

        // when - then return
        Mockito.when(studentRepository.findById(nonExistentID)).thenReturn(Optional.empty());

        // Assert
        Assertions.assertThrows(
                StudentNotFoundException.class,
                () -> obtenerDiplomaService.analyzeScores(nonExistentID)
        );
    }

    @Test
    @DisplayName("Test that given a student return a congratulations message")
    public void getGreetingMessageCongratulationsTest() {
        // Arrange
        long idParam = 1;
        String expected = "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.";

        // when - then return
        Mockito.when(studentRepository.findById(idParam)).thenReturn(Optional.of(JUAN));

        // Act
        String result = obtenerDiplomaService.analyzeScores(idParam).message();

        // Assert
        Assertions.assertEquals(expected, result, "El mensaje no coincide");
    }

    @Test
    @DisplayName("Test that given a student return a message")
    public void getGreetingMessageTest() {
        // Arrange
        long idParam = 2;
        String expected = "El alumno Pedro ha obtenido un promedio de 9.67. Felicitaciones!";

        // when - then return
        Mockito.when(studentRepository.findById(idParam)).thenReturn(Optional.of(PEDRO));

        // Act
        String result = obtenerDiplomaService.analyzeScores(idParam).message();

        // Assert
        Assertions.assertEquals(expected, result, "El mensaje no coincide");
    }

    @Test
    @DisplayName("Test to valid average result")
    public void averageResultTest(){
        // Arrange
        long idParam = 2;
        double expected = 9.666666666666666;

        // when - then return
        Mockito.when(studentRepository.findById(idParam)).thenReturn(Optional.of(PEDRO));

        // Act
        double result = obtenerDiplomaService.analyzeScores(idParam).averageScore();

        // Assert
        Assertions.assertEquals(expected, result, "El promedio no coincide");
    }
}
