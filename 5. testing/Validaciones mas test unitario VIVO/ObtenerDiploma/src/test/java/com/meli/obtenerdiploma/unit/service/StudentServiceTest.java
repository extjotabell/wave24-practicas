package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.dto.StudentDTO;
import com.meli.obtenerdiploma.dto.SubjectDTO;
import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)

public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    public void create() {

        //arrange the data to test
        StudentDTO studentdto = new StudentDTO(1L, "Juan", Set.of(new SubjectDTO("Matematica", 7.0),
                new SubjectDTO("Lengua", 8.0),
                new SubjectDTO("Ciencias", 6.0)));

        Student studentEntity = new Student(1L, "Juan", Set.of(new Subject("Matematica", 7.0),
                new Subject("Lengua", 8.0),
                new Subject("Ciencias", 6.0)));

        //act
        Mockito.when(studentRepository.save(studentEntity)).thenReturn(Boolean.TRUE);

        var result = studentService.create(studentdto);

        //assert
        Assertions.assertTrue(result);

    }


    // es un find by Id?
    @Test
    public void readPositiveRoute(){

        //arrange

        Student expectedStudent = new Student(7L, "Juan", Set.of(new Subject("Matematica", 7.0),
                new Subject("Lengua", 8.0),
                new Subject("Ciencias", 6.0)));

        //act
        Mockito.when(studentRepository.findById(7L)).thenReturn(Optional.of(expectedStudent));

        var result = studentService.read(expectedStudent.getId());

        //Convert Student to StudentDTO
        StudentDTO expectedDTO = new StudentDTO(expectedStudent.getId(), expectedStudent.getStudentName(), expectedStudent.getSubjects().stream().map(
                subject -> new SubjectDTO(
                        subject.getName(),
                        subject.getScore()
                )).collect(Collectors.toSet())
        );

        //assert

        Assertions.assertEquals(result, expectedDTO);

    }



    @Test
    //como seria esto?
    public  void deletePositiveRoute(){
        //se prueba desde el repositorio
        //arrange

        //act

        studentRepository.delete(1L);

        Optional<Student> found = studentRepository.findById(1L);

        //assert
        Assertions.assertTrue(found.isEmpty());

    }

    @Test
    public void getAll(){

        //se hace un when con una Set que yo hago y lo comparo con una Set que me da el metodo

        //arrange
        // un Set de Student de prueba
        Set<Student> expected = Set.of(new Student(1L, "Juan", Set.of(new Subject("Matematica", 7.0),
                new Subject("Lengua", 8.0),
                new Subject("Ciencias", 6.0))));

        //convertir el Set de Student a Set de StudentDTO
        Set<StudentDTO> expectedDTO = expected.stream().map(
                student -> new StudentDTO(
                        student.getId(),
                        student.getStudentName(),
                        student.getSubjects().stream().map(
                                subject -> new SubjectDTO(
                                        subject.getName(),
                                        subject.getScore()
                                )).collect(Collectors.toSet())
                )).collect(Collectors.toSet());


        //act

        Mockito.when(studentRepository.findAll()).thenReturn(expected);

        Set<StudentDTO> result = studentService.getAll();

        //assert

        Assertions.assertEquals(result, expectedDTO);
    }
}
