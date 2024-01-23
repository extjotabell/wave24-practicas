package com.mercadolibre.romannumerals.unit.controller;

import com.mercadolibre.romannumerals.RomanNumeralsRestController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RomanNumeralsRestControllerTest {

    private RomanNumeralsRestController romanNumeralsRestController = new RomanNumeralsRestController();


    private void toRomanTest(Integer number, String expected) {

        //act
        String result = romanNumeralsRestController.toRoman(number);

        //assert
        Assertions.assertEquals(expected, result, "The number can't be converted to roman numerals");
    }
    @Test
    @DisplayName("Test that validated the conversion of number 1 to roman numerals")
    public void toRomanOneTest() {
        toRomanTest(1, "I");
    }

    @Test
    @DisplayName("Test that validated the conversion of number 3 to roman numerals")
    public void toRomanThreeTest() {
        toRomanTest(3, "III");
    }

    @Test
    @DisplayName("Test that validated the conversion of number 5 to roman numerals")
    public void toRomanFiveTest() {
        toRomanTest(5, "V");
    }

    @Test
    @DisplayName("Test that validated the conversion of number 7 to roman numerals")
    public void toRomanSevenTest() {
        toRomanTest(7, "VII");
    }

    @Test
    @DisplayName("Test that validated the conversion of number 10 to roman numerals")
    public void toRomanTenTest() {
        toRomanTest(10, "X");
    }

    @Test
    @DisplayName("Test that validated the conversion of number 50 to roman numerals")
    public void toRomanFiftyTest() {
        toRomanTest(50, "L");
    }
}
