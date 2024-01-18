package org.be_java_hisp_w24_g05.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

public record PostPromoDto(

        @NotNull(message = "User id is mandatory")
        @JsonProperty("user_id") Integer userId,

        @NotNull(message = "Date is mandatory")
        @NotEmpty(message = "Date is mandatory")
        String date,

        @NotNull(message = "Product is mandatory")
        ProductDto product,

        @NotNull(message = "Category is mandatory")
        Integer category,

        @NotNull(message = "Price is mandatory")
        Double price,
        Double discount,
        @JsonProperty("has_promo") Boolean hasPromo
) {
}