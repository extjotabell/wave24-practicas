package org.example.perlasproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "joya")
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_identificatorio")
    private Integer IdNum;

    @Column(name = "nombre", length = 100, nullable = false)
    private String firstname;

    @Column(name = "material", length = 50, nullable = false)
    private String material;
}
