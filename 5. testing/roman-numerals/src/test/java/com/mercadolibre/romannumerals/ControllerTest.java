package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ControllerTest {

    RomanNumeralsRestController romanNumeralsRestController = new RomanNumeralsRestController();

    @Test
    @DisplayName("toRoman: should return one")
    public void oneToRoman(){
        Integer number = 1;
        String expected  = "I";

        var result = romanNumeralsRestController.toRoman(number);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("toRoman: should return three")
    public void threeToRoman(){
        Integer number = 3;
        String expected  = "III";

        var result = romanNumeralsRestController.toRoman(number);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("toRoman: should return five")
    public void fiveToRoman(){
        Integer number = 5;
        String expected  = "V";

        var result = romanNumeralsRestController.toRoman(number);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("toRoman: should return seven")
    public void sevenToRoman(){
        Integer number = 7;
        String expected  = "VII";

        var result = romanNumeralsRestController.toRoman(number);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("toRoman: should return ten")
    public void tenToRoman(){
        Integer number = 10;
        String expected  = "X";

        var result = romanNumeralsRestController.toRoman(number);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("toRoman: should return fifty")
    public void fiftyToRoman(){
        Integer number = 50;
        String expected  = "L";

        var result = romanNumeralsRestController.toRoman(number);

        Assertions.assertEquals(expected, result);
    }

}
