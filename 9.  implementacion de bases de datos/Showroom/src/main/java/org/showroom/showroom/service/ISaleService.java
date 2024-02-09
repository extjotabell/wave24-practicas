package org.showroom.showroom.service;

import org.showroom.showroom.dto.request.SaleRequestDTO;
import org.showroom.showroom.dto.response.ClothesListResponseDTO;
import org.showroom.showroom.dto.response.SaleListResponseDTO;
import org.showroom.showroom.dto.response.SaleResponseDTO;

import java.time.LocalDate;

public interface ISaleService {

    Boolean addSale(SaleRequestDTO saleRequestDTO);

    SaleListResponseDTO findAllSales();

    SaleResponseDTO findOneSale(String id);

    Boolean updateSale(String code, SaleRequestDTO saleRequestDTO);

    Boolean deleteSale(String id);

    SaleListResponseDTO searchSaleByDate(LocalDate date);

    ClothesListResponseDTO searchClothesBySaleId(String id);
}
