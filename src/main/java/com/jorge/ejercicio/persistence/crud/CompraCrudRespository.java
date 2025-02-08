package com.jorge.ejercicio.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.jorge.ejercicio.persistence.entity.Compra;

public interface CompraCrudRespository extends CrudRepository<Compra, Integer> {

	Optional<List<Compra>> findByIdCliente(String idCliente);
}
