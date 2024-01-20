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
import java.text.DecimalFormat;
import java.util.Optional;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock private IStudentRepository studentRepository;
    @InjectMocks private ObtenerDiplomaService obtenerDiplomaService;

    private final Subject subject1 = new Subject("Matemática", 10.0);
    private final Subject subject2 = new Subject("Física", 8.0);
    private final Subject subject3 = new Subject("Química", 4.0);

    private final Student student2 = new Student(
            2L, "Pedro", Set.of(subject1, subject2, subject3)
    );

    @Test
    @DisplayName("Test that calculate if average is calculated correctly")
    public void calculateAverage() {
        //arrange
        Double expected = 7.333333333333333;
        Long expectedId = 2L;

        //act
        Mockito.when(studentRepository.findById(expectedId)).thenReturn(Optional.of(student2));

        StudentWithMessageDTO result = obtenerDiplomaService.analyzeScores(expectedId);
        //assert
        Assertions.assertEquals(expected, result.averageScore(), "Average not calculated correctly");
    }

    @Test
    @DisplayName("Test that calculate if average is calculated correctly")
    public void getGreetingMessageTest() {
        //arrange
        Double expected = 7.333333333333333;
        Long expectedId = 2L;
        String expectedMessage =
                "El alumno " + student2.getStudentName() + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(expected)
                        + ((expected > 9) ? ". Felicitaciones!" : ". Puedes mejorar.");

        //act
        Mockito.when(studentRepository.findById(expectedId)).thenReturn(Optional.of(student2));
        StudentWithMessageDTO result = obtenerDiplomaService.analyzeScores(expectedId);

        //assert
        Assertions.assertEquals(expectedMessage, result.message(), "Average not calculated correctly");
    }

    @Test
    @DisplayName("Test that analyze scores is calculated correctly")
    public void analyzeScoresTest() {

        //arrange
        Long idParam = 2L;
        StudentWithMessageDTO expected = new StudentWithMessageDTO(
                2L,
                "Pedro",
                Set.of(
                        new SubjectDTO(subject2.getName(), subject2.getScore()),
                        new SubjectDTO(subject3.getName(), subject3.getScore()),
                        new SubjectDTO(subject1.getName(), subject1.getScore())
                ),
                "El alumno Pedro ha obtenido un promedio de 7,33. Puedes mejorar.",
                7.333333333333333
        );

        //act
        Mockito.when(studentRepository.findById(2L)).thenReturn(Optional.of(student2));
        StudentWithMessageDTO result = obtenerDiplomaService.analyzeScores(idParam);

        //assert
        Assertions.assertEquals(expected, result, "The object not analyzed correctly");
    }
}
