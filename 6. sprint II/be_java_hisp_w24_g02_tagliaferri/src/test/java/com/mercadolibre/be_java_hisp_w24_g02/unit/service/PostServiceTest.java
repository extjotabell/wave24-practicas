package com.mercadolibre.be_java_hisp_w24_g02.unit.service;

import com.mercadolibre.be_java_hisp_w24_g02.dto.CreatePostDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.CreateProductDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.PostDto;
import com.mercadolibre.be_java_hisp_w24_g02.dto.UserFollowedsPostsDTO;
import com.mercadolibre.be_java_hisp_w24_g02.entity.Post;
import com.mercadolibre.be_java_hisp_w24_g02.entity.Product;
import com.mercadolibre.be_java_hisp_w24_g02.entity.User;
import com.mercadolibre.be_java_hisp_w24_g02.exception.BadRequestException;
import com.mercadolibre.be_java_hisp_w24_g02.exception.NotFoundException;
import com.mercadolibre.be_java_hisp_w24_g02.repository.implementations.PostRepositoryImpl;
import com.mercadolibre.be_java_hisp_w24_g02.repository.implementations.UserRepositoryImpl;
import com.mercadolibre.be_java_hisp_w24_g02.service.implementations.PostServiceImpl;
import com.mercadolibre.be_java_hisp_w24_g02.util.ValidateDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @InjectMocks
    private PostServiceImpl service;

    @Mock
    private PostRepositoryImpl postRepository;

    @Mock
    private UserRepositoryImpl userRepository;

    @Test
    @DisplayName("Test tha verify the Last two weeks posts")
    public void lastTwoWeeksPostsTest() {
        // Arrange
        Integer userId = 1;
        User user = new User(1, "Usuario 1", new ArrayList<>(), new ArrayList<>(), List.of(3, 5, 6, 9), List.of(2,3));
        List<Post> posts = List.of(
                new Post(2,2, LocalDate.of(2024,1,24),
                new Product(
                1002,
                "Smartphone ABC",
                "Smartphone",
                "ABC",
                "Black",
                "Último modelo de smartphone con cámara de alta resolución"
                ),
                2, 799.99),
                new Post(3,3, LocalDate.of(2023,6,10),
                new Product(
                1003,
                "Cámara DSLR 123",
                "Cámara",
                "DSLR",
                "Black",
                "Cámara profesional para fotógrafos aficionados y profesionales"
                ),
                3,
                899.99));

        UserFollowedsPostsDTO postExpected = new UserFollowedsPostsDTO(1,
                List.of(new PostDto(2,2, LocalDate.of(2024,1,24),
                new Product(
                    1002,
                    "Smartphone ABC",
                    "Smartphone",
                    "ABC",
                    "Black",
                    "Último modelo de smartphone con cámara de alta resolución"
                ),
                2, 799.99)));
        // Act
        when(this.userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(this.postRepository.findAll()).thenReturn(posts);
        var result = this.service.getFollowedPost(userId);

        // Assert
        Assertions.assertEquals(postExpected, result);
    }

    @Test
    @DisplayName("Test tha Verify correct sorting by date, happy path ascending order")
    public void getFollowedPostVerifySortTestHappyPathDescendingOrder(){
        // Arrange
        User user = new User(1, "Usuario 1", new ArrayList<>(), new ArrayList<>(), List.of(3, 5, 6, 9), List.of(2,3));
        List<Post> posts = new ArrayList<>();
        Post post = new Post(1,1, LocalDate.of(2024,5,15),
                new Product(
                        1001,
                        "Laptop XYZ",
                        "Laptop",
                        "XYZ",
                        "Silver",
                        "Potente laptop para tareas exigentes"
                ),
                2, 1299.99);
        Post post2 = new Post(11,2, LocalDate.of(2024,1,20),
                new Product(
                        1010,
                        "Reproductor de Blu-ray XYZ",
                        "Reproductor de Blu-ray",
                        "XYZ",
                        "Black",
                        "Reproductor de Blu-ray 4K con funciones inteligentes"
                ),
                10, 129.99);
        Post post3 = new Post(11,3, LocalDate.of(2024,1,25),
                new Product(
                        1010,
                        "Altavoces ABC",
                        "Altavoces",
                        "XYZ",
                        "Black",
                        "Altavoces bluetooth de alta fidelidad"
                ),
                10, 129.99);
        posts.add(post);
        posts.add(post2);
        posts.add(post3);
        UserFollowedsPostsDTO expected = new UserFollowedsPostsDTO(
                post.getUserId(),
                new ArrayList<>(List.of(
                        new PostDto(post2.getPostId(), post2.getUserId(), post2.getDate(), post2.getProduct(), post2.getCategory(), post2.getPrice()),
                        new PostDto(post3.getPostId(), post3.getUserId(), post3.getDate(), post3.getProduct(), post3.getCategory(), post3.getPrice())
                ))
        );


        when(this.userRepository.findById(post.getPostId())).thenReturn(Optional.of(user));
        when(this.postRepository.findAll()).thenReturn(posts);

        // Act
        UserFollowedsPostsDTO result = this.service.getFollowedPost(user.getId(), "date_asc");

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test tha Verify correct sorting by date, happy path descending order")
    public void getFollowedPostVerifySortTestHappyPathAscendingOrder(){
        // Arrange
        User user = new User(1, "Usuario 1", new ArrayList<>(), new ArrayList<>(), List.of(3, 5, 6, 9), List.of(2,3));
        List<Post> posts = new ArrayList<>();
        Post post = new Post(1,1, LocalDate.of(2024,5,15),
                new Product(
                        1001,
                        "Laptop XYZ",
                        "Laptop",
                        "XYZ",
                        "Silver",
                        "Potente laptop para tareas exigentes"
                ),
                2, 1299.99);
        Post post2 = new Post(11,2, LocalDate.of(2024,1,20),
                new Product(
                        1010,
                        "Reproductor de Blu-ray XYZ",
                        "Reproductor de Blu-ray",
                        "XYZ",
                        "Black",
                        "Reproductor de Blu-ray 4K con funciones inteligentes"
                ),
                10, 129.99);
        Post post3 = new Post(11,3, LocalDate.of(2024,1,25),
                new Product(
                        1010,
                        "Altavoces ABC",
                        "Altavoces",
                        "XYZ",
                        "Black",
                        "Altavoces bluetooth de alta fidelidad"
                ),
                10, 129.99);
        posts.add(post);
        posts.add(post2);
        posts.add(post3);
        UserFollowedsPostsDTO expected = new UserFollowedsPostsDTO(
                post.getUserId(),
                new ArrayList<>(List.of(
                        new PostDto(post3.getPostId(), post3.getUserId(), post3.getDate(), post3.getProduct(), post3.getCategory(), post3.getPrice()),
                        new PostDto(post2.getPostId(), post2.getUserId(), post2.getDate(), post2.getProduct(), post2.getCategory(), post2.getPrice())
                ))
        );


        when(this.userRepository.findById(post.getPostId())).thenReturn(Optional.of(user));
        when(this.postRepository.findAll()).thenReturn(posts);

        // Act
        UserFollowedsPostsDTO result = this.service.getFollowedPost(user.getId(), "date_desc");

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test get followed post by user id not found exception")
    public void getFollowedPostByUserIdNotFoundException(){
        // Arrange
        Integer userIdIn = 1;


        when(this.userRepository.findById(userIdIn)).thenReturn(Optional.empty());

        // Act - Assert
        Assertions.assertThrows(NotFoundException.class, () -> this.service.getFollowedPost(userIdIn, "date_asc"));
    }

    @Test
    @DisplayName("Test get followed post by user id null not found exception")
    public void getFollowedPostByUserIdNullNotFoundException(){
        // Arrange
        Integer userIdIn = null;

        // Act - Assert
        Assertions.assertThrows(NotFoundException.class, () -> this.service.getFollowedPost(userIdIn, "date_asc"));
    }

    @Test
    @DisplayName("Test get followed post by user id invalid order")
    public void getFollowedPostInvalidOrder(){
        // Arrange
        Integer userIdIn = 1;

        // Act - Assert
        Assertions.assertThrows(BadRequestException.class, () -> this.service.getFollowedPost(userIdIn, "algo"));
    }

    @Test
    @DisplayName("Test get followed post by user id order none, happy path")
    public void getFollowedPostByUserIdOrderNone(){
        // Arrange
        User user = new User(1, "Usuario 1", new ArrayList<>(), new ArrayList<>(), List.of(3, 5, 6, 9), List.of(2,3));
        List<Post> posts = new ArrayList<>();
        Post post = new Post(1,1, LocalDate.of(2024,5,15),
                new Product(
                        1001,
                        "Laptop XYZ",
                        "Laptop",
                        "XYZ",
                        "Silver",
                        "Potente laptop para tareas exigentes"
                ),
                2, 1299.99);
        Post post2 = new Post(11,2, LocalDate.of(2024,1,20),
                new Product(
                        1010,
                        "Reproductor de Blu-ray XYZ",
                        "Reproductor de Blu-ray",
                        "XYZ",
                        "Black",
                        "Reproductor de Blu-ray 4K con funciones inteligentes"
                ),
                10, 129.99);
        Post post3 = new Post(11,3, LocalDate.of(2024,1,25),
                new Product(
                        1010,
                        "Altavoces ABC",
                        "Altavoces",
                        "XYZ",
                        "Black",
                        "Altavoces bluetooth de alta fidelidad"
                ),
                10, 129.99);
        posts.add(post);
        posts.add(post2);
        posts.add(post3);
        UserFollowedsPostsDTO expected = new UserFollowedsPostsDTO(
                post.getUserId(),
                new ArrayList<>(List.of(
                        new PostDto(post2.getPostId(), post2.getUserId(), post2.getDate(), post2.getProduct(), post2.getCategory(), post2.getPrice()),
                        new PostDto(post3.getPostId(), post3.getUserId(), post3.getDate(), post3.getProduct(), post3.getCategory(), post3.getPrice())
                ))
        );


        when(this.userRepository.findById(post.getPostId())).thenReturn(Optional.of(user));
        when(this.postRepository.findAll()).thenReturn(posts);

        // Act
        UserFollowedsPostsDTO result = this.service.getFollowedPost(user.getId(), "none");

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test create product post with invalid user id")
    public void createProductPostWithInvalidUserId(){
        // Arrange
        CreatePostDTO createPostIn = new CreatePostDTO(
                1,
                "2024-01-25",
                new CreateProductDTO(
                        1001,
                     "Laptop XYZ",
                            "Laptop",
                            "XYZ",
                            "Silver",
                            "Potente laptop para tareas exigentes"
                ),
                2,
                1299.99
                );



        when(this.userRepository.findById(createPostIn.userId())).thenReturn(Optional.empty());

        // Act
        // Assert
        Assertions.assertThrows(NotFoundException.class, () -> this.service.createProductPost(createPostIn));
    }

    @Test
    @DisplayName("Test create product post happy path")
    public void createProductPostHappyPath() {
        // Arrange
        CreatePostDTO createPostIn = new CreatePostDTO(
                1,
                "25-01-2024",
                new CreateProductDTO(
                        1001,
                        "Laptop XYZ",
                        "Laptop",
                        "XYZ",
                        "Silver",
                        "Potente laptop para tareas exigentes"
                ),
                2,
                1299.99
        );
        User user = new User(1, "Usuario 1", new ArrayList<>(), new ArrayList<>(), List.of(3, 5, 6, 9), List.of(2,3));

        when(this.userRepository.findById(createPostIn.userId())).thenReturn(Optional.of(user));
        when(this.postRepository.save(Mockito.any(Post.class))).thenReturn(new Post());
        // Act - Assert
        Assertions.assertDoesNotThrow(() -> this.service.createProductPost(createPostIn));
    }
}
