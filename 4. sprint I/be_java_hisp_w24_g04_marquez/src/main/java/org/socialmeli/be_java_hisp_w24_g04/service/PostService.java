package org.socialmeli.be_java_hisp_w24_g04.service;

import org.socialmeli.be_java_hisp_w24_g04.dto.*;
import org.socialmeli.be_java_hisp_w24_g04.exception.BadRequestException;
import org.socialmeli.be_java_hisp_w24_g04.exception.InvalidTimeException;
import org.socialmeli.be_java_hisp_w24_g04.exception.NotFoundException;
import org.socialmeli.be_java_hisp_w24_g04.model.Post;
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
        findUserId(userPost);
        int postId = getPostId();
        LocalDate dt = getLocalDate(userPost);

        productRepository.save(userPost.product());
        postRepository.save(new Post(
                postId,
                userPost.user_id(),
                dt,
                userPost.product(),
                userPost.category(),
                userPost.price()
        ));

        return userPost;
    }

    private static <T extends IUserPost> LocalDate getLocalDate(T userPost) {
        LocalDate dt;
        DateTimeFormatter dateFormat;

        try {
            dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            dt = LocalDate.parse(userPost.getDate(), dateFormat);
        } catch (Exception e) {
            throw new InvalidTimeException("Invalid date format. It should be dd-MM-yyyy");
        }
        return dt;
    }

    private int getPostId() {
        var posts = postRepository.findAll();
        var postId = 0;

        if (posts != null)
            postId = posts.size() + 1;
        return postId;
    }

    private <T extends IUserPost> void findUserId(T userPost) {
        var idFound = userRepository
                .findAll()
                .stream()
                .filter(user -> user.getUserId().equals(userPost.getUser_id()))
                .findFirst()
                .orElse(null);

        if (idFound == null)
            throw new BadRequestException("Couldn't create user's post. Please, try again with a valid" +
                    " user ID.");
    }

    @Override
    public UserPromoPostDTO createUserPromoPost(UserPromoPostDTO userPost) {
        findUserId(userPost);
        int postId = getPostId();
        LocalDate dt = getLocalDate(userPost);
        productRepository.save(userPost.product());
        postRepository.save(new Post(
                postId,
                userPost.user_id(),
                dt,
                userPost.product(),
                userPost.category(),
                userPost.price(),
                userPost.has_promo(),
                userPost.discount()
        ));
        return userPost;
    }

    @Override
    public List<PostDTO> searchAllFollowedLastTwoWeeks(Integer userId, String order) {
        List<PostDTO> foundPosts = new ArrayList<>();
        LocalDate dateNow = LocalDate.now();
        var user = userRepository.get(userId);

        if (user.isEmpty())
            throw new NotFoundException("User not found.");

        try{
            user.get().getFollowed().forEach(followed -> {
                postRepository.findAll().stream().filter(post -> post.getUserId().equals(followed.user_id()) && (ChronoUnit.DAYS.between(post.getDate(),dateNow) <= 14)).forEach(post -> {
                    PostDTO postDTO = new PostDTO(
                            post.getUserId(),
                            post.getPostId(),
                            post.getDate().toString(),
                            post.getProduct(),
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
            if(order.equals("date_asc")) {
                foundPosts.sort(Comparator.comparing(PostDTO::date));
            } else if (order.equals("date_desc")) {
                foundPosts.sort(Comparator.comparing(PostDTO::date).reversed());
            } else {
                throw new BadRequestException("Order must be date_asc or date_desc");
            }

        return foundPosts;
    }

    @Override
    public UserPromoPostCountDTO countUserPromoPost(Integer userId) {
        Integer count = 0;
        var user = userRepository.get(userId);

        if (user.isEmpty())
            throw new NotFoundException("User not found.");

        try{
            count = postRepository.findAll().stream().filter(post -> post.getUserId().equals(userId) && post.isHas_promo()).toList().size();
        } catch (Exception e) {
            throw new NotFoundException("User not found");
        }

        UserPromoPostCountDTO promoPostsCount = new UserPromoPostCountDTO(
                user.get().getUserId(),
                user.get().getUsername(),
                count
        );
        return promoPostsCount;
    }

    @Override
    public List<PostDTO> findPromoPostCategory(Integer category, String order){
        List<PostDTO> foundPosts = new ArrayList<>();

        try{
            postRepository.findAll().stream().filter(post -> post.getCategory().equals(category) && post.isHas_promo()).forEach(post -> {
                PostDTO postDTO = new PostDTO(
                        post.getUserId(),
                        post.getPostId(),
                        post.getDate().toString(),
                        post.getProduct(),
                        post.getCategory(),
                        post.getPrice()
                );
                foundPosts.add(postDTO);
            });
        } catch (Exception e) {
            throw new NotFoundException("Category not found");
        }

        if (order != null)
            if(order.equals("name_asc")) {
                foundPosts.sort(Comparator.comparing(postDTO -> postDTO.product().getName()));
            } else if (order.equals("name_desc")) {
                foundPosts.stream().sorted((p1, p2) -> p2.product().getName().compareTo(p1.product().getName()));
                //foundPosts.sort(Comparator.comparing(postDTO -> postDTO.product().getName()));
            } else {
                throw new BadRequestException("Order must be name_asc or name_desc");
            }

        return foundPosts;
    }
}
