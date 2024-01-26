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
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

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
    public void unfollowUser(UpdateToRelationshipsDTO unfollowUserDTO) {
        User user = getUser(unfollowUserDTO.userId());
        User userToUnfollow = getUser(unfollowUserDTO.userToUpdate());

        user.setFollowed(this.filterFollowed(user, userToUnfollow));
        userToUnfollow.setFollowers(this.filterFollowers(user, userToUnfollow));

        this.userRepository.update(user);
        this.userRepository.update(userToUnfollow);
    }

    @Override
    public void followUser(UpdateToRelationshipsDTO followUserDTO) {

        User follower = getUser(followUserDTO.userId());
        User userToFollow = getUser(followUserDTO.userToUpdate());

        if (follower.getFollowed().contains(userToFollow)  && userToFollow.getFollowers().contains(follower)) {
            throw new BadRequestException("Ya estás siguiendo a este usuario: " + followUserDTO.userToUpdate());
        }

        follower.getFollowed().add(userToFollow);
        userToFollow.getFollowers().add(follower);

        userRepository.update(follower);
        userRepository.update(userToFollow);
    }

    private List<User> filterFollowed(User user, User userToUnFollowed){
        return user.getFollowed().stream().filter(
                userFollowed -> !userFollowed.getId().equals(userToUnFollowed.getId())
        ).collect(Collectors.toList());
    }

    private List<User> filterFollowers(User user, User userToUnFollow){
        return userToUnFollow.getFollowers().stream().filter(
                userFollowed -> !userFollowed.getId().equals(user.getId())
        ).collect(Collectors.toList());
    }

    private User getUser(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(
                        () -> new NotFoundException("User not found with id: " + userId)
                );
    }

    @Override
    public UserFollowersCountDTO getUserFollowersCount(Integer userId) {
        User user = getUser(userId);
        Integer followersCount = user.getFollowers().size();
        return new UserFollowersCountDTO(user.getId(),user.getName(),followersCount);
    }


}
