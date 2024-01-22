package com.meli.obtenerdiploma.unit.controller;

import com.meli.obtenerdiploma.controller.StudentController;
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
import java.util.List;
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
    void registerStudent() {
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", new ArrayList<>(subjectsDTO.subList(0, 3)));
        Mockito.when(service.create(studentDTO)).thenReturn(true);
        assertNull(controller.registerStudent(studentDTO).getBody());
    }

    @Test
    void getStudent() {
        Mockito.when(service.read(1L)).thenReturn(studentsDTO.iterator().next());
        assertEquals(studentsDTO.iterator().next(), controller.getStudent(1L).getBody());
    }

    @Test
    void modifyStudent() {
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", new ArrayList<>(subjectsDTO.subList(0, 3)));
        Mockito.when(service.update(studentDTO)).thenReturn(true);
        assertNull(controller.modifyStudent(studentDTO).getBody());
    }

    @Test
    void removeStudent() {
        Mockito.when(service.delete(1L)).thenReturn(true);
        assertNull(controller.removeStudent(1L).getBody());
    }

    @Test
    void listStudents() {
        Mockito.when(service.getAll()).thenReturn(studentsDTO);
        assertEquals(studentsDTO, controller.listStudents());
    }
}