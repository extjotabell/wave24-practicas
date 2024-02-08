package com.JPA.demo.service;

import com.JPA.demo.dto.*;
import com.JPA.demo.entity.Client;
import com.JPA.demo.entity.Invoice;
import com.JPA.demo.entity.Person;
import com.JPA.demo.entity.Product;
import com.JPA.demo.repository.interfaces.IClientRepository;
import com.JPA.demo.repository.interfaces.IInvoiceRepository;
import com.JPA.demo.repository.interfaces.IProductRepository;
import com.JPA.demo.service.interfaces.IInvoiceService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceService implements IInvoiceService {

    @Autowired
    IInvoiceRepository invoiceRepository;

    @Autowired
    IClientRepository clientRepository;

    @Autowired
    IProductRepository productRepository;

    @Override
    public InvoiceDTO saveEntity(InvoiceDTO invoiceDTO) {
        Invoice invoice = mapToEntity(invoiceDTO);
        invoice = invoiceRepository.save(invoice);
        return mapToDTO(invoice);
    }

    private Invoice mapToEntity(InvoiceDTO invoiceDTO) {
        Invoice invoice = invoiceRepository.findById(invoiceDTO.id()).orElse(new Invoice());
        invoice.setId(invoiceDTO.id());
        invoice.setDate(invoiceDTO.date());

        Client client = getClient(invoiceDTO.clientDTO().id());
        invoice.setClient(client);

        List<Product> products = getProducts(invoiceDTO.products());
        invoice.setProducts(products);
        return invoice;
    }

    private Client getClient(Integer clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id: " + clientId));
    }

    private List<Product> getProducts(List<ProductDTO> productDTOs) {
        return productDTOs.stream()
                .map(productDTO -> productRepository.findById(productDTO.id())
                        .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productDTO.id())))
                .collect(Collectors.toList());
    }

    private InvoiceDTO mapToDTO(Invoice invoice) {
        return new InvoiceDTO(
                invoice.getId(),
                invoice.getDate(),
                mapToClientDTO(invoice.getClient()),
                null
        );
    }

    private ClientDTO mapToClientDTO(Client client) {
        return new ClientDTO(
                client.getId(),
                client.getEmail(),
                client.getCardNumber(),
                mapToPersonDTO(client.getPerson())
        );
    }

    private PersonDTO mapToPersonDTO(Person person) {
        return new PersonDTO(
                person.getId(),
                person.getFirstname(),
                person.getLastname(),
                person.getDni(),
                person.getBirthDate(),
                person.getAge(),
                person.getSalary()
        );
    }

    @Override
    public InvoiceDTO getEntityById(Integer integer) {
        return null;
    }

    @Override
    public List<InvoiceDTO> getAllEntities() {
        return null;
    }

    @Override
    public MessageDTO deleteEntity(Integer integer) {
        return null;
    }

    @Override
    public List<CountOfInvoicesDTO> getCountOfInvoicesByClient() {

        var result = invoiceRepository.getCountOfInvocesByClient();

        return result.stream()
                .map(entry -> new CountOfInvoicesDTO(entry.get("id"), entry.get("count")))
                .collect(Collectors.toList());
    }

    //@Override
    //public InvoiceDTO getEntityById(Integer integer) {
//
    //    Invoice invoices = InvoiceRepository.findById(integer)
    //            .orElseThrow();
//
    //    return new InvoiceDTO(
    //            invoices.getId(),
    //            invoices.getDate()
    //    );
    //}
//
    //@Override
    //public List<InvoiceDTO> getAllEntities() {
//
    //    List<Invoice> invoices = InvoiceRepository.findAll();
//
    //    return invoices.stream().map(
    //            invoice -> new InvoiceDTO(
    //                    invoice.getId(),
    //                    invoice.getDate()
    //            )).toList();
    //}
//
    //@Override
    //public MessageDTO deleteEntity(Integer id) {
//
    //    InvoiceRepository.deleteById(id);
    //    if(InvoiceRepository.existsById(id))
    //        return new MessageDTO(
    //                "Se eliminó el invoice con id: " + id,
    //                "Eliminacion"
    //        );
    //    else
    //        return new MessageDTO(
    //                "No existe o no se pudo eliminar el invoice con id: " + id,
    //                "Eliminacion"
    //        );
    //}
}
