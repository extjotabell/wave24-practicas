package com.JPA.demo.repository.interfaces;

import com.JPA.demo.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface IInvoiceRepository extends JpaRepository<Invoice, Integer> {

    @Query("SELECT new map(i.client.id as id, COUNT(i.id) as count) FROM Invoice i GROUP BY i.client.id")
    List<Map<Integer, Long>> getCountOfInvocesByClient();

}