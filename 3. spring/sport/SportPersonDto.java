package com.example.sport;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SportPersonDto {
    private final String name;
    private final String lastName;
    private final String sport;
}