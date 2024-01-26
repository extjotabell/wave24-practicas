package com.mercadolibre.be_java_hisp_w24_g02.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.be_java_hisp_w24_g02.dto.CreatePostDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.CreateProductDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class postControllerTest {

    //Para simular solicitudes HTTP
    @Autowired
    private MockMvc mockMvc;
    //Biblioteca para convertir objetos a JSON y viceversa
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    @DisplayName("Integration Test to post endpoint about Add New product.")
    public void testAddNewProductPostEndpoint() throws Exception {
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
                        "Computador para diseño"
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
}
