package org.socialmeli.be_java_hisp_w24_g04.integrationtest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.socialmeli.be_java_hisp_w24_g04.TestUtils;
import org.socialmeli.be_java_hisp_w24_g04.dto.ErrorResponseDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.PostDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.SingleResponseDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    Clock clock;

    @BeforeEach
    public void setUp() {
        Instant fixedInstant = Instant.parse("2024-01-27T00:00:00Z");
        Mockito.when(clock.instant()).thenReturn(fixedInstant);
        Mockito.when(clock.getZone()).thenReturn(ZoneId.systemDefault());
    }

    ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();


    // ##############################################
    // ################ SEARCH POSTS ################
    // ##############################################

    @Test
    public void testSearchAllFollowedLastTwoWeeks() throws Exception {
        List<PostDTO> expectedPosts = TestUtils.getPostDTOList();

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/products/followed/{userId}/list", 103);

        // Expectations
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedBody = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedPosts));

        // Perform
        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedBody)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testSearchAllFollowedLasTwoWeeksOrderAsc() throws Exception {
        List<PostDTO> expectedPosts = TestUtils.getPostDTOList();

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/products/followed/{userId}/list", 103)
                .param("order", "date_asc");

        // Expectations
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedBody = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedPosts));

        // Perform
        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedBody)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testSearchAllFollowedLasTwoWeeksOrderDesc() throws Exception {
        List<PostDTO> expectedPosts = TestUtils.getPostDTOListDesc();

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/products/followed/{userId}/list", 103)
                .param("order", "date_desc");

        // Expectations
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedBody = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedPosts));

        // Perform
        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedBody)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testSearchAllFollowedLasTwoWeeksOrderInvalid() throws Exception {
        ErrorResponseDTO expectedResponse = new ErrorResponseDTO(400, "Order must be date_asc or date_desc");

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/products/followed/{userId}/list", 103)
                .param("order", "date_desc_invalid");

        // Expectations
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedBody = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResponse));

        // Perform
        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedBody)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testSearchAllFollowedLasTwoWeeksUserIdNotFound() throws Exception {
        ErrorResponseDTO expectedResponse = new ErrorResponseDTO(404, "User not found.");

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/products/followed/{userId}/list", 999);

        // Expectations
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedBody = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResponse));

        // Perform
        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedBody)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testSearchAllFollowedLasTwoWeeksInvalidUserId() throws Exception {
        ErrorResponseDTO expectedResponse = new ErrorResponseDTO(400, "Se encontraron los siguientes errores en las validaciones: El user_id debe ser mayor a cero.");

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/products/followed/{userId}/list", -1);

        // Expectations
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedBody = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResponse));

        // Perform
        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedBody)
                .andDo(MockMvcResultHandlers.print());
    }


    // ##############################################
    // ################ CREATE POST #################
    // ##############################################

    @Test
    public void testCreateUserPost() throws Exception {
        UserPostDTO userPost = TestUtils.getUserPostDTO();
        SingleResponseDTO expectedResponse = new SingleResponseDTO(200, userPost);

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(userPost));

        // Expectations
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedBody = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResponse));

        // Perform
        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedBody)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testCreateUserPostInvalidBlankDTO() throws Exception {
        UserPostDTO userPost = TestUtils.getBlankInvalidUserPostDTO();

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(userPost));

        // Expectations
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedBody = MockMvcResultMatchers.jsonPath(
                "$.error",
                Matchers.allOf(
                        Matchers.containsString("Se encontraron los siguientes errores en las validaciones:"),
                        Matchers.containsString("Parámetro user_id faltante (tipo Integer)."),
                        Matchers.containsString("La fecha no puede estar vacía."),
                        Matchers.containsString("El campo category no puede estar vacío."),
                        Matchers.containsString("El campo price no puede estar vacío."),
                        Matchers.containsString("Parámetro product_id faltante (tipo Integer)."),
                        Matchers.containsString("El campo product_name no puede estar vacío."),
                        Matchers.containsString("El campo type no puede estar vacío."),
                        Matchers.containsString("El campo brand no puede estar vacío."),
                        Matchers.containsString("El campo color no puede estar vacío.")
                )
        );

        // Perform
        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedBody)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testCreateUserPostInvalidPatternDTO() throws Exception {
        UserPostDTO userPost = TestUtils.getPatternInvalidUserPostDTO();

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(userPost));

        // Expectations
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedBody = MockMvcResultMatchers.jsonPath(
                "$.error",
                Matchers.allOf(
                        Matchers.containsString("Se encontraron los siguientes errores en las validaciones:"),
                        Matchers.containsString("El campo product_name no puede poseer caracteres especiales."),
                        Matchers.containsString("El campo type no puede poseer caracteres especiales."),
                        Matchers.containsString("El campo brand no puede poseer caracteres especiales."),
                        Matchers.containsString("El campo color no puede poseer caracteres especiales.")
                )
        );

        // Perform
        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedBody)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testCreateUserPostInvalidSizeDTO() throws Exception {
        UserPostDTO userPost = TestUtils.getSizeInvalidUserPostDTO();

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(userPost));

        // Expectations
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedBody = MockMvcResultMatchers.jsonPath(
                "$.error",
                Matchers.allOf(
                        Matchers.containsString("Se encontraron los siguientes errores en las validaciones:"),
                        Matchers.containsString("La longitud de product_name no puede superar los 60 caracteres o ser menor de 3 caracteres."),
                        Matchers.containsString("La longitud de type no puede superar los 15 caracteres."),
                        Matchers.containsString("La longitud de notes no puede superar los 15 caracteres."),
                        Matchers.containsString("La longitud de brand no puede superar los 25 caracteres."),
                        Matchers.containsString("La longitud de color no puede superar los 15 caracteres.")
                )
        );

        // Perform
        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedBody)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testCreateUserPostInvalidUserIdDTO() throws Exception {
        UserPostDTO userPost = TestUtils.getUserIdInvalidUserPostDTO();
        ErrorResponseDTO expectedResponse = new ErrorResponseDTO(400, "Se encontraron los siguientes errores en las validaciones: El user_id debe ser mayor a cero.");

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(userPost));

        // Expectations
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedBody = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResponse));

        // Perform
        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedBody)
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void testCreateUserPostInvalidDateFormatDTO() throws Exception {
        UserPostDTO userPost = TestUtils.getDateFormatInvalidUserPostDTO();
        ErrorResponseDTO expectedResponse = new ErrorResponseDTO(400, "Invalid date format. It should be dd-MM-yyyy");

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(userPost));

        // Expectations
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedBody = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResponse));

        // Perform
        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedBody)
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void testCreateUserPostInvalidPriceDTO() throws Exception {
        UserPostDTO userPost = TestUtils.getPriceInvalidUserPostDTO();
        ErrorResponseDTO expectedResponse = new ErrorResponseDTO(400, "Se encontraron los siguientes errores en las validaciones: El precio máximo por producto es de 10.000.000");

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(userPost));

        // Expectations
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedBody = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResponse));

        // Perform
        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedBody)
                .andDo(MockMvcResultHandlers.print());

    }

}
