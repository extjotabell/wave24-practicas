package org.socialmeli.be_java_hisp_w24_g04.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.socialmeli.be_java_hisp_w24_g04.AppConfig;
import org.socialmeli.be_java_hisp_w24_g04.dto.ProductDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {
    MockMvc mockMvc;
    ObjectMapper objectMapper;
    @MockBean
    Clock clock;

    @Autowired
    public ProductControllerTest(MockMvc mockMvc, ObjectMapper objectMapper) {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
    }

    @BeforeEach
    public void setUp() {
        Instant fixedInstant = Instant.parse("2024-01-27T00:00:00Z");
        when(clock.instant()).thenReturn(fixedInstant);
        when(clock.getZone()).thenReturn(ZoneId.systemDefault());
    }

    @Test
    @DisplayName("If userId is right (without order).")
    void testIfUserIdIsRight() throws Exception {
        Integer userId = 101;
        String expectedProductName = "Product 3";
        String urn = "/products/followed/{userId}/list";

        mockMvc
                .perform(MockMvcRequestBuilders.get(urn, userId))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(TestingSetup.OK)
                .andExpect(TestingSetup.CONTENT_APP_JSON)
                .andExpect(
                        MockMvcResultMatchers
                                .jsonPath("$[0].product.product_name")
                                .value(expectedProductName)
                );
    }

    @Test
    @DisplayName("If userId isn't right (without order).")
    void testIfUserIdIsNotRight() throws Exception {
        Integer wrongIdParam = 1;
        String expectedErrorMessage = "User not found.";
        String urn = "/products/followed/{userId}/list";

        mockMvc
                .perform(MockMvcRequestBuilders.get(urn, wrongIdParam))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(TestingSetup.NOT_FOUND)
                .andExpect(TestingSetup.CONTENT_APP_JSON)
                .andExpect(
                        MockMvcResultMatchers
                                .jsonPath("$.error")
                                .value(expectedErrorMessage)
                );
    }

    @Test
    @DisplayName("If userId and order are right (with ascendant order).")
    void testIfUserIdAndOrderAreRightWithAsc() throws Exception {
        Integer userId = 103;
        String order = "date_asc";
        String[] expectedProductName = {"2024-01-16", "2024-01-17"};
        String urn = "/products/followed/{userId}/list?order={order}";

        mockMvc
                .perform(MockMvcRequestBuilders.get(urn, userId, order))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(TestingSetup.OK)
                .andExpect(TestingSetup.CONTENT_APP_JSON)
                .andExpect(
                        MockMvcResultMatchers
                                .jsonPath("$[0].date")
                                .value(expectedProductName[0])
                )
                .andExpect(
                        MockMvcResultMatchers
                                .jsonPath("$[1].date")
                                .value(expectedProductName[1])
                );
    }

    @Test
    @DisplayName("If userId and order are right (with descendent order).")
    void testIfUserIdAndOrderAreRightWithDesc() throws Exception {
        Integer userId = 103;
        String order = "date_desc";
        String[] expectedProductName = {"2024-01-17", "2024-01-16"};
        String urn = "/products/followed/{userId}/list?order={order}";

        mockMvc
                .perform(MockMvcRequestBuilders.get(urn, userId, order))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(TestingSetup.OK)
                .andExpect(TestingSetup.CONTENT_APP_JSON)
                .andExpect(
                        MockMvcResultMatchers
                                .jsonPath("$[0].date")
                                .value(expectedProductName[0])
                )
                .andExpect(
                        MockMvcResultMatchers
                                .jsonPath("$[1].date")
                                .value(expectedProductName[1])
                );
    }

    @Test
    @DisplayName("If userId is right but has incorrect order.")
    void testIfUserIdRightIncorrectOrder() throws Exception {
        Integer userId = 103;
        String order = "date_des";
        String expectedMessage = "Order must be date_asc or date_desc";
        String urn = "/products/followed/{userId}/list?order={order}";

        mockMvc
                .perform(MockMvcRequestBuilders.get(urn, userId, order))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(TestingSetup.BAD_REQUEST)
                .andExpect(TestingSetup.CONTENT_APP_JSON)
                .andExpect(
                        MockMvcResultMatchers
                                .jsonPath("$.error")
                                .value(expectedMessage)
                );
    }

    @Test
    @DisplayName("If user creates post with correct information.")
    void testIfUserCreatePostCorrectInformation() throws Exception {
        Integer expectedId = 101;
        UserPostDTO userPostDTO = new UserPostDTO(
                expectedId,
                "16-01-2024",
                new ProductDTO(
                        10000,
                        "Product Test",
                        "Type Test",
                        "This is a note",
                        "Brand Test",
                        "Black"
                ),
                1,
                29.99
        );
        String urn = "/products/post";

        mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post(urn)
                                .contentType(TestingSetup.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(userPostDTO))
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(TestingSetup.OK)
                .andExpect(TestingSetup.CONTENT_APP_JSON)
                .andExpect(
                        MockMvcResultMatchers
                               .jsonPath("$.data.user_id")
                               .value(expectedId)
                );
    }

    @Test
    @DisplayName("If user creates post with incorrect information.")
    void testIfUserCreatePostInCorrectInformation() throws Exception {
        String expectedErrorContains = "Se encontraron los siguientes errores en las validaciones:";
        UserPostDTO userPostDTO = new UserPostDTO(
                101,
                "16-01-24",
                new ProductDTO(
                        -10000,
                        "Product Test!",
                        "Type Test",
                        "This is a note",
                        "Brand Test",
                        "Black"
                ),
                1,
                29.99
        );
        String urn = "/products/post";

        mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post(urn)
                                .contentType(TestingSetup.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(userPostDTO))
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(TestingSetup.BAD_REQUEST)
                .andExpect(TestingSetup.CONTENT_APP_JSON)
                .andExpect(
                        MockMvcResultMatchers
                                .jsonPath("$.error", Matchers.startsWith(expectedErrorContains))
                );
    }

    @Test
    @DisplayName("If incorrect user creates post.")
    void testIfIncorrectUserCreatePost() throws Exception {
        String expectedErrorMessage = "Couldn't create user's post. Please, try again with a valid user ID.";
        UserPostDTO userPostDTO = new UserPostDTO(
                1,
                "16-01-2024",
                new ProductDTO(
                        10000,
                        "Product Test",
                        "Type Test",
                        "This is a note",
                        "Brand Test",
                        "Black"
                ),
                1,
                29.99
        );
        String urn = "/products/post";

        mockMvc
               .perform(
                        MockMvcRequestBuilders
                               .post(urn)
                               .contentType(TestingSetup.APPLICATION_JSON)
                               .content(objectMapper.writeValueAsString(userPostDTO))
                )
               .andDo(MockMvcResultHandlers.print())
               .andExpect(TestingSetup.BAD_REQUEST)
               .andExpect(TestingSetup.CONTENT_APP_JSON)
               .andExpect(
                        MockMvcResultMatchers
                              .jsonPath("$.error")
                              .value(expectedErrorMessage)
                );
    }
}

