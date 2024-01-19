package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.dto.StudentWithMessageDTO;
import com.meli.obtenerdiploma.dto.SubjectDTO;
import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentRepository studentRepository;
    @InjectMocks
    private ObtenerDiplomaService service;


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
    void analyzeScores() {
        Set<SubjectDTO> subjectsDTO = new HashSet<>(subjects.subList(0, 3)).stream().map(
                s -> new SubjectDTO(
                        s.getName(),
                        s.getScore()
                )
        ).collect(Collectors.toSet());

        StudentWithMessageDTO expect = new StudentWithMessageDTO(
                1L,
                "Juan",
                new HashSet<>(subjectsDTO),
                "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.",
                7.333333333333333
        );

        Mockito.when(studentRepository.findById(1L)).thenReturn(Optional.of(new Student(1L, "Juan", new HashSet<>(subjects.subList(0, 3)))));

        StudentWithMessageDTO result = service.analyzeScores(1L);

        Assertions.assertEquals(expect, result);
    }

    @Test
    public void getGreetingsMessage() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String expect = "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.";
        Method method = ObtenerDiplomaService.class.getDeclaredMethod("getGreetingMessage", String.class, Double.class);
        method.setAccessible(true);
        String result = (String) method.invoke(service, "Juan", 7.333333333333333);
        Assertions.assertEquals(expect, result);
    }

    @Test
    public void calculateAverage() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Double expect = 7.333333333333333;
        Method method = ObtenerDiplomaService.class.getDeclaredMethod("calculateAverage", Set.class);
        method.setAccessible(true);
        Double result = (Double) method.invoke(service, new HashSet<>(subjects.subList(0, 3)));
        Assertions.assertEquals(expect, result);
    }
}