package com.jpa.integrador.service.impl;


import com.jpa.integrador.dto.request.ClothRequestDTO;
import com.jpa.integrador.dto.request.SaleRequestDTO;
import com.jpa.integrador.dto.response.ClothesListResponseDTO;

import com.jpa.integrador.dto.response.ClothesResponseDTO;
import com.jpa.integrador.dto.response.SaleListResponseDTO;
import com.jpa.integrador.dto.response.SaleResponseDTO;

import com.jpa.integrador.entity.Cloth;
import com.jpa.integrador.entity.Sale;
import com.jpa.integrador.repository.ISaleRespository;
import com.jpa.integrador.service.interfaces.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class SaleService implements ISaleService {

    @Autowired
    ISaleRespository saleRepository;

    @Override
    public Boolean addSale(SaleRequestDTO saleRequestDTO) {
        Sale sale = mapToSaleEntity(saleRequestDTO);
        saleRepository.save(sale);
        return true;
    }

    @Override
    public SaleListResponseDTO findAllSales() {
        List<Sale> sales = saleRepository.findAll();
        return mapToSaleListResponseDTO(sales);
    }

    @Override
    public SaleResponseDTO findOneSale(Integer id) {
        Sale sale = getSaleById(id);
        return mapToSaleResponseDTO(sale);
    }

    @Override
    public Boolean updateSale(Integer code, SaleRequestDTO saleRequestDTO) {
        if (!saleRepository.existsById(code))
            return false;
        Sale saleSaved = mapToSaleEntity(saleRequestDTO);
        saleSaved.setId(code);
        saleRepository.save(saleSaved);
        return true;
    }

    @Override
    public Boolean deleteSale(Integer id) {
        if (!saleRepository.existsById(id))
            return false;
        saleRepository.deleteById(id);
        return true;
    }

    @Override
    public SaleListResponseDTO searchSaleByDate(LocalDate date) {
        List<Sale> sales = saleRepository.findByDate(date);
        return mapToSaleListResponseDTO(sales);
    }

    @Override
    public ClothesListResponseDTO searchClothesBySaleId(Integer id) {
        Sale sale = getSaleById(id);
        return mapToClothesListResponseDTO(sale.getCloth());
    }

    private Sale mapToSaleEntity(SaleRequestDTO saleRequestDTO) {
        Sale sale = new Sale();
        sale.setId(saleRequestDTO.id());
        sale.setDate(saleRequestDTO.date());
        sale.setTotalAmount(saleRequestDTO.totalAmount());
        sale.setPaymentMethod(saleRequestDTO.paymentMethod());
        List<Cloth> clothes = mapClothRequestDTOsToEntities(saleRequestDTO.cloth());
        sale.setCloth(clothes);
        return sale;
    }

    private SaleListResponseDTO mapToSaleListResponseDTO(List<Sale> sales) {
        List<SaleResponseDTO> saleResponseDTOs = sales.stream()
                .map(this::mapToSaleResponseDTO)
                .toList();
        return new SaleListResponseDTO(saleResponseDTOs);
    }

    private SaleResponseDTO mapToSaleResponseDTO(Sale sale) {
        List<ClothRequestDTO> clothRequestDTOs = sale.getCloth().stream()
                .map(this::mapToClothRequestDTO)
                .toList();
        return new SaleResponseDTO(
                sale.getId(),
                sale.getDate(),
                sale.getTotalAmount(),
                sale.getPaymentMethod(),
                clothRequestDTOs
        );
    }

    private Sale getSaleById(Integer id) {
        return saleRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Sale not found with id: " + id)
        );
    }

    private List<Cloth> mapClothRequestDTOsToEntities(List<ClothRequestDTO> clothRequestDTOs) {
        return clothRequestDTOs.stream()
                .map(this::mapToCloth)
                .toList();
    }

    private Cloth mapToCloth(ClothRequestDTO clothRequestDTO) {
        Cloth cloth = new Cloth();
        cloth.setId(clothRequestDTO.id());
        cloth.setName(clothRequestDTO.name());
        cloth.setBrand(clothRequestDTO.brand());
        cloth.setColor(clothRequestDTO.color());
        cloth.setSize(clothRequestDTO.size());
        cloth.setQuantity(clothRequestDTO.quantity());
        cloth.setSalePrice(clothRequestDTO.salePrice());
        return cloth;
    }
    private ClothRequestDTO mapToClothRequestDTO(Cloth cloth) {
        return new ClothRequestDTO(
                cloth.getId(),
                cloth.getName(),
                cloth.getBrand(),
                cloth.getColor(),
                cloth.getSize(),
                cloth.getQuantity(),
                cloth.getSalePrice()
        );
    }

    private ClothesListResponseDTO mapToClothesListResponseDTO(List<Cloth> clothes) {
        List<ClothesResponseDTO> clothesResponseDTOs = clothes.stream()
                .map(this::mapToClothesResponseDTO)
                .toList();
        return new ClothesListResponseDTO(clothesResponseDTOs);
    }

    private ClothesResponseDTO mapToClothesResponseDTO(Cloth cloth) {
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
}