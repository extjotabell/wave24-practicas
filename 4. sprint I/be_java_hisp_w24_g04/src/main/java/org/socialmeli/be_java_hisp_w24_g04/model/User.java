package org.socialmeli.be_java_hisp_w24_g04.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserDTO;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("user_name")
    private String username;
    private Set<UserDTO> followed;
    private Set<UserDTO> followers;
    private List<Post> posts;
}
