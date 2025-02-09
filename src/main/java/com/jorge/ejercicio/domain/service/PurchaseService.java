package com.jorge.ejercicio.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorge.ejercicio.domain.Purchase;
import com.jorge.ejercicio.domain.repository.PurchaseRepository;

@Service
public class PurchaseService {

	@Autowired
	private PurchaseRepository repo;
	
	public List<Purchase> getAll() {
		return repo.getAll();
	}
	
	public Optional<List<Purchase>> getByClient(String clienteId) {
		return repo.getByCliente(clienteId);
	}
	
	public Purchase save(Purchase purchase) {
		return repo.save(purchase);
	}
}
