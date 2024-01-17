package org.be_java_hisp_w24_g05.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("user_name")
    private String userName;

}
