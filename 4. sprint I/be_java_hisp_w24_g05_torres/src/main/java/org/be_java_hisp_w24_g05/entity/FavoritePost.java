package org.be_java_hisp_w24_g05.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoritePost {

    private Integer userId;

    private Integer postId;

}
