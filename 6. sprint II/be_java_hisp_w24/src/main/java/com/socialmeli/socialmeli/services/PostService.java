package com.socialmeli.socialmeli.services;

import com.socialmeli.socialmeli.dto.*;
import com.socialmeli.socialmeli.entities.Post;
import com.socialmeli.socialmeli.entities.User;
import com.socialmeli.socialmeli.exceptions.BadRequestException;
import com.socialmeli.socialmeli.exceptions.NotFoundException;
import com.socialmeli.socialmeli.mapper.Mapper;
import com.socialmeli.socialmeli.repositories.PostRepositoryImpl;
import com.socialmeli.socialmeli.repositories.UserRepositoryImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

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
        if(postDto.userId() == null || postDto.date() == null || postDto.product() == null || postDto.category() == null
                || postDto.price() == null){
            throw new BadRequestException("Los datos ingresados no son correctos.");
        }
        User user = userRepository.findById(postDto.userId()).orElse(null);
        if(Objects.isNull(user)){
            throw new BadRequestException("No existe el usuario con id: " + postDto.userId());
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
        if(followedList.isEmpty()){
            throw new NotFoundException("El usuario " + userId + " no sigue a otro usuarios");
        }

        List<PostDto> allFollowedPosts = new ArrayList<>();

        for (UserDto userDto : followedList){
            allFollowedPosts.addAll(this.getUserPosts(userDto.userId()));
        }

        LocalDate currentDate = LocalDate.now();
        allFollowedPosts = sortLastFollowedPost(allFollowedPosts.stream().filter(post -> ChronoUnit.DAYS.between(post.date(),currentDate)<=14).toList(), order);

        if(allFollowedPosts.isEmpty()){
            throw new NotFoundException("No se encontraron post recientes de los usuarios que sigue el usuario " + userId);
        }

        return new UserFollowedPostsDto(userId, allFollowedPosts) ;
    }

    public List<PostDto> sortLastFollowedPost(List<PostDto> posts, String order){
        if(order.equals("date_asc"))
            return posts.stream().sorted(Comparator.comparing(PostDto::date)).toList() ;
        if(order.equals("date_desc"))
            return posts.stream().sorted(Comparator.comparing(PostDto::date).reversed()).toList();

        throw new BadRequestException("Debe ingresar un orden valido");
    }

}
