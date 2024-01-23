package com.meli.obtenerdiploma.integrationtest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();

    // ##############################################
    // ########## REGISTER STUDENT TESTS ############
    // ##############################################

    @Test
    public void registerStudentTestOk() throws Exception {
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(stu));

        // Expectations
        ResultMatcher expectedStatusCode = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedBody = MockMvcResultMatchers.content().string("");

        // Result actions
        this.mockMvc.perform(request)
                .andExpect(expectedStatusCode)
                .andExpect(expectedBody)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void registerStudentTestNoName() throws Exception {
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        stu.setStudentName(null);

        ErrorDTO error = new ErrorDTO("MethodArgumentNotValidException", "El nombre del estudiante no puede estar vacío.");

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(stu));

        // Expectations
        ResultMatcher expectedStatusCode = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedContentTypes = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedBody = MockMvcResultMatchers.content().json(writer.writeValueAsString(error));

        // Result actions
        this.mockMvc.perform(request)
                .andExpect(expectedStatusCode)
                .andExpect(expectedContentTypes)
                .andExpect(expectedBody)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void registerStudentTestNoCapsName() throws Exception {
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("marco");
        ErrorDTO error = new ErrorDTO("MethodArgumentNotValidException", "El nombre del estudiante debe comenzar con mayúscula.");

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(stu));

        // Expectations
        ResultMatcher expectedStatusCode = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedContentTypes = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedBody = MockMvcResultMatchers.content().json(writer.writeValueAsString(error));

        // Result actions
        this.mockMvc.perform(request)
                .andExpect(expectedStatusCode)
                .andExpect(expectedContentTypes)
                .andExpect(expectedBody)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void registerStudentTestLongName() throws Exception {
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco".repeat(100));
        ErrorDTO error = new ErrorDTO("MethodArgumentNotValidException", "La longitud del nombre del estudiante no puede superar los 50 caracteres.");

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(stu));

        // Expectations
        ResultMatcher expectedStatusCode = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedContentTypes = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedBody = MockMvcResultMatchers.content().json(writer.writeValueAsString(error));

        // Result actions
        this.mockMvc.perform(request)
                .andExpect(expectedStatusCode)
                .andExpect(expectedContentTypes)
                .andExpect(expectedBody)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void registerStudentTestNoSubjects() throws Exception {
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        stu.setSubjects(new ArrayList<>());

        ErrorDTO error = new ErrorDTO("MethodArgumentNotValidException", "La lista de materias no puede estar vacía.");

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(stu));

        // Expectations
        ResultMatcher expectedStatusCode = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedContentTypes = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedBody = MockMvcResultMatchers.content().json(writer.writeValueAsString(error));

        // Result actions
        this.mockMvc.perform(request)
                .andExpect(expectedStatusCode)
                .andExpect(expectedContentTypes)
                .andExpect(expectedBody)
                .andDo(MockMvcResultHandlers.print());
    }


    // ##############################################
    // ########## GET STUDENT TESTS #################
    // ##############################################

    @Test
    public void getStudentTestOk() throws Exception {
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        stu.setId(1L);

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/student/getStudent/{id}", stu.getId());

        // Expectations
        ResultMatcher expectedStatusCode = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedBody = MockMvcResultMatchers.content().json(writer.writeValueAsString(stu));

        // Result actions
        this.mockMvc.perform(request)
                .andExpect(expectedStatusCode)
                .andExpect(expectedBody)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getStudentTestNotFound() throws Exception {
        ErrorDTO error = new ErrorDTO("StudentNotFoundException", "El alumno con Id 8888 no se encuetra registrado.");

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/student/getStudent/{id}", 8888);

        // Expectations
        ResultMatcher expectedStatusCode = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher expectedContentTypes = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedBody = MockMvcResultMatchers.content().json(writer.writeValueAsString(error));

        // Result actions
        this.mockMvc.perform(request)
                .andExpect(expectedStatusCode)
                .andExpect(expectedContentTypes)
                .andExpect(expectedBody)
                .andDo(MockMvcResultHandlers.print());
    }

    // ##############################################
    // ########## MODIFY STUDENT TESTS ##############
    // ##############################################

    @Test
    public void modifyStudentTestOk() throws Exception {
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        stu.setId(1L);

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(stu));

        // Expectations
        ResultMatcher expectedStatusCode = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedBody = MockMvcResultMatchers.content().string("");

        // Result actions
        this.mockMvc.perform(request)
                .andExpect(expectedStatusCode)
                .andExpect(expectedBody)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void modifyStudentTestNoName() throws Exception {
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        stu.setStudentName(null);

        ErrorDTO error = new ErrorDTO("MethodArgumentNotValidException", "El nombre del estudiante no puede estar vacío.");

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(stu));

        // Expectations
        ResultMatcher expectedStatusCode = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedContentTypes = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedBody = MockMvcResultMatchers.content().json(writer.writeValueAsString(error));

        // Result actions
        this.mockMvc.perform(request)
                .andExpect(expectedStatusCode)
                .andExpect(expectedContentTypes)
                .andExpect(expectedBody)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void modifyStudentTestNoCapsName() throws Exception {
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("marco");
        ErrorDTO error = new ErrorDTO("MethodArgumentNotValidException", "El nombre del estudiante debe comenzar con mayúscula.");

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(stu));

        // Expectations
        ResultMatcher expectedStatusCode = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedContentTypes = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedBody = MockMvcResultMatchers.content().json(writer.writeValueAsString(error));

        // Result actions
        this.mockMvc.perform(request)
                .andExpect(expectedStatusCode)
                .andExpect(expectedContentTypes)
                .andExpect(expectedBody)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void modifyStudentTestLongName() throws Exception {
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco".repeat(100));
        ErrorDTO error = new ErrorDTO("MethodArgumentNotValidException", "La longitud del nombre del estudiante no puede superar los 50 caracteres.");

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(stu));

        // Expectations
        ResultMatcher expectedStatusCode = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedContentTypes = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedBody = MockMvcResultMatchers.content().json(writer.writeValueAsString(error));

        // Result actions
        this.mockMvc.perform(request)
                .andExpect(expectedStatusCode)
                .andExpect(expectedContentTypes)
                .andExpect(expectedBody)
                .andDo(MockMvcResultHandlers.print());

    }

    // ##############################################
    // ########## REMOVE STUDENT TESTS ##############
    // ##############################################

    @Test
    public void removeStudentTestOk() throws Exception {
        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/student/removeStudent/{id}", 1L);

        // Expectations
        ResultMatcher expectedStatusCode = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedBody = MockMvcResultMatchers.content().string("");

        // Result actions
        this.mockMvc.perform(request)
                .andExpect(expectedStatusCode)
                .andExpect(expectedBody)
                .andDo(MockMvcResultHandlers.print());
    }

    @AfterEach
    public void restoreDatabase() {
        Properties properties = new Properties();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            String scope = properties.getProperty("api.scope");

            File backupFile = ResourceUtils.getFile("./src/" + scope + "/resources/users_backup.json");
            Set<StudentDTO> initialData = objectMapper.readValue(backupFile, new TypeReference<Set<StudentDTO>>() {
            });

            File file = ResourceUtils.getFile("./src/" + scope + "/resources/users.json");
            objectMapper.writeValue(file, initialData);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while restoring DB, check your resources files and JSON formatting.");
        }
    }

}
