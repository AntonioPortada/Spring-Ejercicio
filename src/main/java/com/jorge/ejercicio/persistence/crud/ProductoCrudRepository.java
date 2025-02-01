package com.jorge.ejercicio.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jorge.ejercicio.persistence.entity.Producto;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

	//@Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
	public List<Producto> findByIdCategoria(int idCategoria);
	
	public Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
