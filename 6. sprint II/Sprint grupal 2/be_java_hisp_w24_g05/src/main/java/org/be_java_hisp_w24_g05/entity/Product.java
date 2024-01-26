package org.be_java_hisp_w24_g05.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @JsonProperty("product_id")
    private int productId;

    @JsonProperty("product_name")
    private String productName;

    private String type;

    private String brand;

    private String color;

    private String notes;
}
