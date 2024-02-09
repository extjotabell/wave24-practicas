package com.jpa.integrador.service;


import com.jpa.integrador.dto.request.ClothRequestDTO;
import com.jpa.integrador.dto.request.SaleRequestDTO;
import com.jpa.integrador.dto.response.ClothesListResponseDTO;

import com.jpa.integrador.dto.response.ClothesResponseDTO;
import com.jpa.integrador.dto.response.SaleListResponseDTO;
import com.jpa.integrador.dto.response.SaleResponseDTO;

import com.jpa.integrador.entity.Cloth;
import com.jpa.integrador.entity.Sale;
import com.jpa.integrador.repository.IClothRepository;
import com.jpa.integrador.repository.ISaleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class SaleService implements ISaleService {
    ISaleRepository saleRepository;

    IClothRepository clothRepository;

    public SaleService(ISaleRepository saleRepository, IClothRepository clothRepository) {
        this.saleRepository = saleRepository;
        this.clothRepository = clothRepository;
    }

    @Override
    public Boolean addSale(SaleRequestDTO saleRequestDTO) {
        List<Cloth> clothOfSale = saleRequestDTO.cloth().stream().map(clothRequestDTO -> new Cloth(
               clothRequestDTO.id(),
               clothRequestDTO.name(),
               clothRequestDTO.brand(),
               clothRequestDTO.color(),
               clothRequestDTO.size(),
               clothRequestDTO.quantity(),
               clothRequestDTO.salePrice()
       )).toList();

        List<Cloth> clothsToSave = new ArrayList<>();
        clothOfSale.forEach(cloth -> {
            clothRepository.findById(cloth.getId()).ifPresent(clothsToSave::add);
        });
        Sale sale = new Sale(
                saleRequestDTO.id(),
                saleRequestDTO.date(),
                saleRequestDTO.totalAmount(),
                saleRequestDTO.paymentMethod(),
                clothsToSave
        );
        saleRepository.save(sale);
        return true;
    }

    @Override
    public SaleListResponseDTO findAllSales() {
        List<Sale> list = saleRepository.findAll();
        return transformList(list);
    }

    @Override
    public SaleResponseDTO findOneSale(Integer id) {
        Sale sale = saleRepository.findById(id).orElse(null);
        List<ClothRequestDTO> clothDTO = sale.getCloth().stream().map(this::transformCloth).toList();
        return new SaleResponseDTO(
                sale.getId(),
                sale.getDate(),
                sale.getTotalAmount(),
                sale.getPaymentMethod(),
                clothDTO
        );
    }

    @Override
    public Boolean updateSale(Integer code, SaleRequestDTO saleRequestDTO) {
        Sale sale = saleRepository.findById(code).orElse(null);
        assert sale != null;
        sale.setDate(saleRequestDTO.date());
        sale.setTotalAmount(saleRequestDTO.totalAmount());
        sale.setPaymentMethod(saleRequestDTO.paymentMethod());
        saleRepository.save(sale);
        return true;
    }

    @Override
    public Boolean deleteSale(Integer id) {
        Sale sale = saleRepository.findById(id).orElse(null);
        assert sale != null;
        saleRepository.delete(sale);
        return true;
    }

    @Override
    public SaleListResponseDTO searchSaleByDate(LocalDate date) {
        List<Sale> list = saleRepository.findByDateEquals(date);
        return transformList(list);
    }

    @Override
    public ClothesListResponseDTO searchClothesBySaleId(Integer id) {
        Sale sale = saleRepository.findById(id).orElse(null);
        assert sale != null;
        return transformListCloth(sale.getCloth());
    }

    private SaleListResponseDTO transformList(List<Sale> list){
        List<SaleResponseDTO> saleDTO = list.stream().map(sale ->
                new SaleResponseDTO(
                        sale.getId(),
                        sale.getDate(),
                        sale.getTotalAmount(),
                        sale.getPaymentMethod(),
                        sale.getCloth().stream()
                                .map(this::transformCloth)
                                .collect(Collectors.toList())
                )
        ).collect(Collectors.toList());

        return new SaleListResponseDTO(saleDTO);
    }
    private ClothRequestDTO transformCloth(Cloth cloth){

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

    private ClothesListResponseDTO transformListCloth(List<Cloth> list){
        List<ClothesResponseDTO> clothesDTO = new ArrayList<>();
        list.forEach(cloth ->
                clothesDTO
                        .add(
                                new ClothesResponseDTO(
                                        cloth.getId(),
                                        cloth.getName(),
                                        cloth.getBrand(),
                                        cloth.getColor(),
                                        cloth.getSize(),
                                        cloth.getQuantity(),
                                        cloth.getSalePrice()
                                )
                        )
        );
        return new ClothesListResponseDTO(clothesDTO);
    }

}
