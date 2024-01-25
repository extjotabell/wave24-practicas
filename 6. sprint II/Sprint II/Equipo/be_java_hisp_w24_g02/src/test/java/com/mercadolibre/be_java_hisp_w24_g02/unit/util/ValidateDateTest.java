package com.mercadolibre.be_java_hisp_w24_g02.unit.util;

import com.mercadolibre.be_java_hisp_w24_g02.exception.BadRequestException;
import com.mercadolibre.be_java_hisp_w24_g02.util.ValidateDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ValidateDateTest {
    @Test
    @DisplayName("Test invalid date static method")
    public void invalidDateStaticMethod() {
        // Arrange
        String dateIn = "invalid date";
        // Act - Assert
        Assertions.assertThrows(BadRequestException.class, () -> ValidateDate.validateDateString(dateIn, "dd-MM-yyyy"));
    }

    @Test
    @DisplayName("Test valid date static method")
    public void validDateStaticMethod() {
        // Arrange
        String dateIn = "01-01-2021";
        LocalDate dateOut = LocalDate.of(2021, 1, 1);
        // Act
        LocalDate result = ValidateDate.validateDateString(dateIn, "dd-MM-yyyy");
        // Assert
        Assertions.assertEquals(dateOut, result);
    }
}
