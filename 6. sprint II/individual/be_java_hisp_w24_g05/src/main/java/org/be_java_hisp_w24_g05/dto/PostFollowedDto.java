package org.be_java_hisp_w24_g05.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.be_java_hisp_w24_g05.entity.Post;

import java.util.List;


public record PostFollowedDto (
    @JsonProperty("user_id")
    Integer userId,
    List<Post> posts
){}
