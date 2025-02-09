package com.jorge.ejercicio.web.controller;

import java.util.List;

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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping("/all")
	@ApiOperation("get all supermaket products")
	@ApiResponse(code = 200, message = "OK")
	public ResponseEntity<List<Product>> getAll() {
		//return service.getAll();
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
		
	}
	
	@GetMapping("/{productId}")
	@ApiOperation("search a product with an ID")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 404, message = "Product not found")
	})
	public ResponseEntity<Product> getProduct(@ApiParam(value = "The id of the product", required = true, example = "7") 
											  @PathVariable("productId") int productId) {
		return service.getProduct(productId)
				.map(product -> new ResponseEntity<>(product, HttpStatus.OK))
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
