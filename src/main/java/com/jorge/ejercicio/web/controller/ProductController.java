package com.jorge.ejercicio.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jorge.ejercicio.domain.Product;
import com.jorge.ejercicio.domain.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping("/all")
	public List<Product> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/{productId}")
	public Optional<Product> getProduct(@PathVariable("productId") int productId) {
		return service.getProduct(productId);
	}
	
	@GetMapping("category/categoriId")
	public Optional<List<Product>> getByCategory(@PathVariable("categoriId") int categoryId) {
		return service.getByCategory(categoryId);
	}
	
	@PostMapping("/save")
	public Product save(@RequestBody Product product) {
		return service.save(product);
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable("id") int productId) {
		return service.delete(productId);
	}
}
