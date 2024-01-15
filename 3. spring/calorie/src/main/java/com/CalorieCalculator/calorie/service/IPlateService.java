package com.CalorieCalculator.calorie.service;

import com.CalorieCalculator.calorie.dto.PlateDTO;

public interface IPlateService {
    PlateDTO findByName(String name);
}
