package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.dto.ErrorDTO;
import com.meli.obtenerdiploma.dto.StudentDTO;
import com.meli.obtenerdiploma.dto.StudentWithMessageDTO;
import com.meli.obtenerdiploma.dto.SubjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    private final StudentDTO studentDTOId1 =
            new StudentDTO(
                    1L,
                    "Juan",
                    new HashSet<>(List.of(
                            new SubjectDTO("Matemática", 9.0),
                            new SubjectDTO("Física", 7.0),
                            new SubjectDTO("Química", 6.0)
                    ))
            );
    private final StudentDTO studentDTOId2 =
            new StudentDTO(
                    2L,
                    "Pedro",
                    new HashSet<>(List.of(
                            new SubjectDTO("Matemática", 10.0),
                            new SubjectDTO("Física", 8.0),
                            new SubjectDTO("Química", 4.0)
                    ))
            );
    StudentDTO newStudentDTO =
        new StudentDTO(
                2L,
                "Enzo",
                new HashSet<>(List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)
                ))
        );

    @Test
    @DisplayName("Test register student successfully")
    void registerStudentSuccessfullyTest() throws Exception {

        MockHttpServletRequestBuilder request = post("/student/registerStudent")
                .content(mapper.writeValueAsString(newStudentDTO))
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher statusExpected = status().isNoContent();

        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andDo(print());
    }

    @Test
    @DisplayName("Test register student and throw user not found")
    void registerStudentNotFoundTest() throws Exception {
        ErrorDTO expectedErrorDto = new ErrorDTO(
                "StudentNotFoundException",
                "El alumno con Id 6 no se encuetra registrado.");

        //Id 6 not found
        StudentDTO newStudentDTOBadRequest =
                new StudentDTO(
                        6L,
                        "Pepito",
                        new HashSet<>(List.of(
                                new SubjectDTO("Matemática", 9.0),
                                new SubjectDTO("Física", 7.0),
                                new SubjectDTO("Química", 6.0)
                        ))
                );

        MockHttpServletRequestBuilder request = post("/student/registerStudent")
                .content(mapper.writeValueAsString(newStudentDTOBadRequest))
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher statusExpected = status().isNotFound();
        ResultMatcher contentExpected = content().json(
                mapper.writeValueAsString(expectedErrorDto)
        );
        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentExpected)
                .andExpect(contentTypeExpected)
                .andDo(print());
    }

    @Test
    @DisplayName("Test get student by id")
    void getStudentByIdTest() throws Exception {

        Long param = 2L;

        MockHttpServletRequestBuilder request = get("/student/getStudent/{id}",param);

        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contentExpected = content().json(
                mapper.writeValueAsString(studentDTOId2)
        );
        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentExpected)
                .andExpect(contentTypeExpected)
                .andDo(print());
    }

    @Test
    @DisplayName("Test list all students")
    void listStudentsTest() throws Exception {

        Set<StudentDTO> expectedList = new HashSet<>(List.of(studentDTOId1, studentDTOId2));

        MockHttpServletRequestBuilder request = get("/student/listStudents");

        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contentExpected = content().json(
                mapper.writeValueAsString(expectedList)
        );
        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentExpected)
                .andExpect(contentTypeExpected)
                .andDo(print());
    }
}
