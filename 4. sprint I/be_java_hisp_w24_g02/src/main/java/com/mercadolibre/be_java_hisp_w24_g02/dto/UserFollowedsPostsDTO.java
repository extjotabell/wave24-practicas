package com.mercadolibre.be_java_hisp_w24_g02.dto;


import java.util.List;

public record UserFollowedsPostsDTO(
        Integer userId,
        List<PostDto> posts
) {
}
