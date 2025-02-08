package com.jorge.ejercicio.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Product>> getAll() {
		//return service.getAll();
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
		
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable("productId") int productId) {
		return service.getProduct(productId)
				.map(product -> new ResponseEntity<>(product, HttpStatus.ACCEPTED.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
	}
	
	@GetMapping("category/categoriId")
	public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoriId") int categoryId) {
		return service.getByCategory(categoryId)
				.map(products -> new ResponseEntity<>(products, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/save")
	public ResponseEntity<Product> save(@RequestBody Product product) {
		return new ResponseEntity<>(service.save(product), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity delete(@PathVariable("id") int productId) {
		HttpStatus result = service.delete(productId) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity(result);
	}
}
