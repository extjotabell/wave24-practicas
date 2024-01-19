package com.mercadolibre.be_java_hisp_w24_g02.util;

import com.mercadolibre.be_java_hisp_w24_g02.exception.BadRequestException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ValidateDate {


    /**
     * This method validate if the date is valid
     * @param date
     * @param format
     * @return LocalDate
     * */
    public static LocalDate validateDateString(String date, String format){
        try {
            DateTimeFormatter formatDate = DateTimeFormatter.ofPattern(format);
            return LocalDate.parse(date, formatDate);
        } catch (Exception e){
            throw new BadRequestException("Format date is not valid");
        }
    }
}
