package org.example.ejercicioproductos.mapper;

import org.example.ejercicioproductos.dto.ProductDTO;
import org.example.ejercicioproductos.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public ProductDTO convertEntityToDto(Product product){
        return new ProductDTO(
                product.getId(),
                product.getNombre(),
                product.getTipo(),
                product.getPrecioVenta(),
                product.getPrecioCosto(),
                product.getCantidad()
        );
    }

    public Product convertDtoToEntity(ProductDTO productDTO){
        return new Product(
                productDTO.id(),
                productDTO.nombre(),
                productDTO.tipo(),
                productDTO.precioVenta(),
                productDTO.precioCosto(),
                productDTO.cantidad()
        );
    }
}
