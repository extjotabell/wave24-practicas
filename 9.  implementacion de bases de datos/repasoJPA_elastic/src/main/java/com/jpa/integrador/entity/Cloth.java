package com.jpa.integrador.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Set;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Document(indexName = "prendas")
@TypeAlias("prenda")
public class Cloth {
    @Id
    private String id;

    @Field(name = "nombre", type = FieldType.Text)
    private String name;

    @Field(name = "marca", type = FieldType.Keyword)
    private String brand;

    @Field(name = "color", type = FieldType.Keyword)
    private String color;

    @Field(name = "talla", type = FieldType.Keyword)
    private String size;

    @Field(name = "cantidad", type = FieldType.Integer)
    private Integer quantity;

    @Field(name = "precio_venta", type = FieldType.Double)
    private Double salePrice;

    @Field(type= FieldType.Nested, includeInParent = true)
    private Set<Sale> sales;

    public void updateQuantity(@NotNull String action, Integer quantity) {
        if (action.equals("sum"))
            setQuantity(getQuantity() + quantity);
        else if (action.equals("subtract"))
            setQuantity(getQuantity() - quantity);
    }
    public void sumOneQuantity() {
        updateQuantity("sum", 1);
    }
    public void subtractOneQuantity() {
        updateQuantity("subtract", 1);
    }
}
