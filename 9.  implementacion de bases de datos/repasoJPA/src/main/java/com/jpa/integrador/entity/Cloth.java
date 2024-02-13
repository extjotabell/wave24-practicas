package com.jpa.integrador.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "prenda")
public class Cloth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String name;

    @Column(name = "marca", nullable = false)
    private String brand;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "talla", nullable = false)
    private String size;

    @Column(name = "cantidad", nullable = false)
    private Integer quantity;

    @Column(name = "precio_venta", nullable = false)
    private Double salePrice;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "preda_vendida",
            joinColumns = @JoinColumn(name = "id_prenda", nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "id_venta", nullable = false, updatable = false)
    )
    private Set<Sale> sales;

    public void updateQuantity(String action, Integer quantity) {
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
