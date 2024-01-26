package com.socialmeli.socialmeli.utils;

import com.socialmeli.socialmeli.dto.UserDto;
import com.socialmeli.socialmeli.entities.User;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class UserUtils {
    private final User USER_1465 = new User(
            1465,
            "usuario1",
            new ArrayList<>(
                    List.of(
                            new User(
                                    4698,
                                    "usuario2",
                                    null,
                                    null
                            )
                    )
            ),
            new ArrayList<>(
                    List.of(
                            new User(
                                    4698,
                                    "usuario2",
                                    null,
                                    null
                            )
                    )
            )
    );
    @Getter
    private final User USER_1115 = new User(
            1115,
            "usuario3",
            new ArrayList<>(),
            new ArrayList<>(
                    List.of(
                            new User(
                                    4698,
                                    "usuario2",
                                    null,
                                    null
                            )
                    )
            )
    );
    private final User USER_4698 = new User(
            4698,
            "usuario2",
            new ArrayList(List.of(
                    new User(1115, "usuario3",null,null),
                    new User(1465, "usuario1",null,null),
                    new User( 123,"usuario5",null,null)
                    )),
            new ArrayList(List.of(
                    new User( 234, "usuario4", null,null),
                    new User(1465, "usuario1",null,null),
                    new User(123, "usuario5",null,null))));

    List<UserDto> ascList = List.of(new UserDto(123, "usuario5"),
            new UserDto(234, "usuario4"),
            new UserDto(1465, "usuario1"));

    List<UserDto> descList = List.of(new UserDto(1465, "usuario1"),
            new UserDto(234, "usuario4"),
            new UserDto(123,"usuario5"));

    private final User NEW_USER = new User(
            1117,
            "usuario1",
            new ArrayList<>(),
            new ArrayList<>()
    );

    private final User USER_3105 = new User(
            3105,
            "usuario6",
            new ArrayList<>(List.of(
                    new User(1115,"usuario3",null,null),
                    new User(1465,"usuario1",null,null),
                    new User(4698,"usuario2",null,null)
            )),
            new ArrayList<>()
    );

    List<UserDto> ascListFolowers = List.of(
            new UserDto(1465, "usuario1"),
            new UserDto(4698, "usuario2"),
            new UserDto(1115, "usuario3")
    );

    List<UserDto> descListFolowers = List.of(
            new UserDto(1115, "usuario3"),
            new UserDto(4698, "usuario2"),
            new UserDto(1465,"usuario1")
    );

    public static List<UserDto> convertToUserDtoList(List<User> userList) {
        return userList.stream()
                .map(u -> new UserDto(u.getUserId(), u.getUserName()))
                .collect(Collectors.toList());
    }

}
