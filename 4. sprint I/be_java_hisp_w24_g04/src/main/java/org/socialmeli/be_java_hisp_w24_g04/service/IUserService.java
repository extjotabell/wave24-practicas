package org.socialmeli.be_java_hisp_w24_g04.service;

import org.socialmeli.be_java_hisp_w24_g04.dto.UserDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserFollowersDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserFollowedDTO;
import org.socialmeli.be_java_hisp_w24_g04.exception.BadRequestException;
import org.socialmeli.be_java_hisp_w24_g04.model.User;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public interface IUserService {
    UserFollowersDTO getFollowers(Integer userId);
    User findById(int id);
    UserFollowedDTO getUserFollowedDTO(User user);
    void follow(Integer userId, Integer userIdToFollow);
    void unfollow(Integer userId, Integer userIdToUnfollow);

    /**
     *
     * @param orderParam
     * @param lista
     * @return Set<UserDTO>
     */
    static Set<UserDTO> orderList(String orderParam, Set<UserDTO> lista) {
        /** Validating order param with the format field_asc or field_desc **/
        if(orderParam.split("_").length != 2)
            throw new BadRequestException("Parameter order with invalid format");
        String orderBy = orderParam.split("_")[0];
        String order = orderParam.split("_")[1];
        if(! orderBy.equalsIgnoreCase("name"))
            throw new BadRequestException("Order by " + orderBy + " is not yet allowed");
        if (!order.equalsIgnoreCase("asc") && !order.equalsIgnoreCase("desc")) {
            throw new BadRequestException("Order must be asc or desc");
        }
        /** End of order validation. Then proceed to return the new sorted list **/
        return lista.stream().sorted(
                (u1, u2) -> {
                    int result = u1.user_name().compareTo(u2.user_name());
                    return order.equalsIgnoreCase("asc") ? result : result * -1;
                }).collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
