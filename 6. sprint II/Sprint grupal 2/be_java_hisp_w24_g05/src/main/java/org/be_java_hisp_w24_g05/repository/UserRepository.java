package org.be_java_hisp_w24_g05.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.be_java_hisp_w24_g05.entity.Post;
import org.be_java_hisp_w24_g05.entity.Product;
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
    public User save(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
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
    public User addFollower(int userId, int userIdToFollow) {

        if (userId == userIdToFollow)
            throw new BadRequestException("User with id " + userId + " cannot follow himself");

        User user = this.users.stream().filter(u -> u.getUserId() == userId).findFirst().orElseThrow(() -> new BadRequestException("User with id " + userId + " not found"));
        User userToFollow = this.users.stream().filter(u -> u.getUserId() == userIdToFollow).findFirst().orElseThrow(() -> new BadRequestException("User with id " + userIdToFollow + " not found"));

        if (user.getFollowed().stream().filter(u -> u.getUserId() == userIdToFollow).findFirst().orElse(null) != null)
            throw new BadRequestException("User with id " + userIdToFollow + " already followed");


        user.getFollowed().add(userToFollow);

        userToFollow.getFollowers().add(user);

        return user;

    }

    @Override
    public User removeFollower(int userId, int userIdToUnfollow) {

        User user = this.users.stream().filter(u -> u.getUserId() == userId).findFirst().orElse(null);

        if (user != null) {
            User userToUnfollow = user.getFollowed().stream().filter(u -> u.getUserId() == userIdToUnfollow).findFirst().orElse(null);
            if (userToUnfollow != null) {
                user.getFollowed().remove(userToUnfollow);
                userToUnfollow.getFollowers().remove(user);
                return user;
            }else{
                throw new BadRequestException("User with id " + userIdToUnfollow + " not found in followed list");
            }
        }
        throw new BadRequestException("User with id " + userId + " not found");
    }

    private ArrayList<User> loadData() {
        ArrayList<User> data = new ArrayList<>();
        File file;
        ObjectMapper objectMapper = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
                .registerModule(new JavaTimeModule());

        TypeReference<ArrayList<User>> typeRef = new TypeReference<>() {};
        try {
            file = ResourceUtils.getFile("classpath:json/user.json");
            data = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
