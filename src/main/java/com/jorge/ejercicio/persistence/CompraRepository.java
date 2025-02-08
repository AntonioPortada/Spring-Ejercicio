package com.jorge.ejercicio.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jorge.ejercicio.domain.Purchase;
import com.jorge.ejercicio.domain.repository.PurchaseRepository;
import com.jorge.ejercicio.persistence.crud.CompraCrudRespository;
import com.jorge.ejercicio.persistence.entity.Compra;
import com.jorge.ejercicio.persistence.mapper.PurchaseMapper;

@Repository
public class CompraRepository implements PurchaseRepository {

	@Autowired
	private CompraCrudRespository repo;
	
	@Autowired
	private PurchaseMapper mapper;
	
	@Override
	public List<Purchase> getAll() {
		return mapper.toPurchases((List<Compra>) repo.findAll());
	}

	@Override
	public Optional<List<Purchase>> getByCliente(String clientId) {
		return repo.findByIdCliente(clientId)
				.map(compras -> mapper.toPurchases(compras));
	}

	@Override
	public Purchase save(Purchase purchase) {
		Compra compra = mapper.toCompra(purchase);
		compra.getProductos().forEach(producto -> producto.setCompra(compra));
		return mapper.toPurchase(repo.save(compra));
	}

	
}
