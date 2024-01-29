package com.socialmeli.socialmeli.utils;

import com.socialmeli.socialmeli.dto.PostDto;
import com.socialmeli.socialmeli.dto.PostIdDto;
import com.socialmeli.socialmeli.dto.ProductDto;
import com.socialmeli.socialmeli.entities.Post;
import com.socialmeli.socialmeli.entities.Product;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class PostUtils {
    Post postId1 = new Post(1465,
            1,
            LocalDate.now().minusDays(7),
            new Product(1, "Silla Gamer", "Gamer", "Racer", "Red", "Special Edition"),
            100,
            1500.50);

    Post postId2 = new Post(1465,
            2,
            LocalDate.now().minusDays(13),
            new Product(1, "Headset RGB Inalámbrico", "Gamer", "Razer", "Green with RGB", "Sin Batería"),
            100,
            1500.50);

    Post postId7 = new Post(234,
            7,
            LocalDate.now().minusDays(2),
            new Product(7, "Mochila", "", "Everlast", "Blue", "Permite Notebook"),
            100,
            8000.50);

    PostDto postDtoId1 = new PostDto(1465,
            LocalDate.now().minusDays(7),
            new ProductDto(1, "Silla Gamer", "Gamer", "Racer", "Red", "Special Edition"),
            100,
            1500.50);

    PostDto postDtoId2 = new PostDto(1465,
            LocalDate.now().minusDays(13),
            new ProductDto(1, "Headset RGB Inalámbrico", "Gamer", "Razer", "Green with RGB", "Sin Batería"),
            100,
            1500.50);

    PostDto postDtoId7 = new PostDto(234,
            LocalDate.now().minusDays(2),
            new ProductDto(7, "Mochila", "", "Everlast", "Blue", "Permite Notebook"),
            100,
            8000.50);


    //Bonus

    PostIdDto postIdDto1 = new PostIdDto(1465, 1,
            LocalDate.of(2024,01,02),
            new ProductDto(
                    1,
                    "Silla Gamer",
                    "Gamer",
                    "Racer",
                    "Red",
                    "Special Edition"),
            100,
            1500.5);
    PostIdDto postIdDto2 = new PostIdDto(1465, 2,
            LocalDate.of(2023,12,30),
            new ProductDto(2,
                    "Headset RGB Inalámbrico",
                    "Gamer",
                    "Razer",
                    "Green with RGB",
                    "Sin Batería"),
            100,
            1500.5);
    PostIdDto postIdDto3 = new PostIdDto(1465, 3,
            LocalDate.of(2024,01,02),
            new ProductDto(2,
                    "MacBook Pro",
                    "Gamer",
                    "Apple",
                    "Gray",
                    "Microprocesador M1"),
            100,
            1500.5);
    PostIdDto postIdDto4 = new PostIdDto(4698,4,
            LocalDate.of(2024,01,15),
            new ProductDto( 2,
                    "Silla Oficina",
                    "Oficina",
                    "Oficina",
                    "Black",
                    "Special Edition"),
            300,
            10000.0);
    PostIdDto postIdDto5 = new PostIdDto(4698,5,
            LocalDate.of(2024,01,9),
            new ProductDto(5,
                    "Silla Gamer",
                    "Gamer",
                    "Racer",
                    "Red",
                    "Special Edition"),
            200,
            1500.5);
    PostIdDto postIdDto6 = new PostIdDto(4698,6,
            LocalDate.of(2024,01,03),
            new ProductDto(6,
                    "Gamer Stick",
                    "Gamer",
                    "Gadnic",
                    "Grey",
                    ""),
            100,
            500.5);
    PostIdDto postIdDto7 =  new PostIdDto(234, 7,
            LocalDate.of(2024,01,16),
            new ProductDto(7,
                    "Mochila",
                    "",
                    "Everlast",
                    "Blue",
                    "Permite Notebook"),
            100,
            8000.5);

    List<PostIdDto> postsListId = List.of(
            postIdDto1,
            postIdDto2,
            postIdDto3,
            postIdDto4,
            postIdDto5,
            postIdDto6,
            postIdDto7
    );
}
