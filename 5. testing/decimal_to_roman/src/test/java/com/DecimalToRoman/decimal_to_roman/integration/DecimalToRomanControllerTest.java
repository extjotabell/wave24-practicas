package com.DecimalToRoman.decimal_to_roman.integration;

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

@SpringBootTest
@AutoConfigureMockMvc
public class DecimalToRomanControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void toRomanTestHappyPath() throws Exception {
        //Arrange
        Integer param = 69;
        //paso 1 - Construir request
        RequestBuilder request = MockMvcRequestBuilders.get("/convertToRoman/{number}", param);
        //paso 2 - Construir statusExpected
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        //paso 3 - Construir bodyExpected
        String expected = "LXIX";
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().string(expected);
        //paso 4 - Construir contentTypeExpected
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.TEXT_PLAIN+ ";charset=UTF-8");

        //ActAndAssert
        //ejecutamos la peticion y comparamos el resultado con el esperado
        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(bodyExpected)
                .andExpect(contentTypeExpected)
                .andDo(MockMvcResultHandlers.print());
    }

}
