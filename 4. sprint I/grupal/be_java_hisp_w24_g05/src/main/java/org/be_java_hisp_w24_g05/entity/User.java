package org.be_java_hisp_w24_g05.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userId;

    private String userName;

    private List<User> followers;

    private List<User> followed;

    private List<Post> posts;

}
