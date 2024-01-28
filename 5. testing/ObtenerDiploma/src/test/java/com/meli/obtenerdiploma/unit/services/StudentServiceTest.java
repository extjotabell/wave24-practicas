package com.meli.obtenerdiploma.unit.services;

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
import org.springframework.ui.ModelMap;
import org.modelmapper.ModelMapper;

import javax.management.modelmbean.ModelMBean;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {


    //mapear una clase

    @Mock
    private IStudentRepository studentRepository; //servicio tiene dependencia del repository

    @InjectMocks
    private StudentService studentService; // servicio usa ek mock


//    Metodo a evaluar
//    public boolean create(StudentDTO stu) {
//
//        Student studentEntity = new Student(
//                stu.id(),
//                stu.studentName(),
//                stu.subjects().stream().map(
//                        s -> new Subject(s.name(), s.score())
//                ).collect(Collectors.toSet())
//        );
//        +++++++++
//        return studentRepository.save(studentEntity);
//    }


    @Test
    public void testCreateStudent() {
        //Arrange
        //Param o parseo dento del servicoo
        StudentDTO studentDTO = new StudentDTO(1L, "Anderson Pedroza", Set.of(new SubjectDTO("Math", 100.0), new SubjectDTO("English", 50.0)));
        //return
        StudentDTO s = studentDTO;
        boolean expected = true;

        //mapeo de dto a clase porque se necesita pasar clase


        Student studentEntity = new Student(
                studentDTO.id(),
                studentDTO.studentName(),
                studentDTO.subjects().stream().map(
                        x -> new Subject(x.name(), x.score())
                ).collect(Collectors.toSet())
        );


        //Act
        //Ignote esta llamada y que debe devolver ++++
        Mockito.when(studentRepository.save(studentEntity)).thenReturn(expected);

        //metodo del service que correcponde
        var obtener  = studentService.create(studentDTO);


        //Assert
        Assertions.assertEquals(expected,obtener);
    }

    //tema de excepciones
//    @Override
//    public StudentDTO read(Long id) {
//        Student student = studentRepository.findById(id).orElseThrow(() ->{throw new StudentNotFoundException(id);
//        });
//        return new StudentDTO(
//                student.getId(),
//                student.getStudentName(),
//                student.getSubjects().stream().map(
//                        subject -> new SubjectDTO(
//                                subject.getName(),
//                                0D
//                        )).collect(Collectors.toSet())
//        );
//    }


    @Test
    @DisplayName("Exceptions ")
    public void testReadStudent() {
        //Arrange

        //param
        Long id = 7L;

        //llamada al repo ?????, no queremos joder con el repo pero esrta vacio
        Mockito.when(studentRepository.findById(id)).thenReturn(Optional.empty()); //si no lo encuentra entonces joser

        //Act y Assert
        Assertions.assertThrows(
                //clase de la excepcion a lanzar
                StudentNotFoundException.class,
                //funcion anonima para llamar el metodo act
                () -> studentService.read(id));

    }
}
