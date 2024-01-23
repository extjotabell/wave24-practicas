package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.dto.StudentDTO;
import com.meli.obtenerdiploma.dto.SubjectDTO;
import com.meli.obtenerdiploma.entity.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Set;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    private final Subject subject1 = new Subject("Matemática", 10.0);
    private final Subject subject2 = new Subject("Física", 8.0);
    private final Subject subject3 = new Subject("Química", 4.0);

    @Test
    @DirtiesContext
    public void registerStudentTest() throws Exception {

        //arrange
        String url = "/student/registerStudent";
        StudentDTO studentDTO = new StudentDTO(
                2L,
                "Luis", Set.of(
                new SubjectDTO("POO", 10.0)
        ));

        RequestBuilder request = MockMvcRequestBuilders.post(url)
                .content(mapper.writeValueAsString(studentDTO))
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNoContent();

        // act && assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected);//verifica el status
    }

    @Test
    public void getStudentTest() throws Exception {

        //arrange
        String url = "/student/getStudent/{id}";
        Long param = 2L;
        StudentDTO expected = new StudentDTO(
                2L,
                "Pedro", Set.of(
                new SubjectDTO(subject2.getName(), subject2.getScore()),
                new SubjectDTO(subject3.getName(), subject3.getScore()),
                new SubjectDTO(subject1.getName(), subject1.getScore())
        ));

        RequestBuilder request = MockMvcRequestBuilders.get(url,param);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );

        ResultMatcher typeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act && assert

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)//verifica el status
                .andExpect(bodyExpected)// verifica el body
                .andExpect(typeExpected);// verifica el tipo
    }

    @Test
    @DirtiesContext
    public void updateStudentTest() throws Exception {

        //arrange
        String url = "/student/modifyStudent";
        StudentDTO studentDTO = new StudentDTO(
                2L,
                "Luis", Set.of(
                new SubjectDTO("POO", 10.0)
        ));

        RequestBuilder request = MockMvcRequestBuilders.post(url)
                .content(mapper.writeValueAsString(studentDTO))
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNoContent();


        // act && assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected);//verifica el status
    }

    @Test
    @DirtiesContext
    public void deleteStudentTest() throws Exception {

        //arrange
        String url = "/student/removeStudent/{id}";
        Long param = 2L;

        RequestBuilder request = MockMvcRequestBuilders.get(url,param);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNoContent();


        // act && assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected);//verifica el status
    }

    @Test
    public void getAllStudentTest() throws Exception {

        //arrange
        String url = "/student/listStudents";

        RequestBuilder request = MockMvcRequestBuilders.get(url);

        Set<SubjectDTO> subjectStudent1DTO = Set.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        );
        Set<SubjectDTO> subjectStudent2DTO = Set.of(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0)
        );
        StudentDTO studentDTO1 = new StudentDTO(1L, "Juan", subjectStudent1DTO);
        StudentDTO studentDTO2 = new StudentDTO(2L, "Pedro", subjectStudent2DTO);
        Set<StudentDTO> expected = Set.of(
                studentDTO1,
                studentDTO2
        );

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );

        ResultMatcher typeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act && assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, typeExpected);
    }
}
