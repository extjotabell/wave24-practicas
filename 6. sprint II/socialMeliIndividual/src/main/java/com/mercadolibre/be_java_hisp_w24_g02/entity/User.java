package com.mercadolibre.be_java_hisp_w24_g02.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    private Integer id;
    private String name;
    private List<User> followers = new ArrayList<>();
    private List<User> followed = new ArrayList<>();
    private List<Post> favorites = new ArrayList<>();
    
    private List<Integer> followersIds = new ArrayList<>();
    private List<Integer> followedIds = new ArrayList<>();

    public User(Integer id, String name, List<User> followers, List<User> followed, List<Integer> followersIds, List<Integer> followedIds) {
        this.id = id;
        this.name = name;
        this.followers = followers;
        this.followed = followed;
        this.followersIds = followersIds;
        this.followedIds = followedIds;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", followers=" + followers +
                ", followed=" + followed +
                ", followersIds=" + followersIds +
                ", followedIds=" + followedIds +
                '}';
    }
}
