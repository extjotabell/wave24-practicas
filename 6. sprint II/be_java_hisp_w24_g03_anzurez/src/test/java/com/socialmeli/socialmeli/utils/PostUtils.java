package com.socialmeli.socialmeli.utils;

import com.socialmeli.socialmeli.dto.PostDto;
import com.socialmeli.socialmeli.dto.ProductDto;
import com.socialmeli.socialmeli.entities.Post;
import com.socialmeli.socialmeli.entities.Product;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PostUtils {
    Post postId1 = new Post(1465,
            1,
            LocalDate.now().minusDays(20),
            new Product(1, "Silla Gamer", "Gamer", "Racer", "Red", "Special Edition"),
            100,
            1500.50);

    Post postId2 = new Post(1465,
            2,
            LocalDate.now().minusDays(30),
            new Product(1, "Headset RGB Inalámbrico", "Gamer", "Razer", "Green with RGB", "Sin Batería"),
            100,
            1500.50);

    Post postId7 = new Post(234,
            7,
            LocalDate.now().minusDays(10),
            new Product(7, "Mochila", "", "Everlast", "Blue", "Permite Notebook"),
            100,
            8000.50);

    PostDto postDtoId1 = new PostDto(1465,
            LocalDate.now().minusDays(20),
            new ProductDto(1, "Silla Gamer", "Gamer", "Racer", "Red", "Special Edition"),
            100,
            1500.50);

    PostDto postDtoId2 = new PostDto(1465,
            LocalDate.now().minusDays(30),
            new ProductDto(1, "Headset RGB Inalámbrico", "Gamer", "Razer", "Green with RGB", "Sin Batería"),
            100,
            1500.50);

    PostDto postDtoId7 = new PostDto(234,
            LocalDate.now().minusDays(10),
            new ProductDto(7, "Mochila", "", "Everlast", "Blue", "Permite Notebook"),
            100,
            8000.50);


}
