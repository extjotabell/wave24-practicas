package com.socialmeli.socialmeli.services;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.socialmeli.socialmeli.dto.*;
import com.socialmeli.socialmeli.entities.Post;
import com.socialmeli.socialmeli.entities.Product;
import com.socialmeli.socialmeli.entities.User;
import com.socialmeli.socialmeli.exceptions.BadRequestException;
import com.socialmeli.socialmeli.exceptions.NotFoundException;
import com.socialmeli.socialmeli.mapper.Mapper;
import com.socialmeli.socialmeli.repositories.PostRepositoryImpl;
import com.socialmeli.socialmeli.repositories.UserRepositoryImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
public class PostService implements IPostService{
    private final PostRepositoryImpl postRepository;

    private final Mapper mapper;
    private final UserRepositoryImpl userRepository;

    public PostService(PostRepositoryImpl postRepository, UserRepositoryImpl userRepository, Mapper mapper) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public List<PostIdDto> getAllPosts() {
        return this.postRepository.findAll().stream().map(mapper::convertPostToDtoWithId).toList();
    }

    @Override
    public PostIdDto save(PostDto postDto) {
        if(postDto.user_id() == null || postDto.date() == null || postDto.product() == null || postDto.category() == null
                || postDto.price() == null){
            throw new BadRequestException("Los datos ingresados no son correctos.");
        }
        User user = userRepository.findById(postDto.user_id()).orElse(null);
        if(Objects.isNull(user)){
            throw new BadRequestException("No existe el usuario con id: " + postDto.user_id());
        }
        Post post = mapper.convertDtoToPost(postDto);
        Integer postId = postRepository.findAll().stream().map(node -> node.getPostId()).max(Integer::compareTo).orElse(0);
        var postWithId = new Post(post.getUserId(), postId+1, post.getDate(), post.getProduct(), post.getCategory(), post.getPrice());
        var postList = postRepository.save(postWithId);
        return mapper.convertPostToDtoWithId(postList);
    }

    @Override
    public List<PostDto> getUserPosts(Integer userId){
        return this.postRepository.findAll().stream().filter(post -> post.getUserId().equals(userId)).map(mapper::convertPostToDto).toList();
    }


    @Override
    public UserFollowedPostsDto getLastTwoWeeksFollowedPosts(Integer userId, List<UserDto> followedList, String order){
        if(postRepository.findById(userId).isEmpty())
            throw new NotFoundException("No se encontraron post del usuario " + userId);

        List<PostDto> allFollowedPosts = new ArrayList<>();

        for (UserDto userDto : followedList){
            allFollowedPosts.addAll(this.getUserPosts(userDto.user_id()));
        }

        LocalDate currentDate = LocalDate.now();

        return new UserFollowedPostsDto(userId, sortLastFollowedPost(allFollowedPosts.stream().filter(post -> ChronoUnit.DAYS.between(post.date(),currentDate)<=14).toList(), order)) ;
    }
    public List<PostDto> sortLastFollowedPost(List<PostDto> posts, String order){
        if(order.equals("date_asc"))
            return posts.stream().sorted(Comparator.comparing(PostDto::date)).toList() ;
        if(order.equals("date_desc"))
            return posts.stream().sorted(Comparator.comparing(PostDto::date).reversed()).toList();

        throw new BadRequestException("Debe ingresar un orden valido, como name_asc o name_desc");
    }

    public PromoPostDto createPromoPost(PromoPostDto promoPostDto){

        if(promoPostDto.user_id() == null || promoPostDto.date() == null || promoPostDto.product() == null || promoPostDto.category() == null
                || promoPostDto.price() == null || promoPostDto.has_promo() == null || promoPostDto.discount() == null){
            throw new BadRequestException("Uno o más campos son nulos.");
        }
        if(!promoPostDto.has_promo() || promoPostDto.discount() == 0){
            throw new BadRequestException("El producto no está en promoción.");
        }
        User user = userRepository.findById(promoPostDto.user_id()).orElse(null);
        if(Objects.isNull(user)){
            throw new NotFoundException("No existe el usuario con id: " + promoPostDto.user_id());
        }

        Post post = mapper.convertDtoToPostPromo(promoPostDto);

        Integer postId = postRepository.findAll().stream().map(node -> node.getPostId()).max(Integer::compareTo).orElse(0);

        var postWithId = new Post(post.getUserId(), postId+1, post.getDate(), post.getProduct(), post.getCategory(), post.getPrice(), post.getHasPromo(), post.getDiscount());
        var postList = postRepository.save(postWithId);
        return promoPostDto;
    }
    public PromoPostCountDto getPromoPostCount(Integer userId){
        User user = userRepository.findById(userId).orElse(null);

        if(Objects.isNull(user)){
            throw new NotFoundException("No existe el usuario con id: " + userId);
        }
        List<Post> posts = postRepository.findAll().stream().filter(post -> post.getUserId().equals(userId)).filter(post -> post.getHasPromo()).toList();

        if(posts.size() == 0)
            throw new NotFoundException("No se encontraron post del usuario " + userId);

        return new PromoPostCountDto(userId, user.getUserName(),posts.size());
    }

}
