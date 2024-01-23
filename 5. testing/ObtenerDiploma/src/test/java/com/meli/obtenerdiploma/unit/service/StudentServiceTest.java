package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.dto.StudentDTO;
import com.meli.obtenerdiploma.dto.SubjectDTO;
import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    // Pedro Data for testing. First student, always charged.
    Subject pedroMath = new Subject("Matemática", 10.0);
    Subject pedroPhysics = new Subject("Física", 8.0);
    Subject pedroChemistry = new Subject("Química", 4.0);
    Set<Subject> pedroSubjects = new HashSet<>() {
        {
            add(pedroMath);
            add(pedroPhysics);
            add(pedroChemistry);
        }
    };
    Student pedroId1 = new Student(
            1L,
            "Pedro",
            pedroSubjects
    );
    // Juan Data for testing. Second student, It can be used to save.
    Subject JuanMath = new Subject("Matemática", 9.0);
    Subject JuanPhysics = new Subject("Física", 7.0);
    Subject JuanChemistry = new Subject("Química", 6.0);
    Set<Subject> juanSubjects = new HashSet<>() {
        {
            add(JuanMath);
            add(JuanPhysics);
            add(JuanChemistry);
        }
    };

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("Student Service: Save Student Correctly")
    void saveStudentCorrectly() {
        // Arrange
        Student studentToSave = new Student(
                2L,
                "Juan",
                juanSubjects
        );
        Boolean expectedResult = true;

        // Act
        Mockito
                .when(studentRepository.save(studentToSave))
                .thenReturn(true);

        var result = studentService.create(new StudentDTO(
                2L,
                "Juan",
                juanSubjects
                        .stream()
                        .map(subject -> new SubjectDTO(
                                subject.getName(),
                                subject.getScore()
                        ))
                        .collect(Collectors.toSet())
        ));

        // Assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Student Service: Save Student with Duplicated Id")
    void saveStudentWithDuplicatedId() {
        // Arrange
        Student studentToSave = new Student(
                1L,
                "Pedro",
                pedroSubjects
        );
        Boolean expectedResult = false;

        // Act
        Mockito
              .when(studentRepository.save(studentToSave))
              .thenReturn(false);

        var result = studentService.create(new StudentDTO(
                1L,
                "Pedro",
                pedroSubjects
                      .stream()
                      .map(subject -> new SubjectDTO(
                                subject.getName(),
                                subject.getScore()
                        ))
                      .collect(Collectors.toSet())
        ));

        // Assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Student Service: Save Student with Invalid Data.")
    void saveStudentWithInvalidData() {
        // Arrange
        Student studentToSave = new Student(
                2L,
                "",
                new HashSet<>()
        );
        Boolean expectedResult = false;

        // Act
        Mockito
             .when(studentRepository.save(studentToSave))
             .thenReturn(false);

        var result = studentService.create(new StudentDTO(
                2L,
                "",
                new HashSet<>()
        ));

        // Assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Student Service: Read Student Correctly")
    void readStudentCorrectly() {
        // Arrange
        Long idParam = 1L;
        Student expectedStudent = new Student(
                idParam,
                "Pedro",
                pedroSubjects
        );
        StudentDTO expectedResult = new StudentDTO(
                idParam,
                "Pedro",
                pedroSubjects
                        .stream()
                        .map(subject -> new SubjectDTO(
                                subject.getName(),
                                subject.getScore()
                        ))
                        .collect(Collectors.toSet())
        );

        // Act
        Mockito
              .when(studentRepository.findById(idParam))
              .thenReturn(Optional.of(expectedStudent));

        var result = studentService.read(idParam);

        // Assert
        Assertions.assertEquals(expectedResult.studentName(), result.studentName());
    }

    @Test
    @DisplayName("Student Service: Read Student with Non Existing Id.")
    void readStudentWithNonExistingId() {
        // Arrange
        Long idParam = 2L;

        // Act
        Mockito
            .when(studentRepository.findById(idParam))
            .thenReturn(Optional.empty());

        // Assert
        Assertions.assertThrows(
                StudentNotFoundException.class,
                () -> studentService.read(idParam)
        );
    }

    @Test
    @DisplayName("Student Service: Update Student Correctly")
    void updateStudentCorrectly() {
        // Arrange
        Student studentToUpdate = new Student(
                1L,
                "Juan",
                juanSubjects
        );
        Boolean expectedResult = true;

        // Act
        Mockito
            .when(studentRepository.update(studentToUpdate))
            .thenReturn(true);

        var result = studentService.update(new StudentDTO(
                1L,
                "Juan",
                juanSubjects
                        .stream()
                        .map(subject -> new SubjectDTO(
                                subject.getName(),
                                subject.getScore()
                        ))
                        .collect(Collectors.toSet())
        ));

        // Assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Student Service: Update Student with Non Existing Id.")
    void updateStudentWithNonExistingId() {
        // Arrange
        Student studentToUpdate = new Student(
                2L,
                "Juan",
                juanSubjects
        );
        Boolean expectedResult = false;

        // Act
        Mockito
          .when(studentRepository.update(studentToUpdate))
          .thenReturn(false);

        var result = studentService.update(new StudentDTO(
                2L,
                "Juan",
                juanSubjects
                      .stream()
                      .map(subject -> new SubjectDTO(
                                subject.getName(),
                                subject.getScore()
                        ))
                      .collect(Collectors.toSet())
        ));

        // Assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Student Service: Delete Student Correctly")
    void deleteStudentCorrectly() {
        // Arrange
        Long idParam = 1L;
        Boolean expectedResult = true;

        // Act
        Mockito
            .when(studentRepository.delete(idParam))
            .thenReturn(true);

        var result = studentService.delete(idParam);

        // Assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Student Service: Delete Student with Non Existing Id.")
    void deleteStudentWithNonExistingId() {
        // Arrange
        Long idParam = 2L;
        Boolean expectedResult = false;

        // Act
        Mockito
         .when(studentRepository.delete(idParam))
         .thenReturn(false);

        var result = studentService.delete(idParam);

        // Assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Student Service: Get All Students Correctly")
    void getAllStudentsCorrectly() {
        // Arrange
        Set<Student> expectedResult = new HashSet<>() {
            {
                add(pedroId1);
            }
        };

        // Act
        Mockito
           .when(studentRepository.findAll())
           .thenReturn(expectedResult);

        var result = studentService.getAll();

        // Assert
        Assertions.assertEquals(expectedResult.size(), result.size());
    }
}
