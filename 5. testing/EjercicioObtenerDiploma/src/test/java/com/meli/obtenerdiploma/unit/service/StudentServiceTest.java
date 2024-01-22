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

import java.util.Optional;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    private IStudentRepository studentRepository;
    @InjectMocks
    private StudentService studentService;

    @Test
    @DisplayName("Test that create student correctly")
    public void createTest() {
        //arrange
        Long id = 2L;
        String name = "Pedro";
        Set<Subject> subjects = Set.of(
                new Subject("Matemática", 10.0)
        );
        Set<SubjectDTO> subjectDTO = Set.of(
                new SubjectDTO("Matemática", 10.0)
        );
        Student expected = new Student(id, name, subjects);
        boolean expectedResult = true;

        //act
        Mockito.when(studentRepository.save(expected)).thenReturn(expectedResult);
        boolean result = studentService.create(new StudentDTO(id, name, subjectDTO));

        //assert
        Assertions.assertEquals(expectedResult, result, "The object not created correctly");
    }

    @Test
    @DisplayName("Test that read student correctly")
    public void readTest() {
        //arrange
        Long id = 2L;
        String name = "Pedro";
        Set<Subject> subjects = Set.of(
                new Subject("Matemática", 10.0)
        );
        Set<SubjectDTO> subjectDTO = Set.of(
                new SubjectDTO("Matemática", 0.0)
        );
        StudentDTO expectedDTO = new StudentDTO(id, name, subjectDTO);
        Student expectedToRepository = new Student(id, name, subjects);

        //act
        Mockito.when(studentRepository.findById(id)).thenReturn(Optional.of(expectedToRepository));
        StudentDTO result = studentService.read(id);

        //assert
        Assertions.assertEquals(expectedDTO, result, "The object not found");
    }

    @Test
    @DisplayName("Test that read student not correctly")
    public void readExceptionTest() {

        //arrange
        Long id = 3L;

        //act
        Mockito.when(studentRepository.findById(id)).thenReturn(Optional.empty());

        //assert
        Assertions.assertThrows(
                StudentNotFoundException.class,
                ()->studentService.read(id)
        );
    }

    @Test
    @DisplayName("Test that update student correctly")
    public void updateTest() {

        //arrange
        Long id = 2L;
        String name = "Pedro";
        Set<Subject> subjects = Set.of(
                new Subject("Matemática", 7.0)
        );
        Set<SubjectDTO> subjectDTO = Set.of(
                new SubjectDTO("Matemática", 7.0)
        );
        Student expected = new Student(id, name, subjects);
        boolean expectedResult = true;

        //act
        Mockito.when(studentRepository.save(expected)).thenReturn(expectedResult);
        boolean result = studentService.update(new StudentDTO(id, name, subjectDTO));

        //assert
        Assertions.assertEquals(expectedResult, result, "The object not updated correctly");
    }

    @Test
    @DisplayName("Test that delete student correctly")
    public void deleteTest() {

        //arrange
        Long idParam = 2L;
        boolean expectedResult = true;

        //act
        Mockito.when(studentRepository.delete(idParam)).thenReturn(expectedResult);
        boolean result = studentService.delete(idParam);

        //assert
        Assertions.assertEquals(expectedResult, result, "The object not deleted correctly");
    }

    @Test
    @DisplayName("Test that get all student correctly")
    public void getAllTest() {

        //arrange
        Set<SubjectDTO> subjectStudent1DTO = Set.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        );
        Set<SubjectDTO> subjectStudent2DTO = Set.of(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0)
        );
        StudentDTO studentDTO1 = new StudentDTO(1L, "Juan", subjectStudent1DTO);
        StudentDTO studentDTO2 = new StudentDTO(2L, "Pedro", subjectStudent2DTO);
        Set<StudentDTO> listExpected = Set.of(
            studentDTO1,
            studentDTO2
        );

        Set<Student> listExpectedToRepository = Set.of(
            new Student(1L, "Juan", Set.of(
                new Subject("Matemática", 9.0),
                new Subject("Física", 7.0),
                new Subject("Química", 6.0)
            )),
            new Student(2L, "Pedro", Set.of(
                new Subject("Matemática", 10.0),
                new Subject("Física", 8.0),
                new Subject("Química", 4.0)
            ))
        );

        //act
        Mockito.when(studentRepository.findAll()).thenReturn(listExpectedToRepository);
        Set<StudentDTO> result = studentService.getAll();

        //assert
        Assertions.assertEquals(listExpected, result, "The list of student not found");
    }
}
