package com.JPA.demo.repository.interfaces;

import com.JPA.demo.dto.ProductDTO;
import com.JPA.demo.repository.interfaces.generics.ICrudService;

public interface IProductService extends ICrudService<ProductDTO, Integer> {
}
