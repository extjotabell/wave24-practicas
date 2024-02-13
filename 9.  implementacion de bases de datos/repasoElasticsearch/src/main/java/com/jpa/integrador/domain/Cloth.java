package com.jpa.integrador.domain;

import com.jpa.integrador.dto.request.ClothRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Set;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Document(indexName = "clothes")
public class Cloth {
    @Id
    private Integer id;
    private String name;
    private String brand;
    private String color;
    private String size;
    private Integer quantity;
    private Double salePrice;

    @Field(type = FieldType.Nested, includeInParent = true)
    private Set<Sale> sales;

    public Cloth(ClothRequestDTO clothRequestDTO){
        this.id = clothRequestDTO.id();
        this.name = clothRequestDTO.name();
        this.brand = clothRequestDTO.brand();
        this.color = clothRequestDTO.color();
        this.size = clothRequestDTO.size();
        this.quantity = clothRequestDTO.quantity();
        this.salePrice = clothRequestDTO.salePrice();
    }

}
