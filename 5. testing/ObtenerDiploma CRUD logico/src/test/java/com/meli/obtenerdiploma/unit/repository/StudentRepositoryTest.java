package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class StudentRepositoryTest {

    private final IStudentRepository studentRepository = new StudentRepository();

    private final List<Subject> subjects = List.of(
            new Subject("Matemática", 9D),
            new Subject("Física", 7D),
            new Subject("Química", 6D),
            new Subject("Matemática", 10D),
            new Subject("Física", 8D),
            new Subject("Química", 4D));
    private final List<Student> students = List.of(
            new Student(1L, "Juan", subjects.subList(0, 3)),
            new Student(2L, "Pedro", subjects.subList(3, 6))
    );

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Find all students")
    void findAll() {
        List<Student> result = studentRepository.findAll();
        Assertions.assertEquals(students, result);
    }

    @Test
    @DisplayName("Save a new student")
    void save() {
        Student newStudent = new Student(3L, "Imanol", new ArrayList<>(subjects.subList(0, 3)));
        boolean result = studentRepository.save(newStudent);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Save a new student with an existing id")
    void saveException() {
        Student newStudent = new Student(1L, "Imanol", new ArrayList<>(subjects.subList(0, 3)));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                studentRepository.save(newStudent)
        );
    }

    @Test
    @DisplayName("Delete a student")
    void deleteTrue() {
        Assertions.assertTrue(studentRepository.delete(1L));
    }

    @Test
    @DisplayName("Delete a student with an invalid id")
    void deleteStudentNotFoundException() {
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentRepository.delete(3L));
    }

    @Test
    @DisplayName("Delete a student with a null id")
    void deleteThrow() {
        Assertions.assertThrows(Exception.class, () -> studentRepository.delete(null));
    }

    @Test
    @DisplayName("Exists a student")
    void existsTrue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = studentRepository.getClass().getDeclaredMethod("exists", Student.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(studentRepository, new Student(1L, "Juan", new ArrayList<>(subjects.subList(0, 3))));
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Exists a student")
    void existsFalse() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = studentRepository.getClass().getDeclaredMethod("exists", Student.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(studentRepository, new Student(3L, "Imanol", new ArrayList<>(subjects.subList(0, 3))));
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Find a student by id")
    void findById() {
        Student result = studentRepository.findById(1L).orElseThrow();
        Assertions.assertEquals(students.stream().findFirst().orElseThrow(), result);
    }

    @Test
    @DisplayName("Find a student by id with an invalid id")
    void findByIdStudentNotFoundException() {
        Assertions.assertThrows(StudentNotFoundException.class,
                () -> studentRepository.findById(99L).orElseThrow(
                        () -> new StudentNotFoundException(99L)));
    }

    @Test
    @DisplayName("Find a student by id with a null id")
    void findByIdNullPointerException() {
        Assertions.assertThrows(Exception.class,
                () -> studentRepository.findById(null).get());
    }
}