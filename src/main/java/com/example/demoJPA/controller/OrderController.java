package com.example.demoJPA.controller;

import com.example.demoJPA.model.Orders;
import com.example.demoJPA.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping("/{orderId}/add-products")
    public ResponseEntity<String> addProductsToOrder(
            @PathVariable Integer orderId,
            @RequestBody List<Long> productCodes) {
        orderService.addProductsToOrder(orderId, productCodes);
        return ResponseEntity.ok("Products added to order successfully");
    }
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Orders>> getOrdersByCustomer(@PathVariable Integer customerId) {
        List<Orders> orders = orderService.getOrdersByCustomer(customerId);
        return ResponseEntity.ok(orders);
    }
}


