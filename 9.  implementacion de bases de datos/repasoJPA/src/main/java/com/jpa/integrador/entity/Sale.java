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
    @JoinTable(
            name = "ventas_prendas",
            joinColumns = @JoinColumn(name = "ventas_id", nullable = false, referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "prendas_id", nullable = false, referencedColumnName = "id")
    )
    private List<Cloth> clothes;
}
