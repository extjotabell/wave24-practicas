package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.dto.StudentDTO;
import com.meli.obtenerdiploma.dto.SubjectDTO;
import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    public void createStudent() {

        Set<SubjectDTO> subjects = Set.of(
                new SubjectDTO("Matemática", 10D),
                new SubjectDTO("Lengua", 8D),
                new SubjectDTO("Historia", 9D),
                new SubjectDTO("Geografía", 7D),
                new SubjectDTO("Física", 6D)
        );

        StudentDTO studentDTO = new StudentDTO(1L, "Juan", subjects);

        when(studentRepository.save(any(Student.class))).thenReturn(true);

        boolean createdStudent = studentService.create(studentDTO);

        Assertions.assertTrue(createdStudent);


    }


    @Test
    public void readStudent() {
        Set<SubjectDTO> subjects = Set.of(
                new SubjectDTO("Matemática", 0D),
                new SubjectDTO("Lengua", 0D),
                new SubjectDTO("Historia", 0D),
                new SubjectDTO("Geografía", 0D),
                new SubjectDTO("Física", 0D)
        );

        StudentDTO studentDTO = new StudentDTO(1L, "Juan", subjects);

        Optional<Student> studentReturn = Optional.of(new Student(1L, "Juan", subjects.stream().map(
                s -> new Subject(s.name(), s.score())
        ).collect(Collectors.toSet())));

        when(studentRepository.findById(any(Long.class))).thenReturn(studentReturn);

        StudentDTO readStudent = studentService.read(1L);

        Assertions.assertEquals(studentDTO, readStudent);
    }

    @Test
    public void updateStudent() {

        Set<SubjectDTO> subjects = Set.of(
                new SubjectDTO("Matemática", 10D),
                new SubjectDTO("Lengua", 8D),
                new SubjectDTO("Historia", 9D),
                new SubjectDTO("Geografía", 7D),
                new SubjectDTO("Física", 6D)
        );

        StudentDTO studentDTO = new StudentDTO(1L, "Juan", subjects);

        when(studentRepository.save(any(Student.class))).thenReturn(true);

        boolean updatedStudent = studentService.update(studentDTO);

        Assertions.assertTrue(updatedStudent);

    }

    @Test
    public void deleteStudent() {

        when(studentRepository.delete(any(Long.class))).thenReturn(true);

        boolean deletedStudent = studentService.delete(1L);

        Assertions.assertTrue(deletedStudent);

    }

    @Test
    public void getAllStudents() {

        Set<SubjectDTO> subjects = Set.of(
                new SubjectDTO("Matemática", 10D),
                new SubjectDTO("Lengua", 8D),
                new SubjectDTO("Historia", 9D),
                new SubjectDTO("Geografía", 7D),
                new SubjectDTO("Física", 6D)
        );

        Set<StudentDTO> studentsDTO = Set.of(
                new StudentDTO(1L, "Juan", subjects),
                new StudentDTO(2L, "Pedro", subjects),
                new StudentDTO(3L, "Pablo", subjects)
        );

        Set<Student> students = studentsDTO.stream().map(
                s -> new Student(s.id(), s.studentName(), s.subjects().stream().map(
                        subject -> new Subject(subject.name(), subject.score())
                ).collect(Collectors.toSet()))
        ).collect(Collectors.toSet());

        when(studentRepository.findAll()).thenReturn(students);

        Set<StudentDTO> allStudents = studentService.getAll();

        Assertions.assertEquals(studentsDTO, allStudents);

    }

}
