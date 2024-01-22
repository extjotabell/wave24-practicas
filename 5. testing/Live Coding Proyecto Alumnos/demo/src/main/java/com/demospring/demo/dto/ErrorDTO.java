package com.demospring.demo.dto;

import java.util.List;

public record ErrorDTO(
        String explanation,
        List<String> messages
){
}
