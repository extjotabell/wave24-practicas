package com.socialmeli.SocialMeli.unit.service;

import com.socialmeli.SocialMeli.dto.requestDTO.CategoryPostRequestDTO;
import com.socialmeli.SocialMeli.dto.requestDTO.ProductPostRequestDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.LastestPostDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.PostWithIdDTO;
import com.socialmeli.SocialMeli.entity.Post;
import com.socialmeli.SocialMeli.entity.User;
import com.socialmeli.SocialMeli.exception.OrderNotFoundException;
import com.socialmeli.SocialMeli.repository.interfaces.ICategoryRepository;
import com.socialmeli.SocialMeli.repository.interfaces.IPostRepository;
import com.socialmeli.SocialMeli.repository.interfaces.IProductRepository;
import com.socialmeli.SocialMeli.repository.interfaces.IUserRepository;
import com.socialmeli.SocialMeli.service.implementations.PostService;
import com.socialmeli.SocialMeli.exception.EmptyListException;
import com.socialmeli.SocialMeli.utils.CategoryConstants;
import com.socialmeli.SocialMeli.utils.PostConstants;
import com.socialmeli.SocialMeli.utils.ProductConstants;
import com.socialmeli.SocialMeli.utils.UserConstants;
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

  
    private static final LastestPostDTO lastestPostDTO = new LastestPostDTO(
          101,
          List.of(new PostWithIdDTO(
                  104,
                  301,
                  LocalDate.now().minusDays(6),
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

  
    @Test
    @DisplayName("T-0005 - Order not found")
    void orderNotFoundTest(){
        //Arrange
        String incorrectOrder = "price_asc";
        Integer userId = 101;
        //Act & Assert
        assertThrows(OrderNotFoundException.class, () -> postService.getLatestPost(userId, incorrectOrder));
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
        List<Post> postListUser104 = List.of(PostConstants.POST304);
        List<Post> postListUser105 = List.of(PostConstants.POST305);
        //Act
        when(userRepository.findById(userId)).thenReturn(Optional.of(UserConstants.USER1));
        when(postRepository.getAllPostsById(104)).thenReturn(postListUser104);
        when(postRepository.getAllPostsById(105)).thenReturn(postListUser105);
        when(productRepository.findByIdOrCreate(productPostRequestDTOId204)).thenReturn(ProductConstants.PRODUCT204);
        when(productRepository.findByIdOrCreate(productPostRequestDTOId205)).thenReturn(ProductConstants.PRODUCT205);
        when(categoryRepository.findByIdOrCreate(categoryPostRequestDTOId3)).thenReturn(CategoryConstants.CATEGORY3);
        LastestPostDTO lastestPostDTO = postService.getLatestPost(userId, order);
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
        List<Post> postListUser104 = List.of(PostConstants.POST304);
        List<Post> postListUser105 = List.of(PostConstants.POST305);
        //Act
        when(userRepository.findById(userId)).thenReturn(Optional.of(UserConstants.USER1));
        when(postRepository.getAllPostsById(104)).thenReturn(postListUser104);
        when(postRepository.getAllPostsById(105)).thenReturn(postListUser105);
        when(productRepository.findByIdOrCreate(productPostRequestDTOId204)).thenReturn(ProductConstants.PRODUCT204);
        when(productRepository.findByIdOrCreate(productPostRequestDTOId205)).thenReturn(ProductConstants.PRODUCT205);
        when(categoryRepository.findByIdOrCreate(categoryPostRequestDTOId3)).thenReturn(CategoryConstants.CATEGORY3);
        LastestPostDTO lastestPostDTO = postService.getLatestPost(userId, order);
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
        List<Post> postListUser104 = List.of(PostConstants.POST304);
        List<Post> postListUser105 = List.of(PostConstants.POST305);
        //Act
        when(userRepository.findById(userId)).thenReturn(Optional.of(UserConstants.USER1));
        when(postRepository.getAllPostsById(104)).thenReturn(postListUser104);
        when(postRepository.getAllPostsById(105)).thenReturn(postListUser105);
        when(productRepository.findByIdOrCreate(productPostRequestDTOId204)).thenReturn(ProductConstants.PRODUCT204);
        when(productRepository.findByIdOrCreate(productPostRequestDTOId205)).thenReturn(ProductConstants.PRODUCT205);
        when(categoryRepository.findByIdOrCreate(categoryPostRequestDTOId3)).thenReturn(CategoryConstants.CATEGORY3);
        LastestPostDTO lastestPostDTO = postService.getLatestPost(userId, null);
        //Assert
        assertEquals(expectedDTO, lastestPostDTO, "The latest posts should be ordered by default (DESC)");
    }
  
    @Test
    @DisplayName("Given a userId and return a list of posts those are from the last two weeks")
    public void testGetLatestPostHappyPath() {
        //Arrange
        Integer userId = 101;

        //Act
        //when - then return
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of( User.builder().id(userId).followed(List.of(User.builder().id(104).build())).build()));
        Mockito.when(postRepository.getAllPostsById(104)).thenReturn(List.of(PostConstants.POST301));
        Mockito.when(categoryRepository.findByIdOrCreate(new CategoryPostRequestDTO(1, "Electronics"))).thenReturn(CategoryConstants.CATEGORY1);
        Mockito.when(productRepository.findByIdOrCreate(new ProductPostRequestDTO(201,
                "Smartphone",
                "Electronics",
                "Samsung",
                "Black",
                "6.5-inch display, 128GB storage"))).thenReturn(ProductConstants.PRODUCT201);

        LastestPostDTO result = postService.getLatestPost(userId, "date_desc");

        //Assert
        Assertions.assertEquals(lastestPostDTO, result, "The lists are not the same");
    }

    @Test
    @DisplayName("No posts found from the last two weeks")
    public void testGetLatestPostEmptyListException() {
        //Arrange
        Integer userId = 101;

        //Act
        //when - then return
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of( User.builder().id(userId).followed(List.of(User.builder().id(104).build())).build()));
        Mockito.when(postRepository.getAllPostsById(104)).thenReturn(Collections.emptyList());

        //Assert
        Assertions.assertThrows(
                EmptyListException.class,
                () -> postService.getLatestPost(userId, "date_desc")
        );
    }
}
