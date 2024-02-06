package com.JPA.demo.repository.interfaces;

import com.JPA.demo.dto.InvoiceDTO;
import com.JPA.demo.repository.interfaces.generics.ICrudService;

public interface IInvoiceService extends ICrudService<InvoiceDTO, Integer> {
}
