package com.meli.obtenerdiploma.unit.repository;
import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.List;

public class StudentRepositoryTest {

    /*
     *   Testing without mocks
     */
    IStudentRepository studentRepository = new StudentRepository();

    //Constants
    private final Student student1 =
            new Student(
                    1L,
                    "Juan",
                    new HashSet<>(List.of(
                            new Subject("Matemática", 9.0),
                            new Subject("Física", 7.0),
                            new Subject("Química", 6.0)
                    ))
            );
    private final Student student2 =
            new Student(
                    2L,
                    "Pedro",
                    new HashSet<>(List.of(
                            new Subject("Matemática", 10.0),
                            new Subject("Física", 8.0),
                            new Subject("Química", 4.0)
                    ))
            );

    //Test to add a student to the repository
    @Test
    @DisplayName("Test to add a student to the repository")
    public void testAddStudent() {
        //Arrange
        Student student = new Student(3L, "John Doe", new HashSet<>(List.of(
                new Subject("Matemática", 10.0),
                new Subject("Física", 8.0),
                new Subject("Química", 4.0))));

        //Act
        Boolean result = studentRepository.save(student);

        //Assert
        Assertions.assertTrue(result, "Student was not created");
    }

    //Test to find a student by id
    @Test
    public void testFindStudentById() {
        //Arrange
        Student student = new Student(1L, "John Doe", null);

        //Act
        studentRepository.save(student);

        //Assert
        assert (studentRepository.findById(1L).isPresent());
    }

    //Test to modify a student
    @Test
    public void testModifyStudent() {
        //Arrange
        Student student = new Student(1L, "John Doe", null);
        Student modifiedStudent = new Student(1L, "Jane Doe", null);

        //Act
        studentRepository.save(student);
        studentRepository.save(modifiedStudent);

        //Assert
        assert (studentRepository.findById(1L).get().getStudentName().equals("Jane Doe"));
    }

    //Test to delete a student
    @Test
    public void testDeleteStudent() {
        //Arrange
        Student student = new Student(1L, "John Doe", null);

        //Act
        studentRepository.save(student);
        studentRepository.delete(1L);

        //Assert
        assert (studentRepository.findAll().size() == 0);
    }

    //Test to find a student by id that does not exist
    @Test
    public void testFindStudentByIdThatDoesNotExist() {
        //Arrange
        Student student = new Student(1L, "John Doe", null);

        //Act
        studentRepository.save(student);

        //Assert
        assert (!studentRepository.findById(2L).isPresent());
    }

    //Test to delete a student that does not exist
    @Test
    public void testDeleteStudentThatDoesNotExist() {
        //Arrange
        Student student = new Student(1L, "John Doe", null);

        //Act
        studentRepository.save(student);

        //Assert
        assert (!studentRepository.delete(2L));
    }

    //Test to modify a student that does not exist
    @Test
    public void testModifyStudentThatDoesNotExist() {
        //Arrange
        Student student = new Student(1L, "John Doe", null);
        Student modifiedStudent = new Student(2L, "Jane Doe", null);

        //Act
        studentRepository.save(student);

        //Assert
        assert (!studentRepository.save(modifiedStudent));
    }


}
