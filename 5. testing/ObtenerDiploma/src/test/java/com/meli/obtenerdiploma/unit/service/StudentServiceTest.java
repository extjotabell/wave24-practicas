package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.dto.StudentDTO;
import com.meli.obtenerdiploma.dto.SubjectDTO;
import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    private static StudentDTO studentDTO = new StudentDTO(
            1L,
            "Juan",
            Set.of(new SubjectDTO(
                            "Matemática",
                            9.0),
                    new SubjectDTO(
                            "Física",
                            7.0),
                    new SubjectDTO(
                            "Química",
                            6.0)
            )
    );

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
    StudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("Create a new student")
    public void createTestHappyPath(){
        boolean expected = true;

        Mockito.when(studentRepository.save(student)).thenReturn(true);
        var result = studentService.create(studentDTO);

        Assertions.assertEquals(expected,result);

    }

    @Test
    @DisplayName("Given an id returns a studentDTO")
    public void readTestHappyPath() {
        Long id = 1L;
        StudentDTO expected = new StudentDTO(
                1L,
                "Juan",
                Set.of(new SubjectDTO(
                                "Matemática",
                                0D),
                        new SubjectDTO(
                                "Física",
                                0D),
                        new SubjectDTO(
                                "Química",
                                0D)
                )
        );

        Mockito.when(studentRepository.findById(id)).thenReturn(Optional.of(student));
        var result = studentService.read(id);

        Assertions.assertEquals(expected,result,"Los estudiantes no coinciden");
    }

    @Test
    @DisplayName("Does not find a result for the given id")
    public void readTestSadPath(){
        Long id = 4L;
        StudentDTO expected = new StudentDTO(
                1L,
                "Juan",
                Set.of(new SubjectDTO(
                                "Matemática",
                                0D),
                        new SubjectDTO(
                                "Física",
                                0D),
                        new SubjectDTO(
                                "Química",
                                0D)
                )
        );

        Mockito.when(studentRepository.findById(id)).thenReturn(Optional.empty());

        Assertions.assertThrows(StudentNotFoundException.class,
                () -> {studentService.read(id);});

    }

    @Test
    @DisplayName("A student has been updated")
    public void updateTestHappyPath(){
        StudentDTO studentDTO = new StudentDTO(
                1L, "John Doe",
                Set.of(new SubjectDTO(
                        "Matemática",
                        9.0),
                new SubjectDTO(
                        "Física",
                        7.0),
                new SubjectDTO(
                        "Química",
                        6.0)
                )
        );

        Mockito.when(studentRepository.save(any(Student.class))).thenReturn(true);
        boolean result = studentService.update(studentDTO);

        Assertions.assertTrue(result, "El estudiante se actualiza correctamente");
    }

    @Test
    @DisplayName("A student could not been updated")
    public void updateTestHSadPath(){
        StudentDTO studentDTO = new StudentDTO(
                5L, null,
                Set.of(new SubjectDTO(
                                "Matemática",
                                9.0),
                        new SubjectDTO(
                                "Física",
                                7.0),
                        new SubjectDTO(
                                "Química",
                                6.0)
                )
        );

        Mockito.when(studentRepository.save(any(Student.class))).thenReturn(false);
        boolean result = studentService.update(studentDTO);

        Assertions.assertFalse(result, "No se pudo actualizar");
    }

    @Test
    @DisplayName("Delete a student with a given id")
    public void deleteTestHappyPath(){
        Long id = 1L;
        boolean expected = true;

        Mockito.when(studentRepository.delete(id)).thenReturn(true);
        var result = studentService.delete(id);

        Assertions.assertEquals(expected,result, "Los resultados no coinciden");
    }

    @Test
    @DisplayName("Delete a student with a given id")
    public void deleteTestSadPath(){
        Long id = 5L;

        Mockito.when(studentRepository.delete(id)).thenReturn(false);
        var result = studentService.delete(id);

        Assertions.assertFalse(result,"Los resultados no coinciden");
    }

    @Test
    @DisplayName("find all students")
    public void getAllTestHappyPath(){
        int expected = 2;

        Set<Student> studentsList = new HashSet<>();
        studentsList.add(new Student(1L, "Juan", new HashSet<>()));
        studentsList.add(new Student(2L, "Pedro", new HashSet<>()));

        Mockito.when(studentRepository.findAll()).thenReturn(studentsList);

        Set<StudentDTO> result = studentService.getAll();
        var resultSize = result.size();

        Assertions.assertEquals(expected, resultSize,"Los tamaños de las listas no coinciden");
    }

    @Test
    @DisplayName("could not find any student")
    public void getAllTestSadPath(){

        Mockito.when(studentRepository.findAll()).thenReturn(new HashSet<>());

        Set<StudentDTO> result = studentService.getAll();
        var resultSize = result.size();

        Assertions.assertEquals(0, resultSize,"Los tamaños de las listas no coinciden");
    }
}
