package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ObetenerDiplomaApplicationTests {

	@Autowired
	IStudentRepository IStudentRepository;
	@Mock
	StudentRepository studentRepository;
	@InjectMocks
	ObtenerDiplomaService obtenerDiplomaService;

	@Test
	public void findAllStudentTest() {
		Set<Student> expectedStudents = new HashSet<>();
		expectedStudents.add(new Student(2L, "Pedro", new HashSet<Subject>(
				List.of(new Subject("Matemática", 10.0),
						new Subject("Física", 8.0),
						new Subject("Química", 4.0)))));
		expectedStudents.add(new Student(1L, "Juan", new HashSet<Subject>(
				List.of(new Subject("Matemática", 9.0),
						new Subject("Física", 7.0),
						new Subject("Química", 6.0)))));


		Assertions.assertEquals(expectedStudents, IStudentRepository.findAll());
	}

	@Test
	public void saveStudentTest(){
		Student expectedStudent = new Student(1L, "Pepito", new HashSet<Subject>(
				List.of(new Subject("Matemática", 9.0),
						new Subject("Física", 7.0),
						new Subject("Química", 6.0))));

		Assertions.assertEquals(true, IStudentRepository.save(expectedStudent));
	}

	@Test
	public void deleteStudentTest(){
		Assertions.assertEquals(true, IStudentRepository.delete(1L));
	}

	@Test
	public void createStudentTest(){
		Student student = new Student(1L, "Pepito", new HashSet<Subject>(
				List.of(new Subject("Matemática", 9.0),
						new Subject("Física", 7.0),
						new Subject("Química", 6.0))));

		when(studentRepository.save(student)).thenReturn(true);

	}

}