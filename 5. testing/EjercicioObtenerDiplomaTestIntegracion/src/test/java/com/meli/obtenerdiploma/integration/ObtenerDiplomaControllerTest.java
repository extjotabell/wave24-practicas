package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.dto.ErrorDTO;
import com.meli.obtenerdiploma.dto.StudentWithMessageDTO;
import com.meli.obtenerdiploma.dto.SubjectDTO;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.exception.ObtenerDiplomaException;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
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
public class ObtenerDiplomaControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    private final Subject subject1 = new Subject("Matemática", 10.0);
    private final Subject subject2 = new Subject("Física", 8.0);
    private final Subject subject3 = new Subject("Química", 4.0);
    private final StudentWithMessageDTO studentWithMessageDTO = new StudentWithMessageDTO(
            2L,
            "Pedro",
            Set.of(
                    new SubjectDTO(subject2.getName(), subject2.getScore()),
                    new SubjectDTO(subject3.getName(), subject3.getScore()),
                    new SubjectDTO(subject1.getName(), subject1.getScore())
            ),
            "El alumno Pedro ha obtenido un promedio de 7,33. Puedes mejorar.",
            7.333333333333333
    );

    @Test
    public void analyzeScoresTest() throws Exception {

        //arrange
        String url = "/analyzeScores/{studentId}";
        Long param = 2L;

        StudentWithMessageDTO expected = studentWithMessageDTO;

        RequestBuilder request = MockMvcRequestBuilders.get(url, param);

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
    public void analyzeScoresStudentNotFoundTest() throws Exception {

        //arrange
        String url = "/analyzeScores/{studentId}";
        Long param = 4L;

        RequestBuilder request = MockMvcRequestBuilders.get(url, param);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();

        ErrorDTO expected = new ErrorDTO("StudentNotFoundException", "El alumno con Id 4 no se encuetra registrado.");

        //ObtenerDiplomaException expected = new ObtenerDiplomaException(param);

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );

        ResultMatcher typeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // act && assert

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)//verifica el status
                .andExpect(typeExpected)// verifica el tipo
                .andExpect(bodyExpected);// verifica el body

    }
}
