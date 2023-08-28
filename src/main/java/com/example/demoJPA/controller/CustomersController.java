package com.example.demoJPA.controller;

import com.example.demoJPA.model.Customers;
import com.example.demoJPA.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomersController {
    @Autowired
    CustomersService customersService;

    @PostMapping(value = "/insertCustomer")
    public void InsertCustomer(){
        Customers c = new Customers();
        c.setUsername("MihailB14");
        c.setFirst_name("Mihail");
        c.setLast_name("Barbulescu");
        c.setPhone("0773844123");
        c.setAddress("Bd. Tineretului");
        c.setCity("Bucuresti");
        c.setPostalCode("123456");
        c.setCountry("Romania");
        customersService.CreateCustomer(c);
    }
}