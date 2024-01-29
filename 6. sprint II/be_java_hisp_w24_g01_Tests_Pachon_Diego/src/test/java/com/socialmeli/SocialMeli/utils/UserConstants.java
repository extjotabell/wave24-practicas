package com.socialmeli.SocialMeli.utils;

import com.socialmeli.SocialMeli.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserConstants {

    public static final User USER1 = User.builder().id(101).name("Alice Johnson")
            .followed(new ArrayList<>(List.of(User.builder()
                            .id(104)
                            .name("David Williams").build(),
                    User.builder()
                            .id(105)
                            .name("Eva Martinez").build())))
            .followers(new ArrayList<>(List.of(User.builder()
                            .id(102)
                            .name("Bob Smith").build(),
                    User.builder()
                            .id(103)
                            .name("Charlie Brown").build()))).build();


    public static final User USER2 = User.builder().id(102).name("Bob Smith")
            .followed(new ArrayList<>(List.of(User.builder()
                            .id(106)
                            .name("Frank Wilson").build(),
                    User.builder()
                            .id(107)
                            .name("Grace Davis").build())))
            .followers(new ArrayList<>(List.of(User.builder()
                            .id(101)
                            .name("Alice Johnson").build(),
                    User.builder()
                            .id(103)
                            .name("Charlie Brown").build()))).build();

    public static final User USER3 = User.builder().id(103).name("Charlie Brown").build();
    public static final User USER4 = User.builder().id(104).name("David Williams")
            .followers(new ArrayList<>(List.of(User.builder()
                            .id(101)
                            .name("Alice Johnson").build()))).build();
    public static final User USER5 = User.builder().id(105).name("Eva Martinez").build();


}
