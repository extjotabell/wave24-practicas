package com.jpa.integrador.entity;

import com.jpa.integrador.dto.request.SaleRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ventas")
public class Sale {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "fecha")
    private LocalDate date;
    @Column(name = "monto_total")
    private Double totalAmount;
    @Column(name = "metodo_pago")
    private String paymentMethod;

    @ManyToMany
    @JoinTable(
            name = "venta_prenda",
            joinColumns = @JoinColumn(name = "venta_id"),
            inverseJoinColumns = @JoinColumn(name = "prenda_id")
    )
    private Set<Cloth> clothes;


    public Sale(SaleRequestDTO saleRequestDTO) {
        this.date = saleRequestDTO.date();
        this.totalAmount = saleRequestDTO.totalAmount();
        this.paymentMethod = saleRequestDTO.paymentMethod();
        this.clothes = saleRequestDTO.clothes().stream().map(Cloth::new).collect(Collectors.toSet());
    }
}
