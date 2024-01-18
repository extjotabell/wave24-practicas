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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    //Desarrollo Individual
    @Override
    public PostPromoDto postPromo(PostPromoDto postPromoDto) {
        if(postPromoDto.user_id() == null || postPromoDto.date() == null || postPromoDto.product() == null || postPromoDto.category() == null
                || postPromoDto.price() == null || postPromoDto.has_promo() == null || postPromoDto.discount() == null){
            throw new BadRequestException("Los datos ingresados son incorrectos");
        }
        User user = userRepository.findById(postPromoDto.user_id()).orElse(null);
        if(Objects.isNull(user)){
            throw new BadRequestException("No existe el usuario de id: " + postPromoDto.user_id());
        }

        Post post = mapper.convertDtoToPostPromo(postPromoDto);
        var postPromoList = postRepository.save(post);
        return mapper.convertPromoPostToDto(postPromoList);
    }

    @Override
    public PromoProductCountDto countPromoPost(Integer userId) {
        User user = userRepository.findById(userId).orElse(null);
        if(Objects.isNull(user)){
            throw new BadRequestException("No se encontro el usuario de id: " + userId);
        }

        List<Post> userPosts = postRepository.findByUserId(userId);

        List<PostPromoDto> userPromoPosts= mapper.convertToPostPromoDtoList(userPosts);
        Integer promoPost = userPromoPosts.stream()
                .filter(p -> p.user_id().equals(userId) && p.has_promo().equals(true))
                .toList().size();

        return new PromoProductCountDto(userId, user.getUserName(), promoPost);
    }

    @Override
    public List<PostPromoDto> discountUserPosts(Integer userId) {

        User user = userRepository.findById(userId).orElse(null);
        if(Objects.isNull(user)){
            throw new BadRequestException("No se encontro el usuario de id: " + userId);
        }

        List<Post> userPosts = postRepository.findByUserId(userId);

        List<PostPromoDto> userPromoPosts= mapper.convertToPostPromoDtoList(userPosts);

        List<PostPromoDto> listDiscountPosts = userPromoPosts.stream()
                .filter(p -> p.user_id().equals(userId) && p.discount() != 0.0)
                .collect(Collectors.toList());
        if(listDiscountPosts.isEmpty()){
            throw new NotFoundException("El usuario de id "+ userId + " no contiene publicaciones con descuentos");
        }
        return listDiscountPosts;
    }

}
