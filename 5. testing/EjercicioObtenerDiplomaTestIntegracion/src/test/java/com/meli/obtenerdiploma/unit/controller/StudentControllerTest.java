package com.meli.obtenerdiploma.unit.controller;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.dto.StudentDTO;
import com.meli.obtenerdiploma.dto.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
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
public class StudentControllerTest {

    @Mock private IStudentService studentService;
    @InjectMocks private StudentController studentController;

    @Test
    @DisplayName("Test that register student correctly")
    public void registerStudentTest() {
        //arrange
        Long id = 2L;
        String name = "Pedro";
        Set<SubjectDTO> subjectDTO = Set.of(
                new SubjectDTO("Matemática", 10.0)
        );
        StudentDTO studentDTO = new StudentDTO(id, name, subjectDTO);
        ResponseEntity<?> expected = ResponseEntity.noContent().build();

        //act
        Mockito.when(studentService.create(studentDTO)).thenReturn(true);
        ResponseEntity<?> result = studentController.registerStudent(studentDTO);

        //assert
        Assertions.assertEquals(expected, result, "The object not registered correctly");
    }

    @Test
    @DisplayName("Test that register student not correctly")
    public void registerStudentExceptionTest() {
        //arrange
        Long id = 2L;
        String name = "Pedro";
        Set<SubjectDTO> subjectDTO = Set.of(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0)
        );
        StudentDTO studentDTO = new StudentDTO(id, name, subjectDTO);
        ResponseEntity<?> expected = ResponseEntity.badRequest().build();

        //act
        Mockito.when(studentService.create(studentDTO)).thenReturn(false);
        ResponseEntity<?> result = studentController.registerStudent(studentDTO);

        //assert
        Assertions.assertEquals(expected, result, "The object registered correctly");
    }

    @Test
    @DisplayName("Test that get student correctly")
    public void getStudentTest() {
        //arrange
        Long idParam = 2L;
        String name = "Pedro";
        Set<SubjectDTO> subjectDTO = Set.of(
                new SubjectDTO("Matemática", 10.0)
        );
        StudentDTO studentDTO = new StudentDTO(idParam, name, subjectDTO);
        ResponseEntity<StudentDTO> expected = ResponseEntity.ok(studentDTO);

        //act
        Mockito.when(studentService.read(idParam)).thenReturn(studentDTO);
        ResponseEntity<?> result = studentController.getStudent(idParam);

        //assert
        Assertions.assertEquals(expected, result, "The object not found");
    }

    @Test
    @DisplayName("Test that modify student correctly")
    public void modifyStudentTest() {
        //arrange
        Long idParam = 2L;
        String name = "Pedro";
        Set<SubjectDTO> subjectDTO = Set.of(
                new SubjectDTO("Matemática", 10.0)
        );
        StudentDTO studentDTO = new StudentDTO(idParam, name, subjectDTO);
        ResponseEntity<?> expected = ResponseEntity.noContent().build();

        //act
        Mockito.when(studentService.update(studentDTO)).thenReturn(true);
        ResponseEntity<?> result = studentController.modifyStudent(studentDTO);

        //assert
        Assertions.assertEquals(expected, result, "The object not modified correctly");
    }

    @Test
    @DisplayName("Test that modify student not correctly")
    public void modifyStudentExceptionTest() {
        //arrange
        Long idParam = 2L;
        String name = "Pedro";
        Set<SubjectDTO> subjectDTO = Set.of(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0)
        );
        StudentDTO studentDTO = new StudentDTO(idParam, name, subjectDTO);
        ResponseEntity<?> expected = ResponseEntity.badRequest().build();

        //act
        Mockito.when(studentService.update(studentDTO)).thenReturn(false);
        ResponseEntity<?> result = studentController.modifyStudent(studentDTO);

        //assert
        Assertions.assertEquals(expected, result, "The object modified correctly");
    }

    @Test
    @DisplayName("Test that remove student correctly")
    public void removeStudentTest() {

        //arrange
        Long idParam = 2L;
        ResponseEntity<StudentDTO> expected = ResponseEntity.noContent().build();

        //act
        Mockito.when(studentService.delete(idParam)).thenReturn(true);
        ResponseEntity<?> result = studentController.removeStudent(idParam);

        //assert
        Assertions.assertEquals(expected, result, "The object not removed correctly");
    }

    @Test
    @DisplayName("Test that remove student not correctly")
    public void removeStudentExceptionTest() {

        //arrange
        Long idParam = 2L;
        ResponseEntity<StudentDTO> expected = ResponseEntity.badRequest().build();

        //act
        Mockito.when(studentService.delete(idParam)).thenReturn(false);
        ResponseEntity<?> result = studentController.removeStudent(idParam);

        //assert
        Assertions.assertEquals(expected, result, "The object removed correctly");
    }

    @Test
    @DisplayName("Test that find all student correctly")
    public void listStudentTest() {

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
        Set<StudentDTO> listExpectedToServiceDTO = Set.of(
                studentDTO1,
                studentDTO2
        );

        //act
        Mockito.when(studentService.getAll()).thenReturn(listExpectedToServiceDTO);
        Set<StudentDTO> result = studentController.listStudents();

        //assert
        Assertions.assertEquals(listExpectedToServiceDTO, result, "The list of students not found");
    }
}
