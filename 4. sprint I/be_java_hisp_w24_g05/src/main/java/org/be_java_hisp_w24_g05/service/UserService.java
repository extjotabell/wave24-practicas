package org.be_java_hisp_w24_g05.service;

import org.be_java_hisp_w24_g05.dto.OtherUserDTO;
import org.be_java_hisp_w24_g05.dto.UserDTO;
import org.be_java_hisp_w24_g05.entity.Post;
import org.be_java_hisp_w24_g05.entity.User;
import org.be_java_hisp_w24_g05.exception.BadRequestException;
import org.be_java_hisp_w24_g05.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;


    public List<Post> recentPostsOfFollowedUsers(int userId, String order){
        return userRepository.recentPostsOfFollowedUsers(userId, order);
    }

    public List<Post> postsWithPromo(int userId){
        return userRepository.postsWithPromo(userId);
    }

    public boolean createPostWithPromo(Post post){
        try {
            return userRepository.createPostWithPromo(post);
        }
        catch (Exception e) {
            throw new BadRequestException("Post data, not valid");
        }
    }

    public OtherUserDTO countPromoPost(int userId){

        return userRepository.countPromoPost(userId);
    }

    public List<UserDTO> usersWithMoreThanTwoPosts(){
        List<User> users = userRepository.usersWithMoreThanTwoPosts();

        List<UserDTO> userDTOList = new ArrayList<UserDTO>();
        for (User user : users) {
            UserDTO userDTO = new UserDTO(user.getUserId(), user.getUserName());
            userDTOList.add(userDTO);
        }
        return userDTOList;
       // return users.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
    }
}
