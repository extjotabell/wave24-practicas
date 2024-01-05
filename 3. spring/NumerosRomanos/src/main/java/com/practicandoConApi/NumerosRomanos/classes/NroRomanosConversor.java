package com.practicandoConApi.NumerosRomanos.classes;

public class NroRomanosConversor {
    private static final int[] decimales = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] simbolosRomanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String convertirAromano(int decimal){

        if (decimal <= 0 || decimal >= 4000) {
            throw new IllegalArgumentException("El numero decimal debe estar entre los numeros 1 y 3999");
        }

        StringBuilder romano = new StringBuilder();
        int resta = decimal;

        for (int i = 0; i < decimales.length; i++) {
            while (resta >= decimales[i]) {
                romano.append(simbolosRomanos[i]);
                resta -= decimales[i];
            }
        }

        return romano.toString();
    }
}
