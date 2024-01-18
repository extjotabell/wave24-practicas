package org.be_java_hisp_w24_g05.dto;



import com.fasterxml.jackson.annotation.JsonProperty;





public record PostDto(
        @JsonProperty("user_id") Integer userId,
        String date,
        ProductDto product,
        Integer category,
        Double price
){}
