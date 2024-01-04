package org.example.ejercicios.integrador.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private Double total;
}
