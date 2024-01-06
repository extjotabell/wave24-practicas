package org.numeroromano.numeroromano.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/romanNumbers")
public class RomanNumbersController {
    public Map<String, Integer> map = new LinkedHashMap<>();

    public RomanNumbersController() {
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);
    }
    @GetMapping("/{decimal}")
    public String convertDecimalToRoman(@PathVariable Integer decimal) {
        if (decimal < 1 || decimal > 3999) {
            return "The number must be between 1 and 3999";
        }
        StringBuilder result = new StringBuilder();
        int number = decimal;
        while(number > 0){
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (number >= entry.getValue()) {
                    number -= entry.getValue();
                    result.append(entry.getKey());
                    break;
                }
            }
        }
        return result.toString();
    }
}
