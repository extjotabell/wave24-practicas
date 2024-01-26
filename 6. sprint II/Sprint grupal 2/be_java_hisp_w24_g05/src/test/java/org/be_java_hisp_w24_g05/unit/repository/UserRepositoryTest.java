package org.be_java_hisp_w24_g05.unit.repository;

import org.be_java_hisp_w24_g05.common.Data;
import org.be_java_hisp_w24_g05.entity.Post;
import org.be_java_hisp_w24_g05.entity.Product;
import org.be_java_hisp_w24_g05.entity.User;
import org.be_java_hisp_w24_g05.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.List;

public class UserRepositoryTest {


    private final UserRepository userRepository = new UserRepository();

    private final Data data = new Data();

    @Test
    public void loadData()  {
        List<User> expected = data.loadData();

        List<User> result = userRepository.findAll();



        Assertions.assertEquals(expected, result);
    }

    @Test
    public void recentPostsOfFollowedUsersDateDescPositive() {
        //arrange

        List<Post> expectedPosts = List.of(data.getPOSTS().get(0), data.getPOSTS().get(4), data.getPOSTS().get(1));

        //act

        var result = userRepository.recentPostsOfFollowedUsers(1, "date_desc");

        //assert

        Assertions.assertEquals(expectedPosts, result);
    }

    @Test
    public void recentPostsOfFollowedUsersDateAscPositive() {
        //arrange

        List<Post> expectedPosts = List.of(data.getPOSTS().get(1), data.getPOSTS().get(4), data.getPOSTS().get(0));

        //act

        var result = userRepository.recentPostsOfFollowedUsers(1, "date_asc");

        //assert

        Assertions.assertEquals(expectedPosts, result);

    }
}
