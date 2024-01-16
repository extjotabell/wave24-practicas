package org.be_java_hisp_w24_g05.service;


import org.be_java_hisp_w24_g05.dto.UserDTO;
import org.be_java_hisp_w24_g05.entity.Post;
import org.be_java_hisp_w24_g05.entity.User;

import java.util.List;

public interface IUserService {

     List<Post> recentPostsOfFollowedUsers(int userId, String order);
     List<Post> postsWithPromo(int userId);
     boolean createPostWithPromo(Post post);
     int countPromoPost(int userId);
     List<UserDTO> usersWithMoreThanTwoPosts();
}
