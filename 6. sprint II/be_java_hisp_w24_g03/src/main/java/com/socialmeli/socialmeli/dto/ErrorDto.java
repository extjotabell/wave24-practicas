package com.socialmeli.socialmeli.dto;

import java.util.List;

public record ErrorDto(
        String explanation,
        List<String> messages
){
}