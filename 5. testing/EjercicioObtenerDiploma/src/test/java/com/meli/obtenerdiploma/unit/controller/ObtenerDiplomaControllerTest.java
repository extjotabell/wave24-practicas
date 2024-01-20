package com.meli.obtenerdiploma.unit.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.dto.StudentWithMessageDTO;
import com.meli.obtenerdiploma.dto.SubjectDTO;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock private IObtenerDiplomaService obtenerDiplomaService;
    @InjectMocks private ObtenerDiplomaController obtenerDiplomaController;
    private final Subject subject1 = new Subject("Matemática", 10.0);
    private final Subject subject2 = new Subject("Física", 8.0);
    private final Subject subject3 = new Subject("Química", 4.0);

    @Test
    @DisplayName("Test that analyze scores is correct")
    public void analyzeScoresTest() {

        //arrange
        Long idParam = 2L;
        StudentWithMessageDTO studentDTO = new StudentWithMessageDTO(
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
        ResponseEntity<StudentWithMessageDTO> expected = ResponseEntity.ok(new StudentWithMessageDTO(
                        studentDTO.id(),
                        studentDTO.studentName(),
                        studentDTO.subjects(),
                        "El alumno Pedro ha obtenido un promedio de 7,33. Puedes mejorar.",
                        7.333333333333333
                ));

        //act
        Mockito.when(obtenerDiplomaService.analyzeScores(idParam)).thenReturn(studentDTO);
        ResponseEntity<StudentWithMessageDTO> result = obtenerDiplomaController.analyzeScores(idParam);

        //assert
        Assertions.assertEquals(expected, result, "The object not analyzed correctly");
    }
}
