package org.numberapi.romantodecimalapi.romanToDecimal;

import java.util.Arrays;
import java.util.List;

public class RomanToDecimal {
    private Integer getDecimal(Character c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    public Integer convert(String romanNum) {
        int castedValue = 0;
        int lastValue = 0;
        int repeatCharacterCount = 0;

        for (Character c : romanNum.toCharArray()) {
            var value = getDecimal(c);

            if (lastValue >= value && value > 0)
                castedValue += value;
            else if (lastValue < value) {
                castedValue += (value - (lastValue * 2));
            }

            if (lastValue == value)
                repeatCharacterCount++;
            else
                repeatCharacterCount = 0;

            lastValue = value;
        }

        return repeatCharacterCount < 3 ? castedValue : -1;
    }
}
