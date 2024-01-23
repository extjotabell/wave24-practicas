package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.dto.StudentWithMessageDTO;
import com.meli.obtenerdiploma.dto.SubjectDTO;
import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    private static StudentWithMessageDTO studentWithMessageDto = new StudentWithMessageDTO(
            1L,
            "Juan",
            Set.of(new SubjectDTO(
                    "Matemática",
                    9.0),
                    new SubjectDTO(
                            "Química",
                            6.0),
                    new SubjectDTO(
                            "Física",
                            7.0)
            ),
            "",
            7.333333333333333);


    private static Student student = new Student(
            1L,
            "Juan",
            Set.of(new Subject(
                            "Matemática",
                            9.0),
                    new Subject(
                            "Física",
                            7.0),
                    new Subject(
                            "Química",
                            6.0)
            )
    );

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analyzeScores(){
        Long id = 1L;

        String formattedAverage = new DecimalFormat("#.##").format(studentWithMessageDto.averageScore());
        StudentWithMessageDTO expected = new StudentWithMessageDTO(
                studentWithMessageDto.id(),
                studentWithMessageDto.studentName(),
                studentWithMessageDto.subjects(),
                "El alumno " + studentWithMessageDto.studentName() +
                        " ha obtenido un promedio de " + formattedAverage +
                        ((studentWithMessageDto.averageScore() > 9) ? ". Felicitaciones!" : ". Puedes mejorar."),
                studentWithMessageDto.averageScore()
        );

        Mockito.when(studentRepository.findById(id)).thenReturn(Optional.of(student));
        var result = obtenerDiplomaService.analyzeScores(id);


        Assertions.assertEquals(expected, result, "Los promedios no coinciden");
    }
}
