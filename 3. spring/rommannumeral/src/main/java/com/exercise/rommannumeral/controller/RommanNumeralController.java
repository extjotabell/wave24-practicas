package com.exercise.rommannumeral.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("romman-numeral")
public class RommanNumeralController {
    @GetMapping("/{number}")
    public String transformNumberToRomman(
            @PathVariable Integer number
    ){
        Map<Integer, String> rommanSymbols = new LinkedHashMap<>();
        rommanSymbols.put(1000, "M");
        rommanSymbols.put(900, "CM");
        rommanSymbols.put(500, "D");
        rommanSymbols.put(400, "CD");
        rommanSymbols.put(100, "C");
        rommanSymbols.put(90, "XC");
        rommanSymbols.put(50, "L");
        rommanSymbols.put(40, "XL");
        rommanSymbols.put(10, "X");
        rommanSymbols.put(9, "IX");
        rommanSymbols.put(5, "V");
        rommanSymbols.put(4, "IV");
        rommanSymbols.put(1, "I");

        StringBuilder rommanFinalNumber = new StringBuilder();

        for (Map.Entry<Integer, String> entry : rommanSymbols.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();

            while (number >= key) {
                rommanFinalNumber.append(value);
                number -= key;
            }
        }

        return rommanFinalNumber.toString();
    }
}
