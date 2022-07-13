package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.product;
import com.example.demo.service.ProductService;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;
    
    @GetMapping("/hello")
    public String hello()
    {
    	return "welcome";
    }

    @PostMapping("/addProduct")
    public product addProduct(@RequestBody product product) {
        return service.saveproduct(product);
    }

    @PostMapping("/addProducts")
    public List<product> addProducts(@RequestBody List<product> products) {
        return service.saveProducts(products);
    }

    @GetMapping("/products")
    public List<product> findAllProducts() {
        return service.getProducts();
    }

    @GetMapping("/productById/{id}")
    public product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/product/{name}")
    public product findProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }

    @PutMapping("/update")
    public product updateProduct(@RequestBody product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
}