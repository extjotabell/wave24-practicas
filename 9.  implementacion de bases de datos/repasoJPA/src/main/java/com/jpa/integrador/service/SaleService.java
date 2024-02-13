package com.jpa.integrador.service;


import com.jpa.integrador.dto.request.SaleRequestDTO;
import com.jpa.integrador.dto.response.ClothesListResponseDTO;

import com.jpa.integrador.dto.response.ClothesResponseDTO;
import com.jpa.integrador.dto.response.SaleListResponseDTO;
import com.jpa.integrador.dto.response.SaleResponseDTO;

import com.jpa.integrador.entity.Cloth;
import com.jpa.integrador.entity.Sale;
import com.jpa.integrador.exception.NotFoundException;
import com.jpa.integrador.repository.IClothRepository;
import com.jpa.integrador.repository.ISaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class SaleService implements ISaleService {
    private final ISaleRepository saleRepository;
    private final IClothRepository clothRepository;

    @Override
    public Boolean addSale(SaleRequestDTO saleRequestDTO) {
        try {
            Sale saleToSave = saleRequestDTO.dtoToSale();
            Set<Cloth> clothes = saleToSave.getClothes()
                    .stream()
                    .map(cloth -> clothRepository
                            .findById(cloth.getId())
                            .orElseThrow(() ->
                                    new NotFoundException("The cloth you are looking for does not exist")
                            )
                    )
                    .collect(Collectors.toSet());

            for(Cloth cloth : clothes) {
                cloth.subtractOneQuantity();
                clothRepository.save(cloth);
                cloth.getSales().add(saleToSave);
            }

            saleToSave.setClothes(clothes);
            saleRepository.save(saleToSave);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public SaleListResponseDTO findAllSales() {
        return new SaleListResponseDTO(
                saleRepository.findAll().stream().map(SaleResponseDTO::of).toList()
        );
    }

    @Override
    public SaleResponseDTO findOneSale(Integer id) {
        return SaleResponseDTO.of(
                saleRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException("The sale you are looking for does not exist"))
        );
    }

    @Override
    public Boolean updateSale(Integer code, SaleRequestDTO saleRequestDTO) {
        var saleToUpdate = saleRepository.findById(code);

        if (saleToUpdate.isEmpty())
            return false;

        saleToUpdate.get().getClothes().forEach(cloth -> {
            cloth.sumOneQuantity();
            cloth.getSales().remove(saleToUpdate.get());
            clothRepository.save(cloth);
        });
        var newClothes = saleRequestDTO.clothes()
                .stream()
                .map(cloth -> {
                    var clothFound = clothRepository.findById(cloth.id())
                            .orElseThrow(
                                    () -> new NotFoundException("The cloth you are looking for does not exist")
                            );

                    clothFound.subtractOneQuantity();
                    clothRepository.save(clothFound);
                    clothFound.getSales().add(saleToUpdate.get());

                    return clothFound;
                })
                .collect(Collectors.toSet());

        saleToUpdate.get().setClothes(newClothes);
        saleRepository.save(saleRequestDTO.assign(saleToUpdate.get()));

        return true;
    }

    @Override
    public Boolean deleteSale(Integer id) {
        try {
            var saleToDelete = saleRepository.findById(id);

            if(saleToDelete.isEmpty()) {
                return false;
            }

            var clothes = saleToDelete.get().getClothes();

            for(Cloth cloth : clothes) {
                cloth.getSales().remove(saleToDelete.get());
                clothRepository.save(cloth);
            }

            saleRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public SaleListResponseDTO searchSaleByDate(String date) {
        var sales = saleRepository.findByDate(
                LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        );

        if(sales.isEmpty()) {
            throw new NotFoundException("No sales were found for the date " + date);
        }

        return new SaleListResponseDTO(sales.stream().map(SaleResponseDTO::of).toList());
    }

    @Override
    public ClothesListResponseDTO searchClothesBySaleId(Integer id) {
        var sale = saleRepository.findById(id);

        if(sale.isEmpty()) {
            throw new NotFoundException("The sale you are looking for does not exist");
        }

        return new ClothesListResponseDTO(
                sale.get().getClothes().stream().map(ClothesResponseDTO::of).toList()
        );
    }
}
