package org.socialmeli.be_java_hisp_w24_g04.service;

import org.socialmeli.be_java_hisp_w24_g04.dto.PostDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.PromoPostCountDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserPostDTO;
import org.socialmeli.be_java_hisp_w24_g04.exception.BadRequestException;
import org.socialmeli.be_java_hisp_w24_g04.exception.InvalidTimeException;
import org.socialmeli.be_java_hisp_w24_g04.exception.NotFoundException;
import org.socialmeli.be_java_hisp_w24_g04.model.Post;
import org.socialmeli.be_java_hisp_w24_g04.model.PromoPost;
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
        var idFound = userRepository
                .findAll()
                .stream()
                .filter(user -> user.getUserId().equals(userPost.user_id()))
                .findFirst()
                .orElse(null);

        if (idFound == null)
            throw new BadRequestException("Couldn't create user's post. Please, try again with a valid" +
                    " user ID.");

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

        Post newPost = userPost.has_promo() != null ?
                new PromoPost(
                        postId,
                        userPost.user_id(),
                        dt,
                        userPost.product(),
                        userPost.category(),
                        userPost.price(),
                        userPost.has_promo(),
                        userPost.discount()
                ) :
                new Post(
                        postId,
                        userPost.user_id(),
                        dt,
                        userPost.product(),
                        userPost.category(),
                        userPost.price()
                );

        productRepository.save(userPost.product());
        postRepository.save(newPost);

        return new UserPostDTO(newPost);
    }

    @Override
    public PromoPostCountDTO getPromoPostsCount(Integer userId) {
        var user = userRepository.get(userId);
        if (user.isEmpty())
            throw new NotFoundException("User not found.");

        List<Post> foundPosts = postRepository
                .findAll()
                .stream()
                .filter(post -> post.getUserId().equals(userId) && post instanceof PromoPost)
                .toList();

        return new PromoPostCountDTO(
                user.get().getUserId(),
                user.get().getUsername(),
                foundPosts.size()
        );
    }

    @Override
    public List<PostDTO> searchAllFollowedLastTwoWeeks(Integer userId, String order) {
        List<PostDTO> foundPosts = new ArrayList<>();
        LocalDate dateNow = LocalDate.now();
        var user = userRepository.get(userId);

        if (user.isEmpty())
            throw new NotFoundException("User not found.");

        try {
            user.get().getFollowed().forEach(followed -> {
                postRepository.findAll().stream()
                        .filter(post -> post.getUserId().equals(followed.user_id()) && (ChronoUnit.DAYS.between(post.getDate(), dateNow) <= 14))
                        .forEach(post -> {
                            if (post instanceof PromoPost)
                                foundPosts.add(new PostDTO((PromoPost) post));
                            else
                                foundPosts.add(new PostDTO(post));
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

    @Override
    public PostDTO updatePost(Integer postId, UserPostDTO newPostData) {
        Post post = postRepository.get(postId).orElseThrow(() -> new NotFoundException("Post not found"));
        post.setCategory(newPostData.category());
        post.setPrice(newPostData.price());
        post.setProduct(newPostData.product());
        post.setDate(LocalDate.now());

        if (newPostData.has_promo() != null) {
            PromoPost promoPost = new PromoPost(
                    post.getPostId(),
                    post.getUserId(),
                    post.getDate(),
                    post.getProduct(),
                    post.getCategory(),
                    post.getPrice(),
                    newPostData.has_promo(),
                    newPostData.discount()
            );

            postRepository.update(promoPost);
            return new PostDTO(promoPost);
        } else {
            postRepository.update(post);
            return new PostDTO(post);
        }
    }
}
