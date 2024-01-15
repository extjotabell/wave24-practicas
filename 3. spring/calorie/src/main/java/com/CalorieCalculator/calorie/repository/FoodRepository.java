package com.CalorieCalculator.calorie.repository;

import com.CalorieCalculator.calorie.entity.Food;
import com.CalorieCalculator.calorie.entity.Plate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class FoodRepository implements IFoodRepository{

    ArrayList<Food> foods;

    private ArrayList<Food> loadData() {
        ArrayList<Food> data = new ArrayList<>();
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        com.fasterxml.jackson.core.type.TypeReference<List<Food>> typeRef = new com.fasterxml.jackson.core.type.TypeReference<>() {
        };

        try {
            file = ResourceUtils.getFile("classpath:json/Food.json");

            try (FileInputStream fileInputStream = new FileInputStream(file);
                 BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)) {

                data = (ArrayList<Food>) objectMapper.readValue(bufferedInputStream, typeRef);
            } catch (IOException e) {
                // Manejo de la excepción o lanza una excepción personalizada si es apropiado para tu aplicación
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            // Manejo de la excepción o lanza una excepción personalizada si es apropiado para tu aplicación
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public Food findByName(String name) {
        return this.foods.stream()
                .filter(comida -> comida.getName().toLowerCase()
                        .contains(name.toLowerCase())).findFirst().orElse(null);
    }
    }
}
