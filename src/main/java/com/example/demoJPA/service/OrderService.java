package com.example.demoJPA.service;

import com.example.demoJPA.model.Customers;
import com.example.demoJPA.model.Orders;
import com.example.demoJPA.model.Products;
import com.example.demoJPA.repository.CustomersRepository;
import com.example.demoJPA.repository.OrdersRepository;
import com.example.demoJPA.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private CustomersRepository customersRepository;
    @Autowired
    private ProductsRepository productsRepository;

    public void addProductsToOrder(Integer orderId, List<Long> productCodes) {
        Orders order = ordersRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));

        List<Products> productsToAdd = productsRepository.findAllByCodeIn(productCodes);

        order.getProducts().addAll(productsToAdd);
        ordersRepository.save(order);
    }
    public List<Orders> getOrdersByCustomer(Integer customerId) {
        return ordersRepository.findByCustomerId(customerId);
    }

}
