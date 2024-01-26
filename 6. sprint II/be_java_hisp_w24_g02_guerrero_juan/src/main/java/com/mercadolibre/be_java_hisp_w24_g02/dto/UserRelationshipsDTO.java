package com.mercadolibre.be_java_hisp_w24_g02.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mercadolibre.be_java_hisp_w24_g02.serializer.UserRelationshipsDTOSerializer;

import java.util.List;

@JsonSerialize(using = UserRelationshipsDTOSerializer.class)
public record UserRelationshipsDTO(
        Integer userId,
        String userName,
        List<UserBasicInfoDTO> relationshiDTOList,
        boolean isFollowers
) {


}
