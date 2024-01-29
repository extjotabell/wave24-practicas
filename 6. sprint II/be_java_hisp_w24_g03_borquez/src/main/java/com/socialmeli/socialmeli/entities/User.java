package com.socialmeli.socialmeli.entities;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class User {
    private Integer userId;
    private String userName;
    private List<User> followers;
    private List<User> followed;
}
