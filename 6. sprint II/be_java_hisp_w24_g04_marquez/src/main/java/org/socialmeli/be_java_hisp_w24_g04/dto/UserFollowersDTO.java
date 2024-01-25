package org.socialmeli.be_java_hisp_w24_g04.dto;

import org.socialmeli.be_java_hisp_w24_g04.service.IUserService;
import java.util.Set;

public record UserFollowersDTO(Integer user_id, String user_name, Set<UserDTO> followers){
    public UserFollowersDTO orderBy(String order){
        return new UserFollowersDTO(this.user_id, this.user_name, IUserService.orderList(order, this.followers));
    }
}
