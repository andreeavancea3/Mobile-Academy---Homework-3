package com.example.demoJPA.service;

import com.example.demoJPA.model.Customers;
import com.example.demoJPA.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
