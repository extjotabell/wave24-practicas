package com.socialmeli.SocialMeli.utils;

import com.socialmeli.SocialMeli.entity.Post;

import java.time.LocalDate;

public class PostConstants {

    public static final Post POST305 = new Post(
            305,
            105,
            LocalDate.now().minusDays(5),
            ProductConstants.PRODUCT205,
            CategoryConstants.CATEGORY3,
            89.99
    );

    public static final Post POST304 = new Post(
            304,
            104,
            LocalDate.now().minusDays(12),
            ProductConstants.PRODUCT204,
            CategoryConstants.CATEGORY3,
            149.99
    );

    public static final Post POST301 = new Post(
            301,
            104,
            LocalDate.now().minusDays(6),
            ProductConstants.PRODUCT201,
            CategoryConstants.CATEGORY1,
            799.99
    );
}
