package org.showroom.showroom.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "clothes")
@TypeAlias("cloth")
public class Cloth {
    @Id
    private String id;
    private String name;
    private String brand;
    private String color;
    private String size;
    private Integer quantity;
    private Double salePrice;
}
