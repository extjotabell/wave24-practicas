package org.socialmeli.be_java_hisp_w24_g04.integrationtest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.socialmeli.be_java_hisp_w24_g04.TestUtils;
import org.socialmeli.be_java_hisp_w24_g04.dto.*;
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

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {

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
    // ############ GET FOLLOWERS LIST ##############
    // ##############################################

    @Test
    public void testGetUserFollowersList() throws Exception {
        UserFollowersDTO data = TestUtils.getUserFollowersDTO();
        SingleResponseDTO expectedResponse = new SingleResponseDTO(200, data);

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/list", 102);

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
    public void testGetUserFollowersListWithOrderAsc() throws Exception {
        UserFollowersDTO data = TestUtils.getUserFollowersDTO();
        SingleResponseDTO expectedResponse = new SingleResponseDTO(200, data);

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/list", 102)
                .param("order", "name_asc");

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
    public void testGetUserFollowersListWithOrderDesc() throws Exception {
        UserFollowersDTO data = TestUtils.getUserFollowersDTODesc();
        SingleResponseDTO expectedResponse = new SingleResponseDTO(200, data);

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/list", 102)
                .param("order", "name_desc");

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
    public void testGetUserFollowersListWithOrderInvalid() throws Exception {
        ErrorResponseDTO expectedResponse = new ErrorResponseDTO(400, "Parameter order with invalid format");

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/list", 102)
                .param("order", "invalidOrder");

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
    public void testGetUserFollowersListWithInvalidUserId() throws Exception {
        ErrorResponseDTO expectedResponse = new ErrorResponseDTO(400, "Se encontraron los siguientes errores en las validaciones: El user_id debe ser mayor a cero.");

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/list", -102);

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
    public void testGetUserFollowersListWithUserNotFound() throws Exception {
        int id = 999;
        ErrorResponseDTO expectedResponse = new ErrorResponseDTO(404, "User with id " + id + " not found");

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/list", id);

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

    // ##############################################
    // ############ GET FOLLOWED LIST ###############
    // ##############################################

    @Test
    public void testGetUserFollowedList() throws Exception {
        UserFollowedDTO data = TestUtils.getUserFollowedDTO();
        SingleResponseDTO expectedResponse = new SingleResponseDTO(200, data);

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followed/list", 102);

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
    public void testGetUserFollowedListWithOrderAsc() throws Exception {
        UserFollowedDTO data = TestUtils.getUserFollowedDTO();
        SingleResponseDTO expectedResponse = new SingleResponseDTO(200, data);

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followed/list", 102)
                .param("order", "name_asc");

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
    public void testGetUserFollowedListWithOrderDesc() throws Exception {
        UserFollowedDTO data = TestUtils.getUserFollowedDTODesc();
        SingleResponseDTO expectedResponse = new SingleResponseDTO(200, data);

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followed/list", 102)
                .param("order", "name_desc");

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
    public void testGetUserFollowedListWithOrderInvalid() throws Exception {
        ErrorResponseDTO expectedResponse = new ErrorResponseDTO(400, "Parameter order with invalid format");

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followed/list", 102)
                .param("order", "invalidOrder");

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
    public void testGetUserFollowedListWithInvalidUserId() throws Exception {
        ErrorResponseDTO expectedResponse = new ErrorResponseDTO(400, "Se encontraron los siguientes errores en las validaciones: El user_id debe ser mayor a cero.");

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followed/list", -102);

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
    public void testGetUserFollowedListWithUserNotFound() throws Exception {
        int id = 999;
        ErrorResponseDTO expectedResponse = new ErrorResponseDTO(404, "User with id " + id + " not found");

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followed/list", id);

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

    // ##############################################
    // ############ GET FOLLOWERS COUNT #############
    // ##############################################

    @Test
    public void testGetUserFollowersCount() throws Exception {
        UserFollowerCountDTO data = TestUtils.getUserFollowerCountDTO();
        SingleResponseDTO expectedResponse = new SingleResponseDTO(200, data);

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count", 102);

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
    public void testGetUserFollowersCountWithInvalidUserId() throws Exception {
        ErrorResponseDTO expectedResponse = new ErrorResponseDTO(400, "Se encontraron los siguientes errores en las validaciones: El user_id debe ser mayor a cero.");

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count", -102);

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
    public void testGetUserFollowersCountWithUserNotFound() throws Exception {
        int id = 999;
        ErrorResponseDTO expectedResponse = new ErrorResponseDTO(404, "User with id " + id + " not found");

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count", id);

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

    // ##############################################
    // ################ FOLLOW USER #################
    // ##############################################

    @Test
    public void testFollowUser() throws Exception {
        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 101, 104);

        // Expectations
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        // Perform
        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testFollowUserWithInvalidUserId() throws Exception {
        ErrorResponseDTO expectedResponse = new ErrorResponseDTO(400, "Se encontraron los siguientes errores en las validaciones: El user_id debe ser mayor a cero.");

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", -102, 101);

        // Expectations
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedBody = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResponse));

        // Perform
        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andExpect(expectedBody)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testFollowUserWithInvalidUserIdToFollow() throws Exception {
        ErrorResponseDTO expectedResponse = new ErrorResponseDTO(400, "Se encontraron los siguientes errores en las validaciones: El userIdToFollow debe ser mayor a cero.");

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 102, -101);

        // Expectations
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedBody = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResponse));

        // Perform
        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andExpect(expectedBody)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testFollowUserWithUserNotFound() throws Exception {
        int id = 999;
        ErrorResponseDTO expectedResponse = new ErrorResponseDTO(404, "User with id " + id + " not found");

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", id, 101);

        // Expectations
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher expectedBody = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResponse));

        // Perform
        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andExpect(expectedBody)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testFollowUserWithUserToFollowNotFound() throws Exception {
        int id = 999;
        ErrorResponseDTO expectedResponse = new ErrorResponseDTO(404, "User with id " + id + " not found");

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 102, id);

        // Expectations
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher expectedBody = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResponse));

        // Perform
        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andExpect(expectedBody)
                .andDo(MockMvcResultHandlers.print());
    }

    // ##############################################
    // ############### UNFOLLOW USER ################
    // ##############################################

    @Test
    public void testUnfollowUser() throws Exception {
        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 102, 101);

        // Expectations
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        // Perform
        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testUnfollowUserWithInvalidUserId() throws Exception {
        ErrorResponseDTO expectedResponse = new ErrorResponseDTO(400, "Se encontraron los siguientes errores en las validaciones: El user_id debe ser mayor a cero.");

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", -102, 101);

        // Expectations
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andExpect(MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResponse)))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testUnfollowUserWithInvalidUserIdToUnfollow() throws Exception {
        ErrorResponseDTO expectedResponse = new ErrorResponseDTO(400, "Se encontraron los siguientes errores en las validaciones: El userIdToUnfollow debe ser mayor a cero.");

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 102, -101);

        // Expectations
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andExpect(MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResponse)))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testUnfollowUserWithUserNotFound() throws Exception {
        int id = 999;
        ErrorResponseDTO expectedResponse = new ErrorResponseDTO(404, "User with id " + id + " not found");

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", id, 101);

        // Expectations
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();

        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andExpect(MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResponse)))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testUnfollowUserWithUserToUnfollowNotFound() throws Exception {
        int id = 999;
        ErrorResponseDTO expectedResponse = new ErrorResponseDTO(404, "User with id " + id + " not found");

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 102, id);

        // Expectations
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();

        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andExpect(MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResponse)))
                .andDo(MockMvcResultHandlers.print());
    }

}
