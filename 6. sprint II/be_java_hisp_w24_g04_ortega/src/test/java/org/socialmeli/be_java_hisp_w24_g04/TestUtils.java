package org.socialmeli.be_java_hisp_w24_g04;

import org.socialmeli.be_java_hisp_w24_g04.dto.*;

import java.util.List;
import java.util.Set;

public class TestUtils {

    public static UserFollowersDTO getUserFollowersDTO() {
        Set<UserDTO> followers = Set.of(
                new UserDTO(101, "User1"),
                new UserDTO(103, "User3")
        );
        return new UserFollowersDTO(102, "User2", followers);
    }

    public static UserFollowersDTO getUserFollowersDTODesc() {
        Set<UserDTO> followers = Set.of(
                new UserDTO(103, "User3"),
                new UserDTO(101, "User1")
        );
        return new UserFollowersDTO(102, "User2", followers);
    }

    public static UserFollowedDTO getUserFollowedDTO() {
        Set<UserDTO> followed = Set.of(
                new UserDTO(103, "User3"),
                new UserDTO(104, "User4")
        );
        return new UserFollowedDTO(102, "User2", followed);
    }

    public static UserFollowedDTO getUserFollowedDTODesc() {
        Set<UserDTO> followed = Set.of(
                new UserDTO(104, "User4"),
                new UserDTO(103, "User3")
        );
        return new UserFollowedDTO(102, "User2", followed);
    }

    public static UserFollowerCountDTO getUserFollowerCountDTO() {
        return new UserFollowerCountDTO(102, "User2", 2);
    }

    public static List<PostDTO> getPostDTOList() {
        return List.of(
                new PostDTO(104,
                        7,
                        "2024-01-16",
                        new ProductDTO(
                                7,
                                "Product 7",
                                "Electronics",
                                "Product notes 7",
                                "ExampleBrand7",
                                "Purple"
                        ),
                        1,
                        69.99
                ),
                new PostDTO(104,
                        8,
                        "2024-01-17",
                        new ProductDTO(
                                8,
                                "Product 8",
                                "Clothing",
                                "Product notes 8",
                                "ExampleBrand8",
                                "Brown"
                        ),
                        2,
                        49.99
                )
        );
    }

    public static List<PostDTO> getPostDTOListDesc() {
        return List.of(
                new PostDTO(104,
                        8,
                        "2024-01-17",
                        new ProductDTO(
                                8,
                                "Product 8",
                                "Clothing",
                                "Product notes 8",
                                "ExampleBrand8",
                                "Brown"
                        ),
                        2,
                        49.99
                ),
                new PostDTO(104,
                        7,
                        "2024-01-16",
                        new ProductDTO(
                                7,
                                "Product 7",
                                "Electronics",
                                "Product notes 7",
                                "ExampleBrand7",
                                "Purple"
                        ),
                        1,
                        69.99
                )
        );
    }

    public static UserPostDTO getUserPostDTO() {
        ProductDTO product = new ProductDTO(1, "Silla Gamer", "Gamer", "Racer", "Black", "Special Edition");
        return new UserPostDTO(101, "15-01-2024", product, 100, 1500.50);
    }

    public static UserPostDTO getBlankInvalidUserPostDTO() {
        ProductDTO product = new ProductDTO(null, null, null, null, null, null);
        return new UserPostDTO(null, "", product, null, null);
    }

    public static UserPostDTO getPatternInvalidUserPostDTO() {
        ProductDTO product = new ProductDTO(1, "&&&", "&&&", "&&&", "&&&", "&&&");
        return new UserPostDTO(101, "15-01-2024", product, 100, 1500.50);
    }


    public static UserPostDTO getSizeInvalidUserPostDTO() {
        ProductDTO product = new ProductDTO(1, "a".repeat(61), "a".repeat(16), "a".repeat(16), "a".repeat(26), "a".repeat(16));
        return new UserPostDTO(101, "15-01-2024", product, 100, 1500.50);
    }

    public static UserPostDTO getUserIdInvalidUserPostDTO() {
        ProductDTO product = new ProductDTO(1, "Silla Gamer", "Gamer", "Racer", "Black", "Special Edition");
        return new UserPostDTO(-1, "15-01-2024", product, 100, 1500.50);
    }

    public static UserPostDTO getDateFormatInvalidUserPostDTO() {
        ProductDTO product = new ProductDTO(1, "Silla Gamer", "Gamer", "Racer", "Black", "Special Edition");
        return new UserPostDTO(101, "01-15-2024", product, 100, 1500.50);
    }

    public static UserPostDTO getPriceInvalidUserPostDTO() {
        ProductDTO product = new ProductDTO(1, "Silla Gamer", "Gamer", "Racer", "Black", "Special Edition");
        return new UserPostDTO(101, "15-01-2024", product, 100, 10000001.00);
    }

}
