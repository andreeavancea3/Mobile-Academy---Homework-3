package com.example.demoJPA.controller;

import com.example.demoJPA.dto.PostalDetailsUserDTO;
import com.example.demoJPA.model.Customers;
import com.example.demoJPA.model.OrderDetails;
import com.example.demoJPA.model.Orders;
import com.example.demoJPA.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomersController {
    @Autowired
    CustomersService customersService;
    @GetMapping(value="/customers")
    public List<Customers> getAllTasks(){
        return customersService.getAllCustomers();
    }

    // create a new customer
    @PostMapping(value = "/insertCustomer")
    public void insertCustomer(){
        Customers c = new Customers();
        c.setUsername("MihailB14");
        c.setFirst_name("Mihail");
        c.setLast_name("Barbulescu");
        c.setPhone("0773844123");
        c.setAddress("Bd. Tineretului");
        c.setCity("Bucuresti");
        c.setPostalCode("123456");
        c.setCountry("Romania");
        customersService.createCustomer(c);
    }

    //create an endpoint that can display all orders belonging to a customer
    @GetMapping("/{customerId}/orders")
    public ResponseEntity<List<Orders>> getAllOrdersForCustomer(@PathVariable Integer customerId) {
        List<Orders> orders = customersService.getAllOrdersForCustomer(customerId);
        return ResponseEntity.ok(orders);
    }

    // create a DTO to return only the address, phone and city of the customer,
    // called PostalDetailsUserDTO. Create an endpoint which will return the postal
    // details of an user, given his username as input
    @GetMapping(value="/postaldetails/{username}")
    public PostalDetailsUserDTO getPostalDetailsByUsername(@PathVariable String username){
        Customers customer = customersService.findCustomerByUsername(username);
        if (customer == null) {
            return null;
        }
      PostalDetailsUserDTO postalDetailsUserDTO=new PostalDetailsUserDTO();
        postalDetailsUserDTO.setAddress(customer.getAddress());
        postalDetailsUserDTO.setCity(customer.getCity());
        postalDetailsUserDTO.setPhone(customer.getPhone());

        return postalDetailsUserDTO;
    }
}
