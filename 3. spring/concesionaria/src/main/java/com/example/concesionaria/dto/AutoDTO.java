package com.example.concesionaria.dto;

import java.util.Date;
import java.util.Map;

public record AutoDTO(
        Integer id,
        String brand,
        String model,
        Date manufactoringDate,
        Integer numberOfKilometers,
        Integer doors,
        Double price,
        String currency,

        Integer  countOFOwners)
{
}
