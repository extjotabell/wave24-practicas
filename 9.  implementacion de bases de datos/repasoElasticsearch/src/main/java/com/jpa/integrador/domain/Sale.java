package com.jpa.integrador.domain;

import com.jpa.integrador.dto.request.SaleRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "sales")
public class Sale {

    @Id
    private Integer id;

    private LocalDate date;
    private Double totalAmount;
    private String paymentMethod;

    @Field(type = FieldType.Nested, includeInParent = true)
    private Set<Cloth> clothes;


    public Sale(SaleRequestDTO saleRequestDTO) {
        this.date = saleRequestDTO.date();
        this.totalAmount = saleRequestDTO.totalAmount();
        this.paymentMethod = saleRequestDTO.paymentMethod();
        this.clothes = saleRequestDTO.clothes().stream().map(Cloth::new).collect(Collectors.toSet());
    }
}
