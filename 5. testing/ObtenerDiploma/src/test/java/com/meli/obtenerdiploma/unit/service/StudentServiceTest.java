package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.dto.StudentDTO;
import com.meli.obtenerdiploma.dto.SubjectDTO;
import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
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
import java.util.Set;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    private final Student JUAN = new Student(
            1L,
            "Juan",
            new HashSet<>(Arrays.asList(
                    new Subject("Matemática", 9D),
                    new Subject("Física", 7D),
                    new Subject("Química", 6D)
            ))
    );
    private final StudentDTO JUAN_DTO = new StudentDTO(
            JUAN.getId(),
            JUAN.getStudentName(),
            JUAN.getSubjects().stream().map(
                    s -> new SubjectDTO(s.getName(), s.getScore())
            ).collect(Collectors.toSet())
    );
    private final Student PEDRO = new Student(
            2L,
            "Pedro",
            new HashSet<>(Arrays.asList(
                    new Subject("Matemática", 10D),
                    new Subject("Física", 8D),
                    new Subject("Química", 4D)
            ))
    );
    private final StudentDTO PEDRO_DTO = new StudentDTO(
            PEDRO.getId(),
            PEDRO.getStudentName(),
            PEDRO.getSubjects().stream().map(
                    s -> new SubjectDTO(s.getName(), s.getScore())
            ).collect(Collectors.toSet())
    );

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("Test to create a new Student")
    public void createStudentTest() {
        // Arrange
        boolean expected = true;

        // when-then
        Mockito.when(studentRepository.save(JUAN)).thenReturn(true);

        // Act
        boolean result = studentService.create(JUAN_DTO);

        // Assert
        Assertions.assertEquals(expected, result, "El resultado no fue el esperado");
    }

    @Test
    @DisplayName("Test that given a non-existent ID returns a exception")
    public void readNonExistentIDTest() {
        // Arrange
        long nonExistentId = 3;

        // when-then
        Mockito.when(studentRepository.findById(nonExistentId)).thenReturn(Optional.empty());

        // Act & Assert
        Assertions.assertThrows(
                StudentNotFoundException.class,
                () -> studentService.read(nonExistentId),
                "La excepción no coincide con StudentNotFoundException"
        );
    }

    @Test
    @DisplayName("Test that given a existent ID returns a StudentDTO object")
    public void readTest() {
        // Arrange
        long idParam = 1;

        // when-then
        Mockito.when(studentRepository.findById(idParam)).thenReturn(Optional.of(JUAN));

        // Act
        var result = studentService.read(idParam);

        // Assert
        Assertions.assertEquals(JUAN_DTO, result, "El objeto StudentDTO no coincide con el esperado");
    }

    @Test
    @DisplayName("Test that given a StudentDTO returns a boolean result")
    public void updateTest() {
        // Arrange
        boolean expected = true;

        // when-then
        Mockito.when(studentRepository.update(JUAN)).thenReturn(true);

        // Act
        var result = studentService.update(JUAN_DTO);

        // Assert
        Assertions.assertEquals(expected, result, "El resultado no coincide con lo esperado");
    }

    @Test
    @DisplayName("Test that given a StudentDTO returns a boolean result")
    public void removeTest() {
        // Arrange
        long idParam = 1;
        boolean expected = true;

        // when-then
        Mockito.when(studentRepository.delete(idParam)).thenReturn(true);

        // Act
        var result = studentService.delete(idParam);

        // Assert
        Assertions.assertEquals(expected, result, "El resultado no coincide con lo esperado");
    }

    @Test
    @DisplayName("Test to return all students")
    public void findAllTest() {
        // Arrange
        Set<StudentDTO> expected = new HashSet<>(
                Arrays.asList(
                        PEDRO_DTO,
                        JUAN_DTO
                )
        );

        // when-then
        Mockito.when(studentRepository.findAll()).thenReturn(new HashSet<>(
                Arrays.asList(
                        PEDRO,
                        JUAN
                )
        ));

        // Act
        var result = studentService.getAll();

        // Assert
        Assertions.assertEquals(expected, result, "El resultado no coincide con lo esperado");
    }
}
