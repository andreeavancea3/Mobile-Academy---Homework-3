package com.example.demoJPA.controller;

import com.example.demoJPA.model.Customers;
import com.example.demoJPA.model.OrderDetails;
import com.example.demoJPA.model.Products;
import com.example.demoJPA.repository.CustomersRepository;
import com.example.demoJPA.repository.OrderDetailsRepository;
import com.example.demoJPA.repository.ProductsRepository;
import com.example.demoJPA.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderDetailsController {
    @Autowired
    OrderDetailsService orderDetailsService;

    @Autowired
    CustomersRepository customersRepository;
    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    @PostMapping("/addProductsToOrder")
    public ResponseEntity<String> addProductsToOrder(
            @RequestParam("customerId") Integer customerId,
            @RequestBody List<String> productCodes
    ) {
        Customers customer = customersRepository.findById(customerId).orElse(null);

        if (customer == null) {
            return ResponseEntity.badRequest().body("Invalid customer");
        }

        List<Products> productsList = new ArrayList<>();
        for (String productCode : productCodes) {
            Products product = productsRepository.findByCode(Long.parseLong(productCode));
            if (product != null) {
                productsList.add(product);
            }
        }

        if (productsList.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid products");
        }

        orderDetailsService.addProductsToOrder(customer, productsList);

        return ResponseEntity.ok("Products added to order successfully");
    }

    @GetMapping("/orderDetails/{customerId}")
    public ResponseEntity<List<OrderDetails>> getOrderDetailsForCustomer(@PathVariable Integer customerId) {
        Customers customer = customersRepository.findById(customerId).orElse(null);

        if (customer == null) {
            return ResponseEntity.badRequest().body(null);
        }

        List<OrderDetails> orderDetailsList = orderDetailsRepository.findByCustomer(customer);

        return ResponseEntity.ok(orderDetailsList);
    }

}