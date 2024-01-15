package com.CalorieCalculator.calorie.repository;

import com.CalorieCalculator.calorie.entity.Plate;

import java.util.ArrayList;

public interface IPlateRepository {

    ArrayList<Plate> findByName(String name);
}
