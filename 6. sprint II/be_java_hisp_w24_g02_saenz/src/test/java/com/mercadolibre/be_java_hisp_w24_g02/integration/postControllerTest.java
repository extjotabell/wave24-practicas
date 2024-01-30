package com.mercadolibre.be_java_hisp_w24_g02.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.be_java_hisp_w24_g02.dto.CreatePostDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.CreateProductDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.PostDto;
import com.mercadolibre.be_java_hisp_w24_g02.dto.UserFollowedsPostsDTO;
import com.mercadolibre.be_java_hisp_w24_g02.entity.Product;
import com.mercadolibre.be_java_hisp_w24_g02.entity.User;
import com.mercadolibre.be_java_hisp_w24_g02.repository.interfaces.IUserRepository;
import net.bytebuddy.pool.TypePool;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    //Para simular solicitudes HTTP
    @Autowired
    private MockMvc mockMvc;
    //Biblioteca para convertir objetos a JSON y viceversa
    @Autowired
    private ObjectMapper objectMapper;
    @Mock
    private IUserRepository userRepository;


    @Test
    @DisplayName("Integration Test to post endpoint about Add New product.")
    public void AddNewProductPostTest() throws Exception {
        // Arrange
        CreatePostDTO createPostDTO = new CreatePostDTO(
                1,
                "26-01-2024",
                new CreateProductDTO(
                        1101,
                        "Computador TestIntegracion",
                        "All in one",
                        "Apple",
                        "Blanco",
                        "Computador basico"
                ),
                1,
                11.0
        );

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders //Inicia una simulacion de solicitud http
                        .post("/products/post") //Configura la solictud
                        .contentType(MediaType.APPLICATION_JSON) //Establece el tipo de contenido de la solicitud como JSON
                        .content(objectMapper.writeValueAsString(createPostDTO))) // Crea el cuerpo de la solicitud con mapper. Pasa el objeto a JSON

                .andExpect(MockMvcResultMatchers.status().isOk()) //Verifica que llegan los datos esperados
                .andReturn(); //Finaliza la solictud y devuelve el resultado
    }


    @Test
    @DisplayName("Integration Test to verify exception to id greater than zero.")
    public void AddNewProductPostTestInvalidId() throws Exception {
        // Arrange
        CreatePostDTO createPostDTO = new CreatePostDTO(
                -1,
                "26-01-2024",
                new CreateProductDTO(
                        1101,
                        "Computador TestIntegracion",
                        "All in one",
                        "Apple",
                        "Blanco",
                        "Computador basico"
                ),
                1,
                11.0
        );

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createPostDTO)))

                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andReturn();
    }

    @Test
    @DisplayName("Integration Test to verify exception to date format.")
    public void AddNewProductPostTestInvalidDate() throws Exception {
        // Arrange
        CreatePostDTO createPostDTO = new CreatePostDTO(
                1,
                "26---2024",
                new CreateProductDTO(
                        1101,
                        "Computador TestIntegracion",
                        "All in one",
                        "Apple",
                        "Blanco",
                        "Computador basico"
                ),
                1,
                11.0
        );

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createPostDTO)))

                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andReturn();
    }

    @Test
    @DisplayName("Integration Test to verify getUsersFollowed post by id NotFoundException")
    public void getUserFollowedTestNotFoundException() throws Exception {
        // Arrange
        RequestBuilder request = MockMvcRequestBuilders.get("/products/followed/50/list")
                .contentType("application/json");
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();

        // Act - Assert
        mockMvc.perform(request)
                .andExpect(statusExpected);
    }


}
