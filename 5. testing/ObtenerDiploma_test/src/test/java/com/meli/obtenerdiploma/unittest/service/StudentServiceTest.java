package com.meli.obtenerdiploma.unittest.service;

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
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("create: should return true when created")
    public void create(){
        Student student = new Student(2L,
                "Pedro",
                Set.of(
                        new Subject("Física", 8.0),
                        new Subject("Química", 4.0),
                        new Subject("Matemática", 10.0)
                ));
        StudentDTO studentDTO = new StudentDTO(2L,
                "Pedro",
                Set.of(
                        new SubjectDTO("Física", 8.0),
                        new SubjectDTO("Química", 4.0),
                        new SubjectDTO("Matemática", 10.0)
                ));

        Mockito.when(studentRepository.save(student)).thenReturn(true);
        var result = studentService.create(studentDTO);

        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("read: should return StudentDTO when read an id")
    public void read(){
        Long id = 2L;
        Student student = new Student(2L,
                "Pedro",
                Set.of(
                new Subject("Física", 8.0),
                new Subject("Química", 4.0),
                new Subject("Matemática", 10.0)
                ));
        StudentDTO studentDTO = new StudentDTO(2L,
                "Pedro",
                Set.of(
                        new SubjectDTO("Matemática", 0.0),
                        new SubjectDTO("Física", 0.0),
                        new SubjectDTO("Química", 0.0)
                ));
        Mockito.when(studentRepository.findById(id)).thenReturn(Optional.of(student));
        var result = studentService.read(id);
        Assertions.assertEquals(studentDTO, result);
    }

    @Test
    @DisplayName("read: should return StudentNotFoundException when id nonexistent")
    public void notRead(){
        Long id = 3L;
        Assertions.assertThrows(StudentNotFoundException.class, ()->{
            studentService.read(id);
        });
    }

    @Test
    @DisplayName("update: should return true when update StudentDTO")
    public void update(){
        Student student = new Student(2L,
                "Pedro",
                Set.of(
                        new Subject("Física", 8.0),
                        new Subject("Química", 4.0),
                        new Subject("Matemática", 10.0)
                ));
        StudentDTO studentDTO = new StudentDTO(2L,
                "Pedro",
                Set.of(
                        new SubjectDTO("Física", 8.0),
                        new SubjectDTO("Química", 4.0),
                        new SubjectDTO("Matemática", 10.0)
                ));
        Mockito.when(studentRepository.save(student)).thenReturn(true);
        var result = studentService.update(studentDTO);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("delete: should return true when deleted a student by id")
    public void delete(){
        Long id = 1L;
        Mockito.when(studentRepository.delete(id)).thenReturn(true);
        var result = studentService.delete(id);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("getAll: should return Set<StudentDTO>")
    public void getAll(){
        Set<Student> student = Set.of(
                new Student(2L, "Pedro", Set.of(
                        new Subject("Matemática", 10.0),
                        new Subject("Física", 8.0),
                        new Subject("Química", 4.0))),
                new Student(1L, "Juan", Set.of(
                        new Subject("Matemática", 9.0),
                        new Subject("Física", 7.0),
                        new Subject("Química", 6.0)))
                );

        Set<StudentDTO> studentDTO = Set.of(
                new StudentDTO(2L, "Pedro", Set.of(
                        new SubjectDTO("Matemática", 10.0),
                        new SubjectDTO("Física", 8.0),
                        new SubjectDTO("Química", 4.0))),
                new StudentDTO(1L, "Juan", Set.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)))
        );

        Mockito.when(studentRepository.findAll()).thenReturn(student);
        var result = studentService.getAll();
        Assertions.assertEquals(studentDTO, result);
    }
}
