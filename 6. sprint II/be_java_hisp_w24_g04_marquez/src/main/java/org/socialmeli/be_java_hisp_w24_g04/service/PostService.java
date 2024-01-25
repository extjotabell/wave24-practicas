package org.socialmeli.be_java_hisp_w24_g04.service;

import org.socialmeli.be_java_hisp_w24_g04.dto.PostDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.ProductDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserPostDTO;
import org.socialmeli.be_java_hisp_w24_g04.exception.BadRequestException;
import org.socialmeli.be_java_hisp_w24_g04.exception.InvalidTimeException;
import org.socialmeli.be_java_hisp_w24_g04.exception.NotFoundException;
import org.socialmeli.be_java_hisp_w24_g04.model.Post;
import org.socialmeli.be_java_hisp_w24_g04.model.User;
import org.socialmeli.be_java_hisp_w24_g04.model.Product;
import org.socialmeli.be_java_hisp_w24_g04.repository.IPostRepository;
import org.socialmeli.be_java_hisp_w24_g04.repository.IProductRepository;
import org.socialmeli.be_java_hisp_w24_g04.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PostService implements IPostService {
    private final IPostRepository postRepository;
    private final IUserRepository userRepository;
    private final IProductRepository productRepository;

    @Autowired
    public PostService(
            IPostRepository postRepository,
            IUserRepository userRepository,
            IProductRepository productRepository
    ) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public UserPostDTO createUserPost(UserPostDTO userPost) {
        userRepository.get(userPost.user_id()).orElseThrow(
                () -> new BadRequestException("Couldn't create user's post. Please, try again with a valid user ID.")
        );

        var posts = postRepository.findAll();
        var postId = 0;

        if (posts != null)
            postId = posts.size() + 1;

        LocalDate dt;
        DateTimeFormatter dateFormat;

        try {
            dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            dt = LocalDate.parse(userPost.date(), dateFormat);
        } catch (Exception e) {
            throw new InvalidTimeException("Invalid date format. It should be dd-MM-yyyy");
        }

        var productToSave = new Product(
                userPost.product().product_id(),
                userPost.product().product_name(),
                userPost.product().type(),
                userPost.product().brand(),
                userPost.product().color(),
                userPost.product().notes()
        );

        productRepository.save(productToSave);
        postRepository.save(new Post(
                postId,
                userPost.user_id(),
                dt,
                productToSave,
                userPost.category(),
                userPost.price()
        ));

        return userPost;
    }

    @Override
    public List<PostDTO> searchAllFollowedLastTwoWeeks(Integer userId, String order) {
        List<PostDTO> foundPosts = new ArrayList<>();
        LocalDate dateNow = LocalDate.now();
        User user = userRepository.get(userId).orElseThrow(() -> new NotFoundException("User not found."));

        try {
            user.getFollowed().forEach(followed -> {
                postRepository.findAll().stream().filter(
                        post -> post.getUserId().equals(followed.user_id()) &&
                                (ChronoUnit.DAYS.between(post.getDate(), dateNow) <= 14)).forEach(post -> {
                    PostDTO postDTO = new PostDTO(
                            post.getUserId(),
                            post.getPostId(),
                            post.getDate().toString(),
                            new ProductDTO(
                                    post.getProduct().getProductId(),
                                    post.getProduct().getName(),
                                    post.getProduct().getType(),
                                    post.getProduct().getBrand(),
                                    post.getProduct().getColor(),
                                    post.getProduct().getNotes()
                            ),
                            post.getCategory(),
                            post.getPrice()
                    );
                    foundPosts.add(postDTO);
                });
            });
        } catch (Exception e) {
            throw new NotFoundException("User not found");
        }

        if (order != null)
            if (order.equals("date_asc")) {
                foundPosts.sort(Comparator.comparing(PostDTO::date));
            } else if (order.equals("date_desc")) {
                foundPosts.sort(Comparator.comparing(PostDTO::date).reversed());
            } else {
                throw new BadRequestException("Order must be date_asc or date_desc");
            }

        return foundPosts;
    }
}
