package com.example.demoJPA.service;

import com.example.demoJPA.model.Customers;
import com.example.demoJPA.model.OrderDetails;
import com.example.demoJPA.model.Products;
import com.example.demoJPA.repository.OrderDetailsRepository;
import com.example.demoJPA.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {
@Autowired
    OrderDetailsRepository orderDetailsRepository;
@Autowired
    ProductsRepository productsRepository;

public void addProductsToOrder(Customers customer, List<Products> productsList){
    for(Products product:productsList) {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setCustomer(customer);
        orderDetails.setProduct_code(product.getCode());
        orderDetails.setQuantity(product.getStock());
        orderDetails.setPriceEach(product.getPrice());

        orderDetailsRepository.save(orderDetails);
    }
}
    public Products findProductByCode(Long code) {
        return productsRepository.getById(String.valueOf(code));
    }}



