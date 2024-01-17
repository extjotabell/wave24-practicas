package org.be_java_hisp_w24_g05.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto{
        @JsonProperty("user_id") Integer userId;
        String date;
        ProductDto product;
        Integer category;
        Double price;
}
