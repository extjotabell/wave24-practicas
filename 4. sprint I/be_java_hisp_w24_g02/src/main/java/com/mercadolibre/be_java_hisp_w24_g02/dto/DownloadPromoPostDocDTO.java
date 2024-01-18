package com.mercadolibre.be_java_hisp_w24_g02.dto;

public record DownloadPromoPostDocDTO(
        Integer userId,
        String date,
        Integer productId,
        String productName,
        Integer category,
        Double price,
        Boolean hasPromo,
        Double discount
) {}
