package org.socialmeli.be_java_hisp_w24_g04.dto;

import org.socialmeli.be_java_hisp_w24_g04.exception.BadRequestException;
import org.socialmeli.be_java_hisp_w24_g04.service.IUserService;


import java.util.Set;
import java.util.stream.Collectors;

public record UserFollowersDTO(Integer user_id, String user_name, Set<UserDTO> followers){
    public UserFollowersDTO order(String order){
        return new UserFollowersDTO(this.user_id, this.user_name, IUserService.orderList(order, this.followers));
    }
}
