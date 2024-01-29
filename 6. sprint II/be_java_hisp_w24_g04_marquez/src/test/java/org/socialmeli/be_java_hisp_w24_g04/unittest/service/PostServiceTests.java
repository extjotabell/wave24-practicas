package org.socialmeli.be_java_hisp_w24_g04.unittest.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.socialmeli.be_java_hisp_w24_g04.dto.ProductDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserDTO;
import org.socialmeli.be_java_hisp_w24_g04.exception.BadRequestException;
import org.socialmeli.be_java_hisp_w24_g04.model.Post;
import org.socialmeli.be_java_hisp_w24_g04.model.Product;
import org.socialmeli.be_java_hisp_w24_g04.model.User;
import org.socialmeli.be_java_hisp_w24_g04.dto.PostDTO;
import org.socialmeli.be_java_hisp_w24_g04.repository.PostRepository;
import org.socialmeli.be_java_hisp_w24_g04.repository.UserRepository;
import org.socialmeli.be_java_hisp_w24_g04.service.PostService;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.List;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostServiceTests {

    @Mock
    PostRepository postRepository;

    @InjectMocks
    PostService postService;

    @Mock
    UserRepository userRepository;

    @Mock
    Clock clock;

    private User userWithId101;
    private User userWithId102;
    private List<PostDTO> expectedPostDTOFor102Asc;
    private List<Post> expectedPostFor102;
    private List<PostDTO> expectedPostDTOFor102Desc;
    private List<Post> expectedPostFor102DifferentDate;
    private List<PostDTO> expectedPostDTOFor102;


    @BeforeEach
    public void setUp() {
        Instant fixedInstant = Instant.parse("2024-01-27T00:00:00Z");
        when(clock.instant()).thenReturn(fixedInstant);
        when(clock.getZone()).thenReturn(ZoneId.systemDefault());

        UserDTO followedUserDTO = new UserDTO(102, "User2");
        userWithId101 = new User(101, "User1", Set.of(followedUserDTO), Set.of());
        UserDTO followerUserDTO102 = new UserDTO(103, "User3");
        UserDTO followedUsedDTO102 = new UserDTO(104, "User4");
        userWithId101 = new User(101, "User1", Set.of(followedUserDTO), Set.of());
        expectedPostDTOFor102Asc = List.of(
                new PostDTO(103,
                        4,
                        "2024-01-13",
                        new ProductDTO(4,
                                "Product 4",
                                "Electronics",
                                "ExampleBrand4",
                                "Black",
                                "Product notes 4"),
                        2,
                        39.99),
                new PostDTO(103,
                        5,
                        "2024-01-14",
                        new ProductDTO(5,
                                "Product 5",
                                "Clothing",
                                "ExampleBrand5",
                                "White",
                                "Product notes 5"),
                        1,
                        59.99),
                new PostDTO(103,
                        6,
                        "2024-01-15",
                        new ProductDTO(6,
                                "Product 6",
                                "Home",
                                "ExampleBrand6",
                                "Yellow",
                                "Product notes 6"),
                        1,
                        59.99)
        );

        userWithId102 = new User(102, "User2", Set.of(followerUserDTO102), Set.of(followedUsedDTO102));
        expectedPostFor102 = List.of(
                new Post(4,
                        103,
                        LocalDate.of(2024, 1, 13),
                        new Product(4,
                                "Product 4",
                                "Electronics",
                                "ExampleBrand4",
                                "Black",
                                "Product notes 4"),
                        2,
                        39.99),
                new Post(5,
                        103,
                        LocalDate.of(2024, 1, 14),
                        new Product(5,
                                "Product 5",
                                "Clothing",
                                "ExampleBrand5",
                                "White",
                                "Product notes 5"),
                        1,
                        59.99),
                new Post(6,
                        103,
                        LocalDate.of(2024, 1, 15),
                        new Product(6,
                                "Product 6",
                                "Home",
                                "ExampleBrand6",
                                "Yellow",
                                "Product notes 6"),
                        1,
                        59.99)
        );

        expectedPostDTOFor102Desc = List.of(
                new PostDTO(103,
                        6,
                        "2024-01-15",
                        new ProductDTO(6,
                                "Product 6",
                                "Home",
                                "ExampleBrand6",
                                "Yellow",
                                "Product notes 6"),
                        1,
                        59.99),
                new PostDTO(103,
                        5,
                        "2024-01-14",
                        new ProductDTO(5,
                                "Product 5",
                                "Clothing",
                                "ExampleBrand5",
                                "White",
                                "Product notes 5"),
                        1,
                        59.99),
                new PostDTO(103,
                        4,
                        "2024-01-13",
                        new ProductDTO(4,
                                "Product 4",
                                "Electronics",
                                "ExampleBrand4",
                                "Black",
                                "Product notes 4"),
                        2,
                        39.99)
        );

        expectedPostFor102DifferentDate = List.of(
                new Post(4,
                        103,
                        LocalDate.of(2024, 1, 2),
                        new Product(4,
                                "Product 4",
                                "Electronics",
                                "ExampleBrand4",
                                "Black",
                                "Product notes 4"),
                        2,
                        39.99),
                new Post(5,
                        103,
                        LocalDate.of(2024, 1, 14),
                        new Product(5,
                                "Product 5",
                                "Clothing",
                                "ExampleBrand5",
                                "White",
                                "Product notes 5"),
                        1,
                        59.99),
                new Post(6,
                        103,
                        LocalDate.of(2024, 1, 15),
                        new Product(6,
                                "Product 6",
                                "Home",
                                "ExampleBrand6",
                                "Yellow",
                                "Product notes 6"),
                        1,
                        59.99)
        );
        expectedPostDTOFor102 = List.of(
                new PostDTO(103,
                        5,
                        "2024-01-14",
                        new ProductDTO(5,
                                "Product 5",
                                "Clothing",
                                "ExampleBrand5",
                                "White",
                                "Product notes 5"),
                        1,
                        59.99),
                new PostDTO(103,
                        6,
                        "2024-01-15",
                        new ProductDTO(6,
                                "Product 6",
                                "Home",
                                "ExampleBrand6",
                                "Yellow",
                                "Product notes 6"),
                        1,
                        59.99)
        );
    }

    @Test
    @DisplayName("Test order by date asc")
    public void orderByDateAscTest() {

        String ascParam = "date_asc";

        Mockito.when(userRepository.get(101)).thenReturn(Optional.of(userWithId101));

        Assertions.assertDoesNotThrow(() -> postService.searchAllFollowedLastTwoWeeks(101, ascParam), "Param date_asc should not throw exception");

    }

    @Test
    @DisplayName("Test order by date desc")
    public void orderByDateDescTest() {

        String descParam = "date_desc";

        Mockito.when(userRepository.get(101)).thenReturn(Optional.of(userWithId101));

        Assertions.assertDoesNotThrow(() -> postService.searchAllFollowedLastTwoWeeks(101, descParam), "Param date_desc should not throw exception");

    }

    @Test
    @DisplayName("Test order by date empty param")
    public void orderByDateEmptyParamTest() {

        String emptyParam = null;

        Mockito.when(userRepository.get(101)).thenReturn(Optional.of(userWithId101));

        Assertions.assertDoesNotThrow(() -> postService.searchAllFollowedLastTwoWeeks(101, emptyParam), "Empty param should not throw exception");

    }

    @Test
    @DisplayName("Test order by date with unknown param")
    public void orderByDateWithUnknownParamTest() {

        String unknownParam = "any_param";

        Mockito.when(userRepository.get(101)).thenReturn(Optional.of(userWithId101));

        Assertions.assertThrows(
                BadRequestException.class,
                () -> postService.searchAllFollowedLastTwoWeeks(101, unknownParam), "Unknown param should throw exception");

    }


    @Test
    @DisplayName("Test order by date with date_asc")
    public void searchAllFollowedLastTwoWeeksTestAsc() {
        when(userRepository.get(102)).thenReturn(Optional.of(userWithId102));
        when(postRepository.findAll()).thenReturn(expectedPostFor102);
        List<PostDTO> currentPosts = postService.searchAllFollowedLastTwoWeeks(102, "date_asc");
        Assertions.assertEquals(expectedPostDTOFor102Asc, currentPosts);
    }

    @Test
    @DisplayName("Test order by date with date_desc")
    public void searchAllFollowedLastTwoWeeksTestDesc() {
        when(userRepository.get(102)).thenReturn(Optional.of(userWithId102));
        when(postRepository.findAll()).thenReturn(expectedPostFor102);
        List<PostDTO> currentPosts = postService.searchAllFollowedLastTwoWeeks(102, "date_desc");
        Assertions.assertEquals(expectedPostDTOFor102Desc, currentPosts);
    }

    @Test
    @DisplayName("Test return only last two weeks")
    public void searchAllFollowedLastTwoWeeksTestTwoWeeks() {
        when(userRepository.get(102)).thenReturn(Optional.of(userWithId102));
        when(postRepository.findAll()).thenReturn(expectedPostFor102DifferentDate);
        List<PostDTO> currentPosts = postService.searchAllFollowedLastTwoWeeks(102, null);
        Assertions.assertEquals(expectedPostDTOFor102, currentPosts);
    }


}
