package com.example.demoJPA.controller;

import com.example.demoJPA.model.Customers;
import com.example.demoJPA.model.Products;
import com.example.demoJPA.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController {
    @Autowired
    ProductsService productsService;

    // create an endpoint which displays all products
    @GetMapping(value="/products")
    public List<Products> getAllProducts(){
        return productsService.getAllProducts();
    }

    // create 10 products in the database
    @PostMapping(value = "/insertProducts")
    public void insertCustomer(){
        List<Products> productsList=new ArrayList<>();

        Products p1 = new Products();
        p1.setName("Juice");
        p1.setDescription("Natural");
        p1.setStock(2);
        p1.setPrice(10.0);

        Products p2 = new Products();
        p2.setName("TV");
        p2.setDescription("LED");
        p2.setStock(2);
        p2.setPrice(1000.0);

        Products p3 = new Products();
        p3.setName("Laptop");
        p3.setDescription("High-performance laptop");
        p3.setStock(5);
        p3.setPrice(1500.0);

        Products p4 = new Products();
        p4.setName("Smartphone");
        p4.setDescription("Latest smartphone model");
        p4.setStock(10);
        p4.setPrice(800.0);

        Products p5 = new Products();
        p5.setName("Headphones");
        p5.setDescription("Noise-canceling headphones");
        p5.setStock(8);
        p5.setPrice(150.0);

        Products p6 = new Products();
        p6.setName("Book");
        p6.setDescription("Bestselling novel");
        p6.setStock(15);
        p6.setPrice(20.0);

        Products p7 = new Products();
        p7.setName("Camera");
        p7.setDescription("High-resolution digital camera");
        p7.setStock(3);
        p7.setPrice(500.0);

        Products p8 = new Products();
        p8.setName("Tablet");
        p8.setDescription("Large screen tablet");
        p8.setStock(7);
        p8.setPrice(300.0);

        Products p9 = new Products();
        p9.setName("Gaming Console");
        p9.setDescription("Latest gaming console");
        p9.setStock(4);
        p9.setPrice(400.0);

        Products p10 = new Products();
        p10.setName("Monitor");
        p10.setDescription("Ultra-wide monitor");
        p10.setStock(6);
        p10.setPrice(350.0);

        productsList.add(p1);
        productsList.add(p2);
        productsList.add(p3);
        productsList.add(p4);
        productsList.add(p5);
        productsList.add(p6);
        productsList.add(p7);
        productsList.add(p8);
        productsList.add(p9);
        productsList.add(p10);

        productsService.insertProduct(productsList);
    }
}

