package com.JPA.demo.service.interfaces;

import com.JPA.demo.dto.CountOfInvoicesDTO;
import com.JPA.demo.dto.InvoiceDTO;
import com.JPA.demo.service.interfaces.generics.ICrudService;

import java.util.List;

public interface IInvoiceService extends ICrudService<InvoiceDTO, Integer> {

    List<CountOfInvoicesDTO> getCountOfInvoicesByClient();


}
