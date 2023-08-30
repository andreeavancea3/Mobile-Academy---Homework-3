package com.example.demoJPA.service;

import com.example.demoJPA.dto.PostalDetailsUserDTO;
import com.example.demoJPA.model.Customers;
import com.example.demoJPA.model.Orders;
import com.example.demoJPA.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CustomersService {
    @Autowired
    CustomersRepository customersRepository;

    public List<Customers> getAllCustomers(){
        return customersRepository.findAll();
    }
    public void createCustomer(Customers c){
        customersRepository.save(c);
    }

    public Customers findCustomerByUsername(String username) {
        return customersRepository.findByUsername(username);
    }

    public List<Orders> getAllOrdersForCustomer(Integer customerId) {
        Customers customer = customersRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));

        return customer.getOrders();
}
}
