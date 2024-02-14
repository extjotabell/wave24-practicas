package com.jpa.integrador.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Document(indexName = "ventas")
@TypeAlias("venta")
public class Sale {
    @Id
    private String id;

    @Field(name = "fecha", type = FieldType.Date)
    private LocalDate date;

    @Field(name = "monto_total", type = FieldType.Double)
    private Double totalAmount;

    @Field(name = "metodo_pago", type = FieldType.Keyword)
    private String paymentMethod;

    @Field(type = FieldType.Nested, includeInParent = true)
    private Set<Cloth> clothes;
}
