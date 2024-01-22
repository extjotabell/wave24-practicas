package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.dto.ErrorDTO;
import com.meli.obtenerdiploma.dto.StudentDTO;
import com.meli.obtenerdiploma.dto.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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

    private final String rootPath = "/student";

    @Test
    public void getStudentTest() throws Exception {
        String url = rootPath + "/getStudent/{id}";
        Long param = 1L;

        RequestBuilder request = MockMvcRequestBuilders.get(url, param);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        StudentDTO expected = new StudentDTO(
                1L,
                "Juan",
                Set.of(
                        new SubjectDTO("Matemática", 9D),
                        new SubjectDTO("Física", 7D),
                        new SubjectDTO("Química", 6D)
                )
        );

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );

        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected) // verifica el status
                .andExpect(bodyExpected) // verifica el body
                .andExpect(contentTypeExpected); // verifica el tipo

    }
    @Test
    public void registerStudentHappyPath() throws Exception {

        String url = rootPath + "/registerStudent";

        StudentDTO studentCompleteDTO = new StudentDTO(
                3L,
                "Juan",
                Set.of(
                        new SubjectDTO("Matematica", 10D),
                        new SubjectDTO("Lengua", 10D),
                        new SubjectDTO("Ciencias", 10D)
                )
        );

        RequestBuilder request = MockMvcRequestBuilders.post(url)
                .content(mapper.writeValueAsString(studentCompleteDTO))
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNoContent();

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected);
    }

    @Test
    public void modifyStudentTestHappyPath() throws Exception {
        String url = rootPath + "/modifyStudent";
        StudentDTO studentCompleteDTO = new StudentDTO(
                2L,
                "Facu",
                Set.of(
                        new SubjectDTO("Matematica", 10D),
                        new SubjectDTO("Lengua", 10D),
                        new SubjectDTO("Ciencias", 10D)
                )
        );

        RequestBuilder request = MockMvcRequestBuilders.put(url)
                .content(mapper.writeValueAsString(studentCompleteDTO))
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNoContent();

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected);
    }

    @Test
    public void modifyStudentTestSadPath() throws Exception {
        String url = rootPath + "/modifyStudent";
        StudentDTO studentCompleteDTO = new StudentDTO(
                3L,
                "Facu",
                Set.of(
                        new SubjectDTO("Matematica", 10D),
                        new SubjectDTO("Lengua", 10D),
                        new SubjectDTO("Ciencias", 10D)
                )
        );

        RequestBuilder request = MockMvcRequestBuilders.put(url)
                .content(mapper.writeValueAsString(studentCompleteDTO))
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();
        ErrorDTO errorDTO = new ErrorDTO("StudentNotFoundException", "El alumno con Id 3 no se encuetra registrado.");
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(errorDTO));

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(bodyExpected)
                .andExpect(statusExpected);
    }

    @Test
    public void removeStudentTest() throws Exception {
        String url = rootPath + "/removeStudent/{id}";
        Long param = 2L;

        RequestBuilder request = MockMvcRequestBuilders.delete(url, param);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNoContent();

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected);
    }

}
