package com.jpa.integrador.mapper;

import com.jpa.integrador.dto.request.ClothRequestDTO;
import com.jpa.integrador.dto.request.SaleRequestDTO;
import com.jpa.integrador.dto.response.ClothesListResponseDTO;
import com.jpa.integrador.dto.response.ClothesResponseDTO;
import com.jpa.integrador.dto.response.SaleListResponseDTO;
import com.jpa.integrador.dto.response.SaleResponseDTO;
import com.jpa.integrador.entity.Cloth;
import com.jpa.integrador.entity.Sale;

import java.util.List;

public class Mapper {
    public static ClothesResponseDTO toClothesResponseDTO(Cloth cloth) {
        return new ClothesResponseDTO(
                cloth.getId(),
                cloth.getName(),
                cloth.getBrand(),
                cloth.getColor(),
                cloth.getSize(),
                cloth.getQuantity(),
                cloth.getSalePrice()
        );
    }
    public static Cloth toCloth(ClothRequestDTO clothRequestDTO) {
        return new Cloth(
                clothRequestDTO.id(),
                clothRequestDTO.name(),
                clothRequestDTO.brand(),
                clothRequestDTO.color(),
                clothRequestDTO.size(),
                clothRequestDTO.quantity(),
                clothRequestDTO.salePrice()
        );
    }

    public static List<ClothesResponseDTO> toClothesResponseDTOList(List<Cloth> clothList) {
        return clothList.stream().map(cloth -> new ClothesResponseDTO(
                cloth.getId(),
                cloth.getName(),
                cloth.getBrand(),
                cloth.getColor(),
                cloth.getSize(),
                cloth.getQuantity(),
                cloth.getSalePrice()
        )).toList();
    }
    public static Sale toSale(SaleRequestDTO saleRequestDTO) {
        return new Sale(
                saleRequestDTO.id(),
                saleRequestDTO.date(),
                saleRequestDTO.totalAmount(),
                saleRequestDTO.paymentMethod(),
                toClothList(saleRequestDTO.clothList())
        );
    }
    public static List<Cloth> toClothList(List<ClothRequestDTO> clothRequestDTOList) {
        return clothRequestDTOList.stream().map(clothRequestDTO -> new Cloth(
                clothRequestDTO.id(),
                clothRequestDTO.name(),
                clothRequestDTO.brand(),
                clothRequestDTO.color(),
                clothRequestDTO.size(),
                clothRequestDTO.quantity(),
                clothRequestDTO.salePrice()
        )).toList();
    }
   public static List<ClothesResponseDTO> toListOfClothesResponseDTO(List<Cloth> clothList) {
        return clothList.stream().map(cloth -> new ClothesResponseDTO(
                cloth.getId(),
                cloth.getName(),
                cloth.getBrand(),
                cloth.getColor(),
                cloth.getSize(),
                cloth.getQuantity(),
                cloth.getSalePrice()
        )).toList();

    }

    public static SaleListResponseDTO toSaleListResponseDTO(List<Sale> saleList) {
        return new SaleListResponseDTO(saleList.stream().map(sale -> new SaleResponseDTO(
                sale.getId(),
                sale.getDate(),
                sale.getTotalAmount(),
                sale.getPaymentMethod(),
                toListOfClothesResponseDTO(sale.getClothList())
        )).toList());
    }
    public static SaleResponseDTO toSaleResponseDTO(Sale sale) {
        return new SaleResponseDTO(
                sale.getId(),
                sale.getDate(),
                sale.getTotalAmount(),
                sale.getPaymentMethod(),
                toListOfClothesResponseDTO(sale.getClothList())
        );
    }
}
