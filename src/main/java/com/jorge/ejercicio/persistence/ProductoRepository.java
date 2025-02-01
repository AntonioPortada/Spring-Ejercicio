package com.jorge.ejercicio.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.jorge.ejercicio.persistence.crud.ProductoCrudRepository;
import com.jorge.ejercicio.persistence.entity.Producto;

@Repository
public class ProductoRepository {

	private ProductoCrudRepository repo;
	
	public List<Producto> getAll() {
		return (List<Producto>) repo.findAll();
	}
	
	public List<Producto> getByCategoria(int idCategoria) {
		return repo.findByIdCategoria(idCategoria);
	}
	
	public Optional<List<Producto>> getEscasos(int cantidad, boolean estado) {
		return repo.findByCantidadStockLessThanAndEstado(cantidad, estado);
	}
	
	public Optional<Producto> getProducto(int idProducto) {
		return repo.findById(idProducto);
	}
	
	public Producto save(Producto producto) {
		return repo.save(producto);
	}
	
	public void delete(int idProducto) {
		repo.deleteById(idProducto);
	}
}
