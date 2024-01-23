package com.exercise.rommannumeral.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RommanNumeralServiceTest {
    private RommanNumeralService rommanNumeralService = new RommanNumeralService();

    @Test
    public void testConvertToRomanNumeral() {
        //Arrange
        Integer numberToConvert = 10;
        String expected = "X";

        //Act
        String romanNumeral = rommanNumeralService.transformNumberToRomman(numberToConvert);

        //Assert
        Assertions.assertEquals(expected, romanNumeral);
    }

    @Test
    public void testConvertNumberOneToI(){
        //Arrange
        Integer numberToConvert = 1;
        String expected = "I";

        //Act
        String romanNumeral = rommanNumeralService.transformNumberToRomman(numberToConvert);

        //Assert
        Assertions.assertEquals(expected, romanNumeral);
    }

    @Test
    public void testConvertNumberFiveToV(){
        //Arrange
        Integer numberToConvert = 5;
        String expected = "V";

        //Act
        String romanNumeral = rommanNumeralService.transformNumberToRomman(numberToConvert);

        //Assert
        Assertions.assertEquals(expected, romanNumeral);
    }


    @Test
    public void testConvertNumberThreeToIII(){
        //Arrange
        Integer numberToConvert = 3;
        String expected = "III";

        //Act
        String romanNumeral = rommanNumeralService.transformNumberToRomman(numberToConvert);

        //Assert
        Assertions.assertEquals(expected, romanNumeral);
    }

    @Test
    public void testConvertNumberFourToIV(){
        //Arrange
        Integer numberToConvert = 4;
        String expected = "IV";

        //Act
        String romanNumeral = rommanNumeralService.transformNumberToRomman(numberToConvert);

        //Assert
        Assertions.assertEquals(expected, romanNumeral);
    }

    @Test
    public void testConvertNumberNineToIX(){
        //Arrange
        Integer numberToConvert = 9;
        String expected = "IX";

        //Act
        String romanNumeral = rommanNumeralService.transformNumberToRomman(numberToConvert);

        //Assert
        Assertions.assertEquals(expected, romanNumeral);
    }

    @Test
    public void testConvertNumberFivetyToL(){
        //Arrange
        Integer numberToConvert = 50;
        String expected = "L";

        //Act
        String romanNumeral = rommanNumeralService.transformNumberToRomman(numberToConvert);

        //Assert
        Assertions.assertEquals(expected, romanNumeral);
    }
}
