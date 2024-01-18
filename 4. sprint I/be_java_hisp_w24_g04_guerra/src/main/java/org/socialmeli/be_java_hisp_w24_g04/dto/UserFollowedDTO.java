package org.socialmeli.be_java_hisp_w24_g04.dto;

import org.socialmeli.be_java_hisp_w24_g04.service.IUserService;
import java.util.Set;

public record UserFollowedDTO(Integer user_id, String user_name, Set<UserDTO> followed) {
    public UserFollowedDTO orderBy(String orderParam){
        return new UserFollowedDTO(this.user_id(), this.user_name(), IUserService.orderList(orderParam, this.followed));
    }
}
