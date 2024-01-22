package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class StudentRepositoryTest {

    private StudentRepository studentRepository;
    private Set<Student> students;

    @BeforeEach
    public void setUp() {
        students = new HashSet<>();
        students.add(new Student(1L, "Juan", null));
        students.add(new Student(2L, "Pedro", null));
        studentRepository = new StudentRepository(students);
    }

    @Test
    public void testSaveStudent() {
        Student newStudent = new Student(3L, "New Student", null);
        assertTrue(studentRepository.save(newStudent));
        assertEquals(3, studentRepository.findAll().size());
    }

    @Test
    public void testFindStudentById() {
        Student student = studentRepository.findById(1L).orElse(null);
        assertNotNull(student);
        assertEquals("Juan", student.getStudentName());

        assertFalse(studentRepository.findById(3L).isPresent());
    }

    @Test
    public void testDeleteStudent() {
        assertTrue(studentRepository.delete(1L));
        assertEquals(1, studentRepository.findAll().size());
        assertThrows(StudentNotFoundException.class, () -> studentRepository.delete(3L));
    }
    @Test
    public void testFindAllStudents() {
        Set<Student> students = studentRepository.findAll();
        assertEquals(2, students.size());
    }

}
