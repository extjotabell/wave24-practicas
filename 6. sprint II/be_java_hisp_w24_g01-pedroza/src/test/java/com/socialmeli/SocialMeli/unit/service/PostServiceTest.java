package com.socialmeli.SocialMeli.unit.service;

import com.socialmeli.SocialMeli.dto.requestDTO.CategoryPostRequestDTO;
import com.socialmeli.SocialMeli.dto.requestDTO.PostRequestDTO;
import com.socialmeli.SocialMeli.dto.requestDTO.ProductPostRequestDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.LastestPostDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.PostResponseDTO;
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

  
    private static LastestPostDTO lastestPostDTO = new LastestPostDTO(
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
        List<Post> postListUser104 = List.of(PostConstants.POST304);
        List<Post> postListUser105 = List.of(PostConstants.POST305);
        //Act
        when(userRepository.findById(userId)).thenReturn(Optional.of(UserConstants.USER1));
        when(postRepository.getAllPostsById(104)).thenReturn(postListUser104);
        when(postRepository.getAllPostsById(105)).thenReturn(postListUser105);
        when(productRepository.findByIdOrCreate(productPostRequestDTOId204)).thenReturn(ProductConstants.PRODUCT204);
        when(productRepository.findByIdOrCreate(productPostRequestDTOId205)).thenReturn(ProductConstants.PRODUCT205);
        when(categoryRepository.findByIdOrCreate(categoryPostRequestDTOId3)).thenReturn(CategoryConstants.CATEGORY3);
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
        List<Post> postListUser104 = List.of(PostConstants.POST304);
        List<Post> postListUser105 = List.of(PostConstants.POST305);
        //Act
        when(userRepository.findById(userId)).thenReturn(Optional.of(UserConstants.USER1));
        when(postRepository.getAllPostsById(104)).thenReturn(postListUser104);
        when(postRepository.getAllPostsById(105)).thenReturn(postListUser105);
        when(productRepository.findByIdOrCreate(productPostRequestDTOId204)).thenReturn(ProductConstants.PRODUCT204);
        when(productRepository.findByIdOrCreate(productPostRequestDTOId205)).thenReturn(ProductConstants.PRODUCT205);
        when(categoryRepository.findByIdOrCreate(categoryPostRequestDTOId3)).thenReturn(CategoryConstants.CATEGORY3);
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
        List<Post> postListUser104 = List.of(PostConstants.POST304);
        List<Post> postListUser105 = List.of(PostConstants.POST305);
        //Act
        when(userRepository.findById(userId)).thenReturn(Optional.of(UserConstants.USER1));
        when(postRepository.getAllPostsById(104)).thenReturn(postListUser104);
        when(postRepository.getAllPostsById(105)).thenReturn(postListUser105);
        when(productRepository.findByIdOrCreate(productPostRequestDTOId204)).thenReturn(ProductConstants.PRODUCT204);
        when(productRepository.findByIdOrCreate(productPostRequestDTOId205)).thenReturn(ProductConstants.PRODUCT205);
        when(categoryRepository.findByIdOrCreate(categoryPostRequestDTOId3)).thenReturn(CategoryConstants.CATEGORY3);
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
        Mockito.when(postRepository.getAllPostsById(104)).thenReturn(List.of(PostConstants.POST301));
        Mockito.when(categoryRepository.findByIdOrCreate(new CategoryPostRequestDTO(1, "Electronics"))).thenReturn(CategoryConstants.CATEGORY1);
        Mockito.when(productRepository.findByIdOrCreate(new ProductPostRequestDTO(201,
                "Smartphone",
                "Electronics",
                "Samsung",
                "Black",
                "6.5-inch display, 128GB storage"))).thenReturn(ProductConstants.PRODUCT201);

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


    @Test
    @DisplayName("Create post test ")
    public void testCreatePost() {

        //Arrange

        //Arrive to service
        PostRequestDTO postRequestDTO = new PostRequestDTO(
                105,
                LocalDate.now().minusDays(5),
                new ProductPostRequestDTO(
                        205,
                        "Backpack",
                        "Outdoor",
                        "Patagonia",
                        "Green",
                        "Durable and water-resistant"
                ),
                new CategoryPostRequestDTO(
                        3,
                        "Appliances"
                ),
                89.99

        );
        PostResponseDTO postResponseDTO = new PostResponseDTO(
                305,
                105,
                String.valueOf(LocalDate.now().minusDays(5)),
                205,
                "Backpack",
                3,
                "Appliances",
                89.99);


        //Act
        when(userRepository.userExists(postRequestDTO.user_id())).thenReturn(true); //user exists
        when(productRepository.findByIdOrCreate(postRequestDTO.product())).thenReturn(ProductConstants.PRODUCT205);
        when(categoryRepository.findByIdOrCreate(postRequestDTO.category())).thenReturn(CategoryConstants.CATEGORY3);
        when(postRepository.findLastId()).thenReturn(304); //last id
        when(postRepository.create(PostConstants.POST305)).thenReturn(PostConstants.POST305); //create post

        var result = postService.createPost(postRequestDTO);

        assertEquals( postResponseDTO, result, "The post should be created");

    }

}
