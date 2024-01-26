package org.be_java_hisp_w24_g05.common;

import lombok.Getter;
import lombok.Setter;
import org.be_java_hisp_w24_g05.entity.Post;
import org.be_java_hisp_w24_g05.entity.Product;
import org.be_java_hisp_w24_g05.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Getter
@Setter
public class Data {

    private final List<Product> PRODUCTS = Arrays.asList(
            new Product(1, "Laptop", null, "BrandX", "Silver", "Note1"),
            new Product(2, "Phone", null, "BrandY", "Black", "Note2"),
            new Product(3, "Camera", null, "BrandZ", "Red", "Note3")
    );

    private final List<Post> POSTS = Arrays.asList(
            new Post(1, 1, LocalDate.now().minusDays(7), PRODUCTS.get(0),1, 100.0),
            new Post(2, 1, LocalDate.now().minusDays(12), PRODUCTS.get(1),2, 200.0),
            new Post(3, 2, LocalDate.now().minusDays(16), PRODUCTS.get(2),1, 150.0),
            new Post(4, 2, LocalDate.now().minusDays(27), PRODUCTS.get(0),2, 120.0),
            new Post(5, 3, LocalDate.now().minusDays(8), PRODUCTS.get(1),1, 180.0),
            new Post(6, 3, LocalDate.now().minusDays(4), PRODUCTS.get(2),2, 220.0),
            new Post(7, 4, LocalDate.now().minusDays(21), PRODUCTS.get(0),1, 130.0),
            new Post(8, 4, LocalDate.now().minusDays(17), PRODUCTS.get(1),2, 250.0)
    );

    private final List<User> FOLLOWED_BY_USER_1 = Arrays.asList(
            new User(2, "User2", new ArrayList<>(), new ArrayList<>(), List.of(POSTS.get(0),POSTS.get(1),POSTS.get(2))),
            new User(3, "User3", new ArrayList<>(), new ArrayList<>(), List.of(POSTS.get(3),POSTS.get(4)))
    );

    private final List<User> FOLLOWERS_BY_USER_1 = Arrays.asList(
            new User(2, "User2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()),
            new User(4, "User4", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()),
            new User(3, "User3", new ArrayList<>(), new ArrayList<>(), new ArrayList<>())
    );

    private final List<User> FOLLOWED_BY_USER_4 = Arrays.asList(
            new User(2, "User2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()),
            new User(3, "User3", new ArrayList<>(), new ArrayList<>(), new ArrayList<>())
    );
    private final List<User> FOLLOWERS_BY_USER_4 = Arrays.asList(
            new User(1, "User1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>())
    );
    private final User USER_1 = new User(1, "User1", FOLLOWERS_BY_USER_1, FOLLOWED_BY_USER_1, Arrays.asList(POSTS.get(0), POSTS.get(1)));
    private final User USER_2 = new User(2, "User2", new ArrayList<>(), new ArrayList<>(), Arrays.asList(POSTS.get(2), POSTS.get(3)));
    private final User USER_3 = new User(3, "User3", new ArrayList<>(), new ArrayList<>(), Arrays.asList(POSTS.get(4), POSTS.get(5)));
    private final User USER_4 = new User(4, "User4", FOLLOWERS_BY_USER_4, FOLLOWED_BY_USER_4, Arrays.asList(POSTS.get(6), POSTS.get(7)));

    public List<User> loadData() {
        return Arrays.asList(USER_1, USER_2, USER_3, USER_4);
    }
}
