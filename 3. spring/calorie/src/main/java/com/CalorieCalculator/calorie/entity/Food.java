package com.CalorieCalculator.calorie.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Food {
    public String name;
    public int calories;

}
