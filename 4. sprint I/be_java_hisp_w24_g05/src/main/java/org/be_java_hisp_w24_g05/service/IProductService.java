package org.be_java_hisp_w24_g05.service;


import org.be_java_hisp_w24_g05.dto.PostDto;
import org.be_java_hisp_w24_g05.dto.PostPromoDto;
import org.be_java_hisp_w24_g05.entity.Post;

import java.util.List;

public interface IProductService {
    PostDto makePost(PostDto post);
    PostPromoDto makePostPromo(PostPromoDto post);

    List<PostPromoDto> getPostPromoDiscount(Integer discount);
}
