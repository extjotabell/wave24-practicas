package org.be_java_hisp_w24_g05.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.be_java_hisp_w24_g05.entity.Post;
import org.be_java_hisp_w24_g05.entity.User;
import org.be_java_hisp_w24_g05.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Repository
public class UserRepository implements IUserRepository{


    private ArrayList<User> users;
    public UserRepository() {
        users = Data.loadData();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return users.stream().filter(user -> user.getUserId().equals(id)).findFirst();
    }
    @Override
    public ArrayList<User> findAll() {
        return users;
    }

    // Posts of followed users by user id from last 2 weeks sorted by date
    public List<Post> recentPostsOfFollowedUsers(int userId, String order) {

        List<Post> lisPosts = users.stream().filter(user -> user.getUserId() == userId)
                .findFirst().get().getFollowed().stream()
                .flatMap(user -> user.getPosts().stream())
                .filter(post -> post.getDate().isAfter(LocalDate.now().minusDays(14)))
                .sorted(Comparator.comparing(Post::getDate))
                .toList();

        if (order.equals("date_desc") || order.isEmpty()) {
            return lisPosts.stream().sorted(Comparator.comparing(Post::getDate).reversed()).toList();
        }
        else {
            return lisPosts;
        }
    }

    @Override
    public User addPost(Post post) {

        User user = this.users.stream().filter(u -> u.getUserId() == post.getUserId()).findFirst().orElse(null);
        if(Objects.isNull(user) ) throw new BadRequestException("User does not exist");
        List<Post> posts = user.getPosts();
        Integer postId = users.size();
        post.setPostId(postId);
        posts.add(post);
        user.setPosts(posts);
        return user;
    }

    @Override
    public User addFollower(User user, User userToFollow) {

        user.getFollowed().add(userToFollow);

        userToFollow.getFollowers().add(user);

        return user;

    }

    @Override
    public User removeFollower(User user, int userIdToUnfollow) {

        User userToUnfollow = this.users.stream().filter(u -> u.getUserId() == userIdToUnfollow).findFirst().orElse(null);

        user.getFollowed().remove(userToUnfollow);
        assert userToUnfollow != null;
        userToUnfollow.getFollowers().remove(user);

        return user;
    }

}
