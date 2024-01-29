package org.be_java_hisp_w24_g05.repository;

import org.be_java_hisp_w24_g05.common.Data;
import org.be_java_hisp_w24_g05.entity.Post;
import org.be_java_hisp_w24_g05.entity.Product;
import org.be_java_hisp_w24_g05.entity.Post;
import org.be_java_hisp_w24_g05.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class UserRepositoryTest {


    private final UserRepository userRepository = new UserRepository();

    private final Data data = new Data();

    @Test
    public void loadData() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<User> expected = data.loadData();

        List<User> result = userRepository.findAll();

        Assertions.assertFalse(result.isEmpty());
    }

    @Test
    @DisplayName("Find user by id")
    public void findById() {
        User expected = data.loadData().get(2);

        Optional<User> result = userRepository.findById(3);

        Assertions.assertEquals(expected, result.get());
    }

    @Test
    @DisplayName("[T-0006] Verify correct order date_desc")
    public void recentPostsOfFollowedUsersDateDescPositive() {
        //arrange

        List<Post> expectedPosts = List.of(data.getPOSTS().get(0), data.getPOSTS().get(4), data.getPOSTS().get(1));

        //act

        var result = userRepository.recentPostsOfFollowedUsers(1, "date_desc");

        //assert

        Assertions.assertEquals(expectedPosts, result);
    }

    @Test
    @DisplayName("[T-0006] Verify correct order date_asc")
    public void recentPostsOfFollowedUsersDateAscPositive() {
        //arrange

        List<Post> expectedPosts = List.of(data.getPOSTS().get(1), data.getPOSTS().get(4), data.getPOSTS().get(0));

        //act

        var result = userRepository.recentPostsOfFollowedUsers(1, "date_asc");

        //assert

        Assertions.assertEquals(expectedPosts, result);

    }

    @Test
    @DisplayName("[T-0007] Find user by id not found")
    public void findByIdNotFound() {
        Optional<User> result = userRepository.findById(100);

        Assertions.assertEquals(Optional.empty(), result);
    }
    @Test
    @DisplayName("[T-0008] Test that Posts are from the 2 Last Weeks")
    public void getLast2WeeksPosts(){
        //arrange
        Integer userId = 1;
        String order = "";
        //act
        var result = true;
        for (Post post : userRepository.recentPostsOfFollowedUsers(userId, order)) {
            if (post.getDate().isBefore(LocalDate.now().minusWeeks(2))) {
                result = false;
                break;
            }
        }
        //assert
        Assertions.assertTrue(result, "Existe 1 post de hace más de 2 semanas");
    }


}
