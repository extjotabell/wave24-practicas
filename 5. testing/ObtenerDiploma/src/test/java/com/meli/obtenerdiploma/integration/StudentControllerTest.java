package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.dto.StudentDTO;
import com.meli.obtenerdiploma.dto.SubjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {


    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    private final StudentDTO student1 = new StudentDTO(
            1L,
            "Juan",
            new HashSet<>(Set.of(new SubjectDTO(
                    "Matemática",
                    0D
            ), new SubjectDTO(
                    "Física",
                    0D
            ), new SubjectDTO(
                    "Química",
                    0D
            )))
    );

    // Test para el caso feliz de obtener la lista de estudiantes
    @Test
    @DisplayName("Happy path: List all students")
    public void listAllStudentsHappyPath() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andExpect(status().isOk());
    }

    // Test para el caso feliz de eliminar un estudiante existente
    @Test
    @DisplayName("Happy path: Remove an existing student")
    public void removeExistingStudentHappyPath() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 1L))
                .andExpect(status().isNoContent());
    }

    // Test para el caso triste de eliminar un estudiante inexistente
    @Test
    @DisplayName("Sad path: Remove a non-existing student")
    public void removeNonExistingStudentSadPath() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 999L))
                .andExpect(status().isBadRequest());
    }

    // Test para el caso feliz de modificar un estudiante existente
    @Test
    @DisplayName("Happy path: Modify an existing student")
    public void modifyExistingStudentHappyPath() throws Exception {
        StudentDTO modifiedStudentDTO = new StudentDTO(1L, "Juan Updated", Set.of(new SubjectDTO("Math", 9D)));

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(modifiedStudentDTO)))
                .andExpect(status().isNoContent());
    }

    // Test para el caso triste de modificar un estudiante inexistente
    @Test
    @DisplayName("Sad path: Modify a non-existing student")
    public void modifyNonExistingStudentSadPath() throws Exception {
        StudentDTO nonExistingStudentDTO = new StudentDTO(999L, "Non Existing Student", Set.of(new SubjectDTO("Math", 9D)));

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(nonExistingStudentDTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Happy path: Register a new student")
    public void registerStudentHappyPath() throws Exception {
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", Set.of(new SubjectDTO("Math", 9D)));

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(studentDTO)))
                .andExpect(status().isNoContent());
    }

    // Test para el caso triste de registro de estudiante
    @Test
    @DisplayName("Sad path: Register a student with invalid data")
    public void registerStudentSadPath() throws Exception {
        StudentDTO invalidStudentDTO = new StudentDTO(null, null, null);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(invalidStudentDTO)))
                .andExpect(status().isBadRequest());
    }

    // Test para el caso feliz de obtener un estudiante

    @Test
    @DisplayName("Happy path: Get an existing student")
    public void getStudentHappyPath() throws Exception {

        //arrange

        //paso 1 - request
        String url = "/student/getStudent/{id}";
        Long param = 1L;
        RequestBuilder request = MockMvcRequestBuilders.get(url, param);
        // paso 2 construir el expected del status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        // paso 3 construir el expected del body
        StudentDTO expected = student1;
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));
        // paso 4 construir el expected del content type
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //act & assert

        //paso 5 ejecutar el request

        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(bodyExpected)
                .andExpect(contentTypeExpected);


    }

    // Test para el caso triste de obtener un estudiante inexistente
    @Test
    @DisplayName("Sad path: Get a non-existing student")
    public void getNonExistingStudentSadPath() throws Exception {
        //arrange

        //paso 1 - request
        String url = "/student/getStudent/{id}";
        Long param = 999L;
        RequestBuilder request = MockMvcRequestBuilders.get(url, param);
        // paso 2 construir el expected del status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        // paso 3 construir el expected del body
        StudentDTO expected = student1;
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected));
        // paso 4 construir el expected del content type
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //act & assert

        //paso 5 ejecutar el request

        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(bodyExpected)
                .andExpect(contentTypeExpected);
    }






}
