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
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    // Pedro Data for testing. First student, always charged.
    Subject pedroMath = new Subject("Matemática", 10.0);
    Subject pedroPhysics = new Subject("Física", 8.0);
    Subject pedroChemistry = new Subject("Química", 4.0);
    Set<Subject> pedroSubjects = new HashSet<>(){
        {
            add(pedroMath);
            add(pedroPhysics);
            add(pedroChemistry);
        }
    };
    Student pedroId1 = new Student(
            1L,
            "Pedro",
            pedroSubjects
    );

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Get Diploma Service: Analyze Scores with Existing Id.")
    void analyzingScoreWithExistingIdTest() {
        // Arrange
        Long idParam = 1L;
        StudentWithMessageDTO expectedStudent = new StudentWithMessageDTO(
                idParam,
                "Pedro",
                pedroSubjects
                        .stream()
                        .map(subject -> new SubjectDTO(subject.getName(), subject.getScore()))
                        .collect(Collectors.toSet()),
                "El alumno Pedro ha obtenido un promedio de 7,33. Puedes mejorar.",
                7.33
        );

        // Act
        Mockito
                .when(studentRepository.findById(idParam))
                .thenReturn(Optional.ofNullable(pedroId1));

        var result = obtenerDiplomaService.analyzeScores(idParam);

        // Assert
        Assertions.assertEquals(expectedStudent.message(), result.message());
    }

    @Test
    @DisplayName("Get Diploma Service: Analyze Scores with Non Existing Id.")
    void analyzingScoreWithNonExistingIdTest() {
        // Arrange
        Long idParam = 2L;

        // Act
        Mockito
                .when(studentRepository.findById(idParam))
                .thenReturn(Optional.empty());

        // Assert
        Assertions.assertThrows(
                StudentNotFoundException.class,
                () -> obtenerDiplomaService.analyzeScores(idParam)
        );
    }

    @Test
    @DisplayName("Get Diploma Service: Review Message over 9.")
    void getGreetingsMessageAbove9() {
        // Arrange
        Long idParam = 1L;
        String expectedName = "Pedro";
        Subject pedroMathAbove9 = new Subject("Matemática", 10.0);
        Subject pedroPhysicsAbove9 = new Subject("Física", 10.0);
        Subject pedroChemistryAbove9 = new Subject("Química", 10.0);
        Set<Subject> pedroSubjectsAbove9 = new HashSet<>(){
            {
                add(pedroMathAbove9);
                add(pedroPhysicsAbove9);
                add(pedroChemistryAbove9);
            }
        };
        Student pedroId1Above9 = new Student(
                1L,
                expectedName,
                pedroSubjectsAbove9
        );
        StudentWithMessageDTO expectedStudent = new StudentWithMessageDTO(
                idParam,
                expectedName,
                pedroSubjectsAbove9
                        .stream()
                        .map(subject -> new SubjectDTO(subject.getName(), subject.getScore()))
                        .collect(Collectors.toSet()),
                "El alumno Pedro ha obtenido un promedio de 10. Felicitaciones!",
                10.0
        );

        // Act
        Mockito
                .when(studentRepository.findById(idParam))
                .thenReturn(Optional.of(pedroId1Above9));

        var result = obtenerDiplomaService.analyzeScores(idParam);

        // Assert
        Assertions.assertEquals(result.message(), expectedStudent.message());
    }
}
