package com.jpa.integrador.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ventas")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha")
    private LocalDate date;
    @Column(name = "monto_total")
    private Double totalAmount;
    @Column(name = "metodo_pago")
    private String paymentMethod;

    @ManyToMany
    @JoinTable(name = "venta_prenda",
            joinColumns = @JoinColumn(name = "sale_id"),
            inverseJoinColumns = @JoinColumn(name = "cloth_id"))
    private List<Cloth> cloth;

}
