package com.jorge.ejercicio.domain.repository;

import java.util.List;
import java.util.Optional;

import com.jorge.ejercicio.domain.Purchase;

public interface PurchaseRepository {

	List<Purchase> getAll();
	Optional<List<Purchase>> getByCliente(String clientId);
	Purchase save(Purchase purchase);
}
