package org.be_java_hisp_w24_g05.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostDto extends PostDto {
        @JsonProperty("has_promo") Boolean hasPromo;
        Double discount;
}
