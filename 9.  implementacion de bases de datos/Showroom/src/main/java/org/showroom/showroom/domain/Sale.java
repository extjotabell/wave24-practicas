package org.showroom.showroom.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "sales")
@TypeAlias("sale")
public class Sale {
    @Id
    private String id;
    private LocalDate date;
    private Double totalAmount;
    private String paymentMethod;
    private List<Cloth> cloth;
}
