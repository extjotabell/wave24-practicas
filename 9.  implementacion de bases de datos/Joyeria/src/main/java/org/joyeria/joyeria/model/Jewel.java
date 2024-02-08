package org.joyeria.joyeria.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jewel")
public class Jewel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private String material;

    @Column(nullable = false, precision = 2)
    private Double weight;

    private String particularity;

    @Column(name = "is_available", nullable = false, columnDefinition = "boolean default false")
    private Boolean isAvailable;

    @Column(name = "is_for_sale", nullable = false, columnDefinition = "boolean default true")
    private Boolean isForSale;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;

        Class<?> oEffectiveClass = o instanceof HibernateProxy hibernateProxy
                ? (hibernateProxy).getHibernateLazyInitializer().getPersistentClass()
                : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy hibernateProxy
                ? (hibernateProxy).getHibernateLazyInitializer().getPersistentClass()
                : this.getClass();

        if (thisEffectiveClass != oEffectiveClass) return false;

        Jewel jewel = (Jewel) o;

        return getId() != null && Objects.equals(getId(), jewel.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy hibernateProxy
                ? (hibernateProxy).getHibernateLazyInitializer().getPersistentClass().hashCode()
                : getClass().hashCode();
    }
}
