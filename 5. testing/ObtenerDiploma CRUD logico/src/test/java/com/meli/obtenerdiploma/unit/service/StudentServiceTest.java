package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.dto.StudentDTO;
import com.meli.obtenerdiploma.dto.SubjectDTO;
import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService service;

    private final List<Subject> subjects = List.of(
            new Subject("Matemática", 9D),
            new Subject("Física", 7D),
            new Subject("Química", 6D),
            new Subject("Matemática", 10D),
            new Subject("Física", 8D),
            new Subject("Química", 4D));
    private final List<Student> students = List.of(
            new Student(1L, "Juan", new ArrayList<>(subjects.subList(0, 3))),
            new Student(2L, "Pedro", new ArrayList<>(subjects.subList(3, 6)))
    );


    private final List<SubjectDTO> subjectsDTO = new ArrayList<>(subjects).stream().map(
            s -> new SubjectDTO(
                    s.getName(),
                    s.getScore()
            )
    ).collect(Collectors.toList());
    private final List<StudentDTO> studentsDTO = List.of(
            new StudentDTO(1L, "Juan", new ArrayList<>(subjectsDTO.subList(0, 3))),
            new StudentDTO(2L, "Pedro", new ArrayList<>(subjectsDTO.subList(3, 6)))
    );


    @BeforeEach
    void setUp() {
    }

    @Test
    void create() {
        Mockito.when(studentRepository.save(Mockito.any(Student.class))).thenReturn(true);
        assertTrue(service.create(studentsDTO.iterator().next()));
    }

    @Test
    void read() {
        StudentDTO expect = studentsDTO.iterator().next();
        Mockito.when(studentRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(students.iterator().next()));
        StudentDTO actual = service.read(expect.id());
        assertEquals(expect, actual);
    }

    @Test
    void update() {
        StudentDTO studentDTO = studentsDTO.iterator().next();
        Mockito.when(studentRepository.update(Mockito.any(Student.class))).thenReturn(true);
        assertTrue(service.update(studentDTO));
    }

    @Test
    void delete() {
        Mockito.when(studentRepository.delete(Mockito.anyLong())).thenReturn(true);
        assertTrue(service.delete(1L));
    }

    @Test
    void getAll() {
        Mockito.when(studentRepository.findAll()).thenReturn(students);
        List<StudentDTO> actual = service.getAll();
        assertEquals(studentsDTO, actual);
    }
}