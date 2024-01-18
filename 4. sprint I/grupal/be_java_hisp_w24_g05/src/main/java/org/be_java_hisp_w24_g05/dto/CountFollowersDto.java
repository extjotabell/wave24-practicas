package org.be_java_hisp_w24_g05.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CountFollowersDto(
        @JsonProperty("user_id")
        Integer userId,

        @JsonProperty("user_name")
        String userName,

        @JsonProperty("followers_count")
        Integer followersCount
){
}
