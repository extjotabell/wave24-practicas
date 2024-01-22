package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.dto.StudentDTO;
import com.meli.obtenerdiploma.dto.SubjectDTO;
import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
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

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private IStudentRepository studentRepository;
    @InjectMocks
    private StudentService studentService;
    private final StudentDTO updateStudentDTO =
            new StudentDTO(
                    1L,
                    "Enzo",
                    new HashSet<>(List.of(
                            new SubjectDTO("Matemática", 10.0),
                            new SubjectDTO("Física", 10.0),
                            new SubjectDTO("Química", 10.0)
                    ))
            );
    private final Student updateStudent =
            new Student(
                    1L,
                    "Enzo",
                    new HashSet<>(List.of(
                            new Subject("Matemática", 10.0),
                            new Subject("Física", 10.0),
                            new Subject("Química", 10.0)
                    ))
            );
    private final StudentDTO newStudentDTO =
            new StudentDTO(
                    null,
                    "Enzo",
                    new HashSet<>(List.of(
                            new SubjectDTO("Matemática", 10.0),
                            new SubjectDTO("Física", 10.0),
                            new SubjectDTO("Química", 10.0)
                    ))
            );
    private final Student newStudent =
            new Student(
                    null,
                    "Enzo",
                    new HashSet<>(List.of(
                            new Subject("Matemática", 10.0),
                            new Subject("Física", 10.0),
                            new Subject("Química", 10.0)
                    ))
            );
    private final StudentDTO studentDTOId2 =
            new StudentDTO(
                    2L,
                    "Pedro",
                    new HashSet<>(List.of(
                            new SubjectDTO("Matemática", 10.0),
                            new SubjectDTO("Física", 8.0),
                            new SubjectDTO("Química", 4.0)
                    ))
            );
    private final Student studentId2 =
            new Student(
                    2L,
                    "Pedro",
                    new HashSet<>(List.of(
                            new Subject("Matemática", 10.0),
                            new Subject("Física", 8.0),
                            new Subject("Química", 4.0)
                    ))
            );
    private final StudentDTO studentDTOId1 =
            new StudentDTO(
                    1L,
                    "Juan",
                    new HashSet<>(List.of(
                            new SubjectDTO("Matemática", 9.0),
                            new SubjectDTO("Física", 7.0),
                            new SubjectDTO("Química", 6.0)
                    ))
            );
    private final Student studentId1 =
            new Student(
                    1L,
                    "Juan",
                    new HashSet<>(List.of(
                            new Subject("Matemática", 9.0),
                            new Subject("Física", 7.0),
                            new Subject("Química", 6.0)
                    ))
            );
    @Test
    @DisplayName("Test create student")
    void createTest(){
        //Act
        Mockito.when(studentRepository.save(newStudent)).thenReturn(true);
        boolean result = studentService.create(newStudentDTO);
        //Assert
        Assertions.assertTrue(result,"Student was not created");
    }
    @Test
    @DisplayName("Test read student")
    void readTest(){
        //Act
        Mockito.when(studentRepository.findById(1L)).thenReturn(Optional.of(studentId1));
        StudentDTO result = studentService.read(1L);
        //Assert
        Assertions.assertEquals(studentDTOId1,result,"Student was not read");
    }

    @Test
    @DisplayName("Test update student")
    void updateTest(){
        //Act
        Mockito.when(studentRepository.save(newStudent)).thenReturn(true);
        boolean result = studentService.update(newStudentDTO);
        //Assert
        Assertions.assertTrue(result,"Student was not updated");
    }

    @Test
    @DisplayName("Test delete student")
    void deleteTest(){
        //Act
        Mockito.when(studentRepository.delete(1L)).thenReturn(true);
        boolean result = studentService.delete(1L);
        //Assert
        Assertions.assertTrue(result,"Student was not deleted");
    }

    @Test
    @DisplayName("Test get all students")
    void getAllTest(){
        //Arrange
        Set<StudentDTO> expectedList = new HashSet<>(List.of(studentDTOId1, studentDTOId2));
        Set<Student> studentList = new HashSet<>(List.of(studentId1, studentId2));
        //Act
        Mockito.when(studentRepository.findAll()).thenReturn(studentList);
        Set<StudentDTO> result = studentService.getAll();
        //Assert
        Assertions.assertEquals(expectedList,result,"Students were not read");
    }
}
