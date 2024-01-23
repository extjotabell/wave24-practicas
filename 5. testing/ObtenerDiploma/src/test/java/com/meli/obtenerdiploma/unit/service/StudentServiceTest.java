package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.dto.StudentDTO;
import com.meli.obtenerdiploma.dto.SubjectDTO;
import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @InjectMocks
    private StudentService service = new StudentService();
    @Mock
    private IStudentRepository repository = new StudentRepository();
    private final StudentDTO student1 = new StudentDTO(
            1L,
            "Juan",
            new HashSet<>(Set.of(new SubjectDTO(
                    "Matemática",
                    9D
            ), new SubjectDTO(
                    "Física",
                    7D
            ), new SubjectDTO(
                    "Química",
                    6D
            )))
    );
    private final StudentDTO student2 = new StudentDTO(
            2L,
            "Pedro",
            new HashSet<>(Set.of(new SubjectDTO(
                    "Matemática",
                    10D
            ), new SubjectDTO(
                    "Física",
                    8D
            ), new SubjectDTO(
                    "Química",
                    4D
            )))
    );


    @Test
    @DisplayName("Test for creating a new student")
    public void createStudent() {
        // arrange
        StudentDTO studentDTO = new StudentDTO(
                3L,
                "Maria",
                Set.of(new SubjectDTO("Historia", 8D))
        );

        Mockito.when(repository.save(Mockito.any())).thenReturn(true);

        // act
        boolean created = service.create(studentDTO);

        // assert
        Assertions.assertTrue(created, "No se pudo crear correctamente al estudiante");
    }

    @Test
    @DisplayName("Test for reading an existing student")
    public void readExistingStudent() {
        // arrange
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(new Student(
                1L,
                "Juan",
                Set.of(new Subject("Matemática", 0D))
        )));

        // act
        StudentDTO studentDTO = service.read(1L);

        // assert
        Assertions.assertEquals("Juan", studentDTO.studentName(), "El nombre del estudiante no coincide");
    }

    @Test
    @DisplayName("Test for updating an existing student")
    public void updateExistingStudent() {
        // arrange
        StudentDTO studentDTO = new StudentDTO(
                1L,
                "Juan Updated",
                Set.of(new SubjectDTO("Matemática", 9D))
        );

        Mockito.when(repository.save(Mockito.any())).thenReturn(true);

        // act
        boolean updated = service.update(studentDTO);

        // assert
        Assertions.assertTrue(updated, "No se pudo actualizar correctamente al estudiante existente");
    }

    @Test
    @DisplayName("Test for deleting an existing student")
    public void deleteExistingStudent() {
        // arrange
        Mockito.when(repository.delete(1L)).thenReturn(true);

        // act
        boolean deleted = service.delete(1L);

        // assert
        Assertions.assertTrue(deleted, "No se pudo eliminar correctamente al estudiante existente");
    }

    @Test
    @DisplayName("Test for getting all students")
    public void getAllStudents() {
        // arrange
        Set<Student> expectedStudents = Set.of(
                new Student(1L, "Juan", Set.of(new Subject("Matemática", 0D))),
                new Student(2L, "Pedro", Set.of(new Subject("Física", 0D)))
        );

        Mockito.when(repository.findAll()).thenReturn(expectedStudents);

        // act
        Set<StudentDTO> allStudents = service.getAll();

        // assert
        Assertions.assertEquals(expectedStudents.size(), allStudents.size(), "El número de estudiantes no coincide");
    }



}
