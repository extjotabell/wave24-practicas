package org.socialmeli.be_java_hisp_w24_g04.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Discount {
    @JsonProperty("discount_id")
    private Integer discountId;

    @JsonProperty("product_id")
    private Integer productId;

    private Double discount;
}
