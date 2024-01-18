package org.be_java_hisp_w24_g05.entity;


import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PromoPost extends Post{

    private Double discount;

    private boolean hasPromo;

    public PromoPost(Post post, Double discount, boolean hasPromo) {
        super(0, post.getUserId(), post.getDate(), post.getProduct(), post.getCategory(), post.getPrice());
        this.discount = discount;
        this.hasPromo = hasPromo;
    }


}
