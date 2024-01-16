package org.be_java_hisp_w24_g05.repository;

import org.be_java_hisp_w24_g05.dto.UserDTO;
import org.be_java_hisp_w24_g05.entity.Post;
import org.be_java_hisp_w24_g05.entity.Product;
import org.be_java_hisp_w24_g05.entity.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository{

    private ArrayList<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
        Product product = new Product(4, "Laptop", "Electronics", "BrandX", "Silver", "Note1");
        Product product1 = new Product(1, "Laptop", "Electronics", "BrandX", "Silver", "Note1");
        Product product2 = new Product(2, "Phone", "Electronics", "BrandY", "Black", "Note2");
        Product product3 = new Product(3, "Camera", "Photography", "BrandZ", "Red", "Note3");

// Crear usuarios
        User user1 = new User(1, "User1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user2 = new User(2, "User2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user3 = new User(3, "User3", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user4 = new User(4, "User4", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

// Crear posts
        Post post1 = new Post(1, 1, LocalDate.now().minusDays(7), product1, 1, 100.0,true,10.0);
        Post post2 = new Post(2, 1, LocalDate.now().minusDays(14), product2, 2, 200.0,false,0.0);
        Post post3 = new Post(3, 2, LocalDate.now().minusDays(21), product3, 1, 150.0,true,10.0);
        Post post4 = new Post(4, 2, LocalDate.now().minusDays(3), product1, 2, 120.0,false,0.0);

        Post post5 = new Post(5, 3, LocalDate.now().minusDays(10), product2, 1, 180.0,true,10.0);
        Post post6 = new Post(6, 3, LocalDate.now().minusDays(18), product3, 2, 220.0,false,0.0);
        Post post7 = new Post(7, 4, LocalDate.now().minusDays(5), product1, 1, 130.0,true,10.0);
        Post post8 = new Post(8, 4, LocalDate.now().minusDays(12), product2, 2, 250.0,false,0.0);

// Agregar posts a los usuarios
        user1.getPosts().add(post1);
        user1.getPosts().add(post2);

        user2.getPosts().add(post3);
        user2.getPosts().add(post4);
        user3.getPosts().add(post5);
        user3.getPosts().add(post6);

        user4.getPosts().add(post7);
        user4.getPosts().add(post8);

// Establecer relaciones de followed
        user1.getFollowed().add(user2);
        user1.getFollowed().add(user3);

        user4.getFollowed().add(user2);
        user4.getFollowed().add(user3);

// Agregar usuarios a la lista

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

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
        return Optional.empty();
    }

    @Override
    public ArrayList<User> findAll() {
        return null;
    }

    // Posts of followed users by user id from last 2 weeks sorted by date
    public List<Post> recentPostsOfFollowedUsers(int userId, String order) {

        List<Post> lisPosts = users.stream().filter(user -> user.getUserId() == userId)
                .findFirst().get().getFollowed().stream()
                .flatMap(user -> user.getPosts().stream())
                .filter(post -> post.getDate().isAfter(LocalDate.now().minusDays(14)))
                .sorted(Comparator.comparing(Post::getDate))
                .toList();

        if (order.equals("date_desc")){
            return lisPosts.stream().sorted(Comparator.comparing(Post::getDate).reversed()).toList();
        }
        else {
            return lisPosts;
        }

    }


    public List<Post> postsWithPromo(int userId){
        return users.stream().filter(user -> user.getUserId() == userId)
                .findFirst().get().getPosts().stream()
                .filter(post -> post.getHasPromo() == true)
                .toList();
    }

    public boolean createPostWithPromo(Post post){
        return users.stream().filter(user -> user.getUserId() == post.getUserId())
                .findFirst().get().getPosts().add(post);
    }

    public int countPromoPost(int userId){
        return users.stream().filter(user -> user.getUserId() == userId)
                .findFirst().get().getPosts().stream()
                .filter(post -> post.getHasPromo() == true)
                .toList().size();
    }

public List<User> usersWithMoreThanTwoPosts(){
        return users.stream().filter(user -> user.getPosts().size() > 2)
                .toList();
    }



}
