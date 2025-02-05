package com.jorge.ejercicio.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorge.ejercicio.domain.Product;
import com.jorge.ejercicio.domain.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	public List<Product> getAll() {
		return repo.getAll();
	}
	
	public Optional<Product> getProduct(int productId) {
		return repo.getProduct(productId);
	}
	
	public Optional<List<Product>> getByCategory(int categoryId) {
		return repo.getByCategory(categoryId);
	}
	
	public Product save(Product product) {
		return repo.save(product);
	}
	
	public boolean delete(int productId) {
		/*return getProduct(productId).map(pro -> {
			repo.delete(productId);
			return true;
		}).orElse(false);*/
		
		if(getProduct(productId).isPresent()) {
			return true;
		} else {
			return false;
		}
	}
}
