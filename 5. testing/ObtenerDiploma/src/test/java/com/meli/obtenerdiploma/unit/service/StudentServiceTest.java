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

import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private IStudentRepository studentRepository;
    @InjectMocks
    private StudentService studentService;

    @Test
    @DisplayName("Test validates that student is create correctly")
    public void createTest(){
        //Arrange
        Long id = 2L;
        String name = "Pedro";
        Set<Subject> subjects = Set.of(
                new Subject("Matematicas", 10.0)
        );
        Student expected = new Student(id, name, subjects);
        boolean expectedResult = true;

        //Act
        Mockito.when(studentRepository.save(expected)).thenReturn(true);
        boolean result = studentService.create(
                new StudentDTO(
                        id,
                        name,
                        Set.of(new SubjectDTO(
                                "Matematicas",
                                10.0)
        )));

        //Assert
        Assertions.assertEquals(expectedResult, result, "The object not created correctly");
    }
}
