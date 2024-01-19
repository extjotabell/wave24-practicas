package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private final Set<Student> students = Set.of(
            new Student(1L, "Juan", new HashSet<>(subjects.subList(0, 3))),
            new Student(2L, "Pedro", new HashSet<>(subjects.subList(3, 6)))
    );

    @BeforeEach
    void setUp() {
    }

    @Test
    void findAll() {
        Set<Student> result = studentRepository.findAll();
        Assertions.assertEquals(students, result);
    }

    @Test
    void save() {
        Student newStudent = new Student(3L, "Imanol", new HashSet<>(subjects.subList(0, 3)));
        boolean result = studentRepository.save(newStudent);
        Assertions.assertTrue(result);
    }

    @Test
    void deleteTrue() {
        Assertions.assertTrue(studentRepository.delete(1L));
    }

    @Test
    void deleteThrow() {
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentRepository.delete(3L));
    }

    @Test
    void existsTrue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = studentRepository.getClass().getDeclaredMethod("exists", Student.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(studentRepository, new Student(1L, "Juan", new HashSet<>(subjects.subList(0, 3))));
        Assertions.assertTrue(result);
    }

    @Test
    void existsFalse() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = studentRepository.getClass().getDeclaredMethod("exists", Student.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(studentRepository, new Student(3L, "Imanol", new HashSet<>(subjects.subList(0, 3))));
        Assertions.assertFalse(result);
    }

    @Test
    void findById() {
        Student result = studentRepository.findById(1L).orElseThrow();
        Assertions.assertEquals(students.stream().findFirst().orElseThrow(), result);
    }
}