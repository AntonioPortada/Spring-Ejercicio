package com.jorge.ejercicio.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jorge.ejercicio.domain.Product;
import com.jorge.ejercicio.domain.repository.ProductRepository;
import com.jorge.ejercicio.persistence.crud.ProductoCrudRepository;
import com.jorge.ejercicio.persistence.entity.Producto;
import com.jorge.ejercicio.persistence.mapper.ProductMapper;

@Repository
public class ProductoRepository implements ProductRepository {

	@Autowired
	private ProductoCrudRepository repo;
	
	@Autowired
	private ProductMapper mapper;
	
	@Override
	public List<Product> getAll() {
		List<Producto> producto = (List<Producto>) repo.findAll();
		return mapper.toProducts(producto);
	}
	
	public void delete(int idProducto) {
		repo.deleteById(idProducto);
	}

	@Override
	public Optional<List<Product>> getByCategory(int categoryId) {
		List<Producto> productos = repo.findByIdCategoria(categoryId);
		return Optional.of(mapper.toProducts(productos));
	}

	@Override
	public Optional<List<Product>> getScarseProducts(int quantity) {
		Optional<List<Producto>> productos = repo.findByCantidadStockLessThanAndEstado(quantity, true);
		return productos.map(prods -> mapper.toProducts(prods));
	}

	@Override
	public Optional<Product> getProduct(int productId) {
		return repo.findById(productId).map(prod -> mapper.toProduct(prod));
	}

	@Override
	public Product save(Product p) {
		Producto producto = mapper.toProducto(p);
		return mapper.toProduct(producto);
	}
}
