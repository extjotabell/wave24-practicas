package com.ander.DTOexample.controller;

import com.ander.DTOexample.dto.CustomerDTO;
import com.ander.DTOexample.modelo.Adress;
import com.ander.DTOexample.modelo.Customer;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller
{
    @GetMapping("/{customerID}")
    @ResponseBody
    //devolver la consulta
    public CustomerDTO getCustomer(@PathVariable long customerID){
        Customer customer = new Customer();
        Adress address = new Adress();
        CustomerDTO customerDTO = new CustomerDTO( 101010, "Anderson", "Boyaca");
        return customerDTO;


    }
}
