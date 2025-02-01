package com.jorge.ejercicio.domain.repository;

import java.util.List;
import java.util.Optional;

import com.jorge.ejercicio.domain.Product;

public interface ProductRepository {

	public List<Product> getAll();
	public Optional<List<Product>> getByCategory(int categoryId);
	public Optional<List<Product>> getScarseProducts(int quantity);
	public Optional <Product> getProduct(int productId);
	public Product save(Product p);
	public void delete(int productId);
}
