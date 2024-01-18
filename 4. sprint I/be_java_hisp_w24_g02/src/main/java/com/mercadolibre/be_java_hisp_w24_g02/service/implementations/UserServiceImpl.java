package com.mercadolibre.be_java_hisp_w24_g02.service.implementations;

import com.mercadolibre.be_java_hisp_w24_g02.dto.*;
import com.mercadolibre.be_java_hisp_w24_g02.entity.Post;
import com.mercadolibre.be_java_hisp_w24_g02.entity.User;
import com.mercadolibre.be_java_hisp_w24_g02.exception.BadRequestException;
import com.mercadolibre.be_java_hisp_w24_g02.exception.NotFoundException;
import com.mercadolibre.be_java_hisp_w24_g02.repository.interfaces.IPostRepository;
import com.mercadolibre.be_java_hisp_w24_g02.repository.interfaces.IUserRepository;
import com.mercadolibre.be_java_hisp_w24_g02.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IPostRepository postRepository;

    @Override
    public UserRelationshipsDTO getUserFollowers(Integer userId, String order){

        User user = getUser(userId);

        List<UserBasicInfoDTO> followers = user.getFollowers()
                .stream()
                .map(follower -> new UserBasicInfoDTO(follower.getId(), follower.getName()))
                .toList();

        followers = orderList(followers, order);

        return getUserRelationshipsDTO(user, followers, true);
    }

    @Override
    public UserRelationshipsDTO getUserFollowed(Integer userId, String order){

        User user = getUser(userId);

        List<UserBasicInfoDTO> followed = user.getFollowed()
                .stream()
                .map(follower -> new UserBasicInfoDTO(follower.getId(), follower.getName()))
                .toList();

        followed = orderList(followed, order);
        return getUserRelationshipsDTO(user, followed, false);

    }


    @Override
    public UserFollowersCountDTO getUserFollowersCount(Integer userId) {
        Optional<User> user = this.userRepository.findById(userId);
        if (user.isEmpty()){
            throw new NotFoundException("user id"+ userId + "not fount");
        }
        Integer followersCount = user.get().getFollowers().size();
        return new UserFollowersCountDTO(user.get().getId(),user.get().getName(),followersCount);
}
    private List<UserBasicInfoDTO> orderList (List<UserBasicInfoDTO> list, String order) {
        if (order.equals("none")) {
            return list;
        }
        if (order.equals("name_asc")) {
            return list.stream().sorted(Comparator.comparing(UserBasicInfoDTO::userName)).toList();
        }
        if (order.equals("name_desc")) {
            return list.stream().sorted(Comparator.comparing(UserBasicInfoDTO::userName).reversed()).toList();
        }
        throw new BadRequestException("Invalid order");
    }

    private UserRelationshipsDTO getUserRelationshipsDTO(User user, List<UserBasicInfoDTO> relationShipList, boolean isFollowers) {
        return new UserRelationshipsDTO(
                user.getId(),
                user.getName(),
                relationShipList,
                isFollowers
        );
    }

    @Override
    public void unfollowUser(FollowUserDTO followUserDTO) {
        User user = this.userRepository.findById(followUserDTO.userId())
                .orElseThrow(() -> new NotFoundException("User " + followUserDTO.userId() + " not found"));
        User userToUnfollow = this.userRepository.findById(followUserDTO.userIdToUnfollow())
                .orElseThrow(() -> new NotFoundException("User to unfollow " + followUserDTO.userIdToUnfollow() + " not found"));


        user.setFollowed(this.filterFollowed(user, userToUnfollow));
        userToUnfollow.setFollowers(this.filterFollowers(user, userToUnfollow));

        this.userRepository.update(user);
        this.userRepository.update(userToUnfollow);
    }

    @Override
    public void followUser(FollowUserDTO followUserDTO) {

        User follower = userRepository.findById(followUserDTO.userId())
                .orElseThrow(() -> new NotFoundException("User not found: " + followUserDTO.userId()));

        User userToFollow = userRepository.findById(followUserDTO.userIdToUnfollow())
                .orElseThrow(() -> new NotFoundException("User to follow not found: " + followUserDTO.userIdToUnfollow()));


        if (follower.getFollowed().contains(userToFollow)  && userToFollow.getFollowers().contains(follower)) {
            throw new IllegalArgumentException("Ya estás siguiendo a este usuario: " + followUserDTO.userIdToUnfollow());
        }

        follower.getFollowed().add(userToFollow);
        userToFollow.getFollowers().add(follower);

        List<UserBasicInfoDTO> followeds = follower.getFollowed()
                        .stream()
                        .map(followed -> new UserBasicInfoDTO(followed.getId(), followed.getName()))
                        .toList();

        userRepository.update(follower);
        userRepository.update(userToFollow);
    }

    private List<User> filterFollowed(User user, User userToUnFollowed){
        return user.getFollowed().stream().filter(
                userFollowed -> !userFollowed.getId().equals(userToUnFollowed.getId())
        ).toList();
    }

    private List<User> filterFollowers(User user, User userToUnFollow){
        return userToUnFollow.getFollowers().stream().filter(
                userFollowed -> !userFollowed.getId().equals(user.getId())
        ).toList();
    }

    private User getUser(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(
                        () -> new NotFoundException("User not found")
                );
    }
    
    public UserFollowedsPostsDTO getFollowedPost(Integer userId){
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            List<Integer> getIdsFollowed = getIdsFollowed(user.get());
            List<Post> posts = postRepository.getPostOfFollowedList(getIdsFollowed);
            return new UserFollowedsPostsDTO(
                    user.get().getId(),
                    posts.stream().map(this::convertPostsDTO).toList()
            );
        }
        throw new NotFoundException("User not found");
    }

    public List<Integer> getIdsFollowed(User user) {
        return user.getFollowed().stream().map(User::getId).toList();
    }

    public UserFollowedsPostsDTO orderByDate(Integer userId, String order){
        UserFollowedsPostsDTO userFollowedsPostsDTO = getFollowedPost(userId);
        if(userId == null){
            throw new NotFoundException("User not found");
        }
        return new UserFollowedsPostsDTO(
                userFollowedsPostsDTO.userId(),
                orderListPost(userFollowedsPostsDTO, order)
        );
    }

    private List<PostDto> orderListPost(UserFollowedsPostsDTO list, String order){
        if (order.equals("date_asc")){
            return list.posts().stream().sorted(Comparator.comparing(PostDto::date)).toList();
        }
        return list.posts().stream().sorted(Comparator.comparing(PostDto::date).reversed()).toList();
    }

    private PostDto convertPostsDTO(Post posts){
        return new PostDto(posts.getPostId(),
                            posts.getUserId(),
                            posts.getDate(),
                            posts.getProduct(),
                            posts.getCategory(),
                            posts.getPrice());
    }

    public UserFollowedsPostsDTO getFollowedPost(Integer userId, String order){
        if (order.equals("none")) {
            return getFollowedPost(userId);
        }
        if (order.equals("date_asc") || order.equals("date_desc")) {
            return orderByDate(userId, order);
        }
        throw new BadRequestException("Invalid order");
    }

}
