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
    public Double caclularTotal(){
        Double total = 0D;
        for (Item item : items) {
            total += item.getCostoUnitario();
        }
        return total;
    }

    @Override
    public String toString() {
        return
                " cliente=" + cliente + "\n" +
                " items=" + items + "\n" +
                " total=" + total;
    }
}
