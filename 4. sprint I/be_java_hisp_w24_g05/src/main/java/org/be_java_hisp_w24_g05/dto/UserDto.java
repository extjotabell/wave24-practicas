package org.be_java_hisp_w24_g05.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.be_java_hisp_w24_g05.entity.User;

import java.util.List;

public record UserDto(
        @JsonProperty("user_id") Integer userId,
        @JsonProperty("user_name") String userName
) {
}

