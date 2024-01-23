package com.exercise.rommannumeral.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class RommanNumeralControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Test get roman numeral")
    public void testGetRomanNumeral() throws Exception {
        // Arrange
        String expectedNumber = "X";
        String inNumber = "10";
        String uriTemplate = "/romman-numeral/" + inNumber;
        RequestBuilder request = MockMvcRequestBuilders.get(uriTemplate);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentExpected = MockMvcResultMatchers.content().string(expectedNumber);
        // Act - Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)
                .andExpect(contentExpected);
    }

    @Test
    @DisplayName("Test get roman numeral with invalid number")
    public void testGetRommanNumeralWithInvalidNumber() throws Exception {
        // Arrange
        String inNumber = "0";
        String uriTemplate = "/romman-numeral/" + inNumber;
        RequestBuilder request = MockMvcRequestBuilders.get(uriTemplate);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        // Act - Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected);
    }
}
