package org.numberapi.romantodecimalapi.controller;

import org.numberapi.romantodecimalapi.romanToDecimal.RomanToDecimal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanToDecimalController {
    @GetMapping
    public String initialMsg() {
        return "Hi!, you can cast to decimal number just creating a new route with the number to cast. Remember not to create subroutes.";
    }

    @GetMapping("/{number}")
    public String convertRomanToDecimal(@PathVariable String number) {
        var castedValue = new RomanToDecimal().convert(number);

        return String.valueOf(castedValue > -1 ? castedValue : "You are repeating characters. Remember to not repeat them more than 3 times. Example: Right: III => 3; Wrong: IIII => 4 -> IV");
    }
}
