package com.meli.obtenerdiploma.repository;


import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@TestPropertySource(locations = "classpath:application.properties")
@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testFindAllOk() {
        Set<StudentDTO> expectedStudents = new HashSet<>();

        SubjectDTO matematica = new SubjectDTO("Matemática", 9D);
        SubjectDTO fisica = new SubjectDTO("Física", 7D);
        SubjectDTO quimica = new SubjectDTO("Química", 6D);
        List<SubjectDTO> subjects = List.of(matematica, fisica, quimica);

        expectedStudents.add(new StudentDTO(1L, "Juan", null, null, subjects));
        expectedStudents.add(new StudentDTO(2L, "Pedro", null, null, subjects));

        Set<StudentDTO> foundStudents = studentRepository.findAll();

        Assertions.assertEquals(expectedStudents, foundStudents);
    }

    @Test
    public void testFindAllError() {
        studentRepository = new StudentRepository();

        Set<StudentDTO> expectedStudents = new HashSet<>();
        Set<StudentDTO> foundStudents = studentRepository.findAll();

        Assertions.assertEquals(expectedStudents, foundStudents);
    }


}
