package com.JPA.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "persona")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String firstname;

    @Column(name = "apellido", length = 50, nullable = false)
    private String lastname;

    @Column(name = "numero_documento", length = 8, nullable = false)
    private String dni;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd/MM/yyyy")
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate birthDate;

    @Column(name = "edad")
    private Short age;

    @Column(name = "salario", scale = 2)
    private Double salary;

    //@OneToOne(mappedBy = "person")
    //private Client client;

}
