package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsRestControllerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void toRoman() {
        Assertions.assertEquals("I", new RomanNumeralsRestController().toRoman(1));
    }

    @Test
    void toRomanX() {
        Assertions.assertEquals("X", new RomanNumeralsRestController().toRoman(10));
    }

    @Test
    void toRomanVII() {
        Assertions.assertEquals("VII", new RomanNumeralsRestController().toRoman(7));
    }

    @Test
    void toRomanXV() {
        Assertions.assertEquals("XV", new RomanNumeralsRestController().toRoman(15));
    }

    @Test
    void toRomanException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new RomanNumeralsRestController().toRoman(0));
    }
}