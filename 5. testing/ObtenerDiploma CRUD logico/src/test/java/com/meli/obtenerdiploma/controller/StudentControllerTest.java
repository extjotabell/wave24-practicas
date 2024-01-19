package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.dto.StudentDTO;
import com.meli.obtenerdiploma.dto.SubjectDTO;
import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    private StudentService service;
    @InjectMocks
    private StudentController controller;

    private final List<Subject> subjects = List.of(
            new Subject("Matemática", 9D),
            new Subject("Física", 7D),
            new Subject("Química", 6D),
            new Subject("Matemática", 10D),
            new Subject("Física", 8D),
            new Subject("Química", 4D));
    private final Set<Student> students = Set.of(
            new Student(1L, "Juan", new HashSet<>(subjects.subList(0, 3))),
            new Student(2L, "Pedro", new HashSet<>(subjects.subList(3, 6)))
    );


    private final List<SubjectDTO> subjectsDTO = new ArrayList<>(subjects).stream().map(
            s -> new SubjectDTO(
                    s.getName(),
                    s.getScore()
            )
    ).collect(Collectors.toList());
    private final Set<StudentDTO> studentsDTO = Set.of(
            new StudentDTO(1L, "Juan", new HashSet<>(subjectsDTO.subList(0, 3))),
            new StudentDTO(2L, "Pedro", new HashSet<>(subjectsDTO.subList(3, 6)))
    );

    @BeforeEach
    void setUp() {
    }

    @Test
    void registerStudent() {
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", new HashSet<>(subjectsDTO.subList(0, 3)));
        Mockito.when(service.create(studentDTO)).thenReturn(true);
        assertNull(controller.registerStudent(studentDTO).getBody());
    }

    @Test
    void getStudent() {
    }

    @Test
    void modifyStudent() {
    }

    @Test
    void removeStudent() {
    }

    @Test
    void listStudents() {
    }
}