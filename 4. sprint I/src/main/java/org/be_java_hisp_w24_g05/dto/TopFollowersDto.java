package org.be_java_hisp_w24_g05.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TopFollowersDto(
        Integer position,
        @JsonProperty("user_name") String userName,
        Integer followers

) {
}
