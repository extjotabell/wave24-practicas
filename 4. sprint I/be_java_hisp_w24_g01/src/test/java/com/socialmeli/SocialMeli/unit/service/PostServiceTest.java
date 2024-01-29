package com.socialmeli.SocialMeli.unit.service;

import com.socialmeli.SocialMeli.dto.requestDTO.CategoryPostRequestDTO;
import com.socialmeli.SocialMeli.dto.requestDTO.ProductPostRequestDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.LastestPostDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.PostWithIdDTO;
import com.socialmeli.SocialMeli.entity.Category;
import com.socialmeli.SocialMeli.entity.Post;
import com.socialmeli.SocialMeli.entity.Product;
import com.socialmeli.SocialMeli.entity.User;
import com.socialmeli.SocialMeli.exception.OrderNotFoundException;
import com.socialmeli.SocialMeli.repository.interfaces.ICategoryRepository;
import com.socialmeli.SocialMeli.repository.interfaces.IPostRepository;
import com.socialmeli.SocialMeli.repository.interfaces.IProductRepository;
import com.socialmeli.SocialMeli.repository.interfaces.IUserRepository;
import com.socialmeli.SocialMeli.service.implementations.PostService;
import com.socialmeli.SocialMeli.exception.EmptyListException;
import com.socialmeli.SocialMeli.repository.implementations.CategoryRepository;
import com.socialmeli.SocialMeli.repository.implementations.PostRepository;
import com.socialmeli.SocialMeli.repository.implementations.ProductRepository;
import com.socialmeli.SocialMeli.repository.implementations.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import org.mockito.Mockito;
import java.util.Collections;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @Mock
    private IPostRepository postRepository;
    @Mock
    private IProductRepository productRepository;
    @Mock
    private ICategoryRepository categoryRepository;
    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private PostService postService;

  
    private static LastestPostDTO lastestPostDTO = new LastestPostDTO(
          101,
          List.of(new PostWithIdDTO(
                  104,
                  301,
                  LocalDate.of(2024, 1,20),
                  new ProductPostRequestDTO(
                          201,
                          "Smartphone",
                          "Electronics",
                          "Samsung",
                          "Black",
                          "6.5-inch display, 128GB storage"
                  ),
                  new CategoryPostRequestDTO(
                          1,
                          "Electronics"
                  ),
                  799.99
          ))
    );

    private static Post post1 = new Post(
            301,
            104,
            LocalDate.of(2024, 1,20),
            new Product(
                    201,
                    "Smartphone",
                    "Electronics",
                    "Samsung",
                    "Black",
                    "6.5-inch display, 128GB storage"
            ),
            new Category(
                    1,
                    "Electronics"
            ),
            799.99
    );
  
    private final ProductPostRequestDTO productPostRequestDTOId204 = new ProductPostRequestDTO(
            204,
            "Wireless Earbuds",
            "Electronics",
            "Apple",
            "White",
            "Active noise cancellation, sweat-resistant"
    );
    private final ProductPostRequestDTO productPostRequestDTOId205 = new ProductPostRequestDTO(
            205,
            "Backpack",
            "Outdoor",
            "Patagonia",
            "Green",
            "Durable and water-resistant"
    );
    private final CategoryPostRequestDTO categoryPostRequestDTOId3 = new CategoryPostRequestDTO(
            3,
            "Appliances"
    );
    private final PostWithIdDTO postWithIdDTOId304 = new PostWithIdDTO(
            104,
            304,
            LocalDate.now().minusDays(12),
            productPostRequestDTOId204,
            categoryPostRequestDTOId3,
            149.99
    );
    private final PostWithIdDTO postWithIdDTOId305 = new PostWithIdDTO(
            105,
            305,
            LocalDate.now().minusDays(5),
            productPostRequestDTOId205,
            categoryPostRequestDTOId3,
            89.99
    );
    private final Product productId204 = new Product(
            204,
            "Wireless Earbuds",
            "Electronics",
            "Apple",
            "White",
            "Active noise cancellation, sweat-resistant"
    );
    private final Category categoryId3 = new Category(
            3,
            "Appliances"
    );
    private final Post postId304 = new Post(
            304,
            104,
            LocalDate.now().minusDays(12),
            productId204,
            categoryId3,
            149.99
    );

    private final Product productId205 = new Product(
            205,
            "Backpack",
            "Outdoor",
            "Patagonia",
            "Green",
            "Durable and water-resistant"
    );
    private final Post postId305 = new Post(
            305,
            105,
            LocalDate.now().minusDays(5),
            productId205,
            categoryId3,
            89.99
    );

    private final User userId101 = User.builder().id(101).name("Alice Johnson").followed(
            List.of(
                    User.builder().id(104).name("David Williams").build(),
                    User.builder().id(105).name("Eva Martinez").build()
            )
    ).build();
  
    @Test
    @DisplayName("T-0005 - Order not found")
    void orderNotFoundTest(){
        //Arrange
        String incorrectOrder = "price_asc";
        Integer userId = 101;
        //Act & Assert
        assertThrows(OrderNotFoundException.class, () -> postService.getLastestPost(userId, incorrectOrder));
    }
    @Test
    @DisplayName("T-0006-desc - Get latest posts order by date desc")
    void getLatestPostsOrderByDateDescTest(){
        //Arrange
        String order = "date_desc";
        Integer userId = 101;
        LastestPostDTO expectedDTO = new LastestPostDTO(
                101,
                List.of(postWithIdDTOId305, postWithIdDTOId304)
        );
        List<Post> postListUser104 = List.of(postId304);
        List<Post> postListUser105 = List.of(postId305);
        //Act
        when(userRepository.findById(userId)).thenReturn(Optional.of(userId101));
        when(postRepository.getAllPostsById(104)).thenReturn(postListUser104);
        when(postRepository.getAllPostsById(105)).thenReturn(postListUser105);
        when(productRepository.findByIdOrCreate(productPostRequestDTOId204)).thenReturn(productId204);
        when(productRepository.findByIdOrCreate(productPostRequestDTOId205)).thenReturn(productId205);
        when(categoryRepository.findByIdOrCreate(categoryPostRequestDTOId3)).thenReturn(categoryId3);
        LastestPostDTO lastestPostDTO = postService.getLastestPost(userId, order);
        //Assert
        assertEquals(expectedDTO, lastestPostDTO, "The latest posts should be ordered by date desc");
    }

    @Test
    @DisplayName("T-0006-asc - Get latest posts order by date asc")
    void getLatestPostsOrderByDateAscTest(){
        //Arrange
        String order = "date_asc";
        Integer userId = 101;
        LastestPostDTO expectedDTO = new LastestPostDTO(
                101,
                List.of(postWithIdDTOId304, postWithIdDTOId305)
        );
        List<Post> postListUser104 = List.of(postId304);
        List<Post> postListUser105 = List.of(postId305);
        //Act
        when(userRepository.findById(userId)).thenReturn(Optional.of(userId101));
        when(postRepository.getAllPostsById(104)).thenReturn(postListUser104);
        when(postRepository.getAllPostsById(105)).thenReturn(postListUser105);
        when(productRepository.findByIdOrCreate(productPostRequestDTOId204)).thenReturn(productId204);
        when(productRepository.findByIdOrCreate(productPostRequestDTOId205)).thenReturn(productId205);
        when(categoryRepository.findByIdOrCreate(categoryPostRequestDTOId3)).thenReturn(categoryId3);
        LastestPostDTO lastestPostDTO = postService.getLastestPost(userId, order);
        //Assert
        assertEquals(expectedDTO, lastestPostDTO, "The latest posts should be ordered by date asc");
    }

    @Test
    @DisplayName("T-0006 - Get latest posts with no order should use default 'DESC'")
    void getLatestPostsTest(){
        //Arrange
        Integer userId = 101;
        LastestPostDTO expectedDTO = new LastestPostDTO(
                101,
                List.of(postWithIdDTOId305, postWithIdDTOId304)
        );
        List<Post> postListUser104 = List.of(postId304);
        List<Post> postListUser105 = List.of(postId305);
        //Act
        when(userRepository.findById(userId)).thenReturn(Optional.of(userId101));
        when(postRepository.getAllPostsById(104)).thenReturn(postListUser104);
        when(postRepository.getAllPostsById(105)).thenReturn(postListUser105);
        when(productRepository.findByIdOrCreate(productPostRequestDTOId204)).thenReturn(productId204);
        when(productRepository.findByIdOrCreate(productPostRequestDTOId205)).thenReturn(productId205);
        when(categoryRepository.findByIdOrCreate(categoryPostRequestDTOId3)).thenReturn(categoryId3);
        LastestPostDTO lastestPostDTO = postService.getLastestPost(userId, null);
        //Assert
        assertEquals(expectedDTO, lastestPostDTO, "The latest posts should be ordered by default (DESC)");
    }
  
    @Test
    @DisplayName("Given a userId and return a list of posts those are from the last two weeks")
    public void testGetLastestPostHappyPath() {
        //Arrange
        Integer userId = 101;
        LastestPostDTO expected = lastestPostDTO;

        //Act
        //when - then return
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of( User.builder().id(userId).followed(List.of(User.builder().id(104).build())).build()));
        Mockito.when(postRepository.getAllPostsById(104)).thenReturn(List.of( post1));
        Mockito.when(categoryRepository.findByIdOrCreate(new CategoryPostRequestDTO(1, "Electronics"))).thenReturn(new Category(1, "Electronics"));
        Mockito.when(productRepository.findByIdOrCreate(new ProductPostRequestDTO(201,
                "Smartphone",
                "Electronics",
                "Samsung",
                "Black",
                "6.5-inch display, 128GB storage"))).thenReturn(new Product(201,
                "Smartphone",
                "Electronics",
                "Samsung",
                "Black",
                "6.5-inch display, 128GB storage"));

        LastestPostDTO result = postService.getLastestPost(userId, "date_desc");

        //Assert
        Assertions.assertEquals(expected, result, "The lists are not the same");
    }

    @Test
    @DisplayName("No posts found from the last two weeks")
    public void testGetLastestPostEmptyListException() {
        //Arrange
        Integer userId = 101;

        //Act
        //when - then return
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of( User.builder().id(userId).followed(List.of(User.builder().id(104).build())).build()));
        Mockito.when(postRepository.getAllPostsById(104)).thenReturn(Collections.emptyList());

        //Assert
        Assertions.assertThrows(
                EmptyListException.class,
                () -> postService.getLastestPost(userId, "date_desc")
        );
    }
}
