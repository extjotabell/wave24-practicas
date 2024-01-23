package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class StudentRepositoryTest {

    IStudentRepository studentRepository = new StudentRepository();
    @BeforeEach
    public void setUp(){
        Set<Student> testStudents = new HashSet<>();

        Set<Subject> subjects1 = new HashSet<>();
        subjects1.add(new Subject("Matemática", 9.0));
        subjects1.add(new Subject("Física", 7.0));
        subjects1.add(new Subject("Química", 6.0));

        testStudents.add(new Student(1L, "Juan", subjects1));

        Set<Subject> subjects2 = new HashSet<>();
        subjects1.add(new Subject("Matemática", 10.0));
        subjects1.add(new Subject("Física", 8.0));
        subjects1.add(new Subject("Química", 4.0));

        testStudents.add(new Student(2L, "Pedro", subjects2));

        studentRepository = new StudentRepository(testStudents);
    }

    @Test
    public void findAllTest(){
        int expected = 2;

        var result = studentRepository.findAll();

        Assertions.assertEquals(expected, result.size(), "Las listas difieren");
    }

    @Test
    public void saveTest(){
        Set<Subject> subject = new HashSet<>();
        subject.add(new Subject("Lengua", 7.0));
        subject.add(new Subject("Cs Naturales", 9.0));
        Student student = new Student(null,"Marcos", subject);

        boolean expected = true;
        var result = studentRepository.save(student);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void saveExistingStudentTest(){
        Set<Subject> subject = new HashSet<>();
        subject.add(new Subject("Matemática", 9.0));
        subject.add(new Subject("Física", 7.0));
        subject.add(new Subject("Química", 6.0));
        Student existingStudent = new Student(1L, "Juan", subject);

        boolean result = studentRepository.save(existingStudent);
        Assertions.assertFalse(result);
    }

    @Test
    public void saveInvalidStudent(){
        Set<Subject> subject = new HashSet<>();
        subject.add(new Subject("Matemática", 9.0));
        subject.add(new Subject("Física", 7.0));
        subject.add(new Subject("Química", 6.0));
        Student invalidStudent = new Student(null, null, subject);

        boolean result = studentRepository.save(invalidStudent);
        Assertions.assertFalse(result);
    }

    @Test
    public void findByIdExistsTest(){
        Long id = 1L;

        Optional<Student> result = studentRepository.findById(id);

        Assertions.assertEquals(id, result.get().getId());
    }

    @Test
    public void findByIdNotExistsTest(){
        Long id = 3L;

        Assertions.assertThrows(StudentNotFoundException.class,
                () -> studentRepository.findById(id)
                        .orElseThrow(() -> new StudentNotFoundException(id)));
    }

    @Test
    public void deleteStudentTest(){
        Long deleteId = 1L;
        var result = studentRepository.delete(deleteId);

        Assertions.assertTrue(result);
        Assertions.assertTrue(studentRepository.findAll()
                .stream()
                .noneMatch(student -> student.getId().equals(deleteId)));
    }

    @Test
    public void deleteStudentNotExistTest(){
        Long deleteId = 3L;

        Assertions.assertThrows(StudentNotFoundException.class,
                () -> studentRepository.delete(deleteId));

        var expected = 2;
        var result = studentRepository.findAll().size();
        Assertions.assertEquals(expected,result);
    }

}
