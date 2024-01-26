package org.be_java_hisp_w24_g05.unit.service;


import org.be_java_hisp_w24_g05.common.Data;
import org.be_java_hisp_w24_g05.dto.PostFollowedDto;
import org.be_java_hisp_w24_g05.entity.Post;
import org.be_java_hisp_w24_g05.entity.Product;
import org.be_java_hisp_w24_g05.entity.User;
import org.be_java_hisp_w24_g05.exception.BadRequestException;
import org.be_java_hisp_w24_g05.repository.IUserRepository;
import org.be_java_hisp_w24_g05.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    private Data data = new Data();
    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void recentPostsOfFollowedUsersOrderIncorrect(){

        Assertions.assertThrows(BadRequestException.class, ()-> userService.recentPostsOfFollowedUsers(1,"patata"));
    }


    //si order esta vacio deberia ser descendente por defecto
    //osea seria lo mismo que el caso desc pero con un order vacio
    @Test
    public void  recentPostsOfFollowedUsersNullOrder(){
        //arrange

        List<Post> expectedPosts = List.of(data.getPOSTS().get(0), data.getPOSTS().get(4), data.getPOSTS().get(1));

        //act

        Mockito.when(userRepository.recentPostsOfFollowedUsers(1, "date_desc")).thenReturn(expectedPosts);

        PostFollowedDto expectedPostFollowedDto = new PostFollowedDto(1,expectedPosts);

        var result = userService.recentPostsOfFollowedUsers(1, "");

        //assert

        Assertions.assertEquals(expectedPostFollowedDto.getPosts(), result.getPosts());
    }
}
