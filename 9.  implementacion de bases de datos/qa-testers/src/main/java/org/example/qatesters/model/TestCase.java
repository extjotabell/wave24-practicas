package org.example.qatesters.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_case")
    private Long idCase;

    @Column(length = 100)
    private String description;

    private Boolean tested;

    private Boolean passed;

    private Integer attempts;

    @Column(name = "last_update")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate lastUpdated;

}
