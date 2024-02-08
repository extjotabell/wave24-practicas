package com.JPA.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "factura")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd/MM/yyyy")
    @Column(name = "fecha_facturacion")
    private LocalDate date;

    @ManyToOne()
    private Client client;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "products_invoices",

            joinColumns = @JoinColumn(name = "invoice_id"),

            inverseJoinColumns = @JoinColumn(name = "product_id"))
    // CON LAZY, NO HACE EL JOIN HASTA QUE YO CONSULTO ESTE ATRIBUTO
    // CON EAGER, CUANDO CREO INVOICE, HACE EL JOIN INMEDIATAMENTE
    private List<Product> products;
}
