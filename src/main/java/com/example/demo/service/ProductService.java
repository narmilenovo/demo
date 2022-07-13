package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public product saveproduct(product p) {
	return	repository.save(p);
	}
	 public List<product> saveProducts(List<product> products) {
	        return repository.saveAll(products);
	    }

	    public List<product> getProducts() {
	        return repository.findAll();
	    }

	    public product getProductById(int id) {
	        return repository.findById(id).orElse(null);
	    }

	    public product getProductByName(String name) {
	        return repository.findByName(name);
	    }

	    public String deleteProduct(int id) {
	        repository.deleteById(id);
	        return "product removed !! " + id;
	    }

	    public product updateProduct(product product) {
	        product existingProduct = repository.findById(product.getId()).orElse(null);
	        existingProduct.setName(product.getName());
	        existingProduct.setQuantity(product.getQuantity());
	        existingProduct.setPrice(product.getPrice());
	        return repository.save(existingProduct);
	    }
	
}
