package com.jorge.ejercicio.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jorge.ejercicio.domain.Purchase;
import com.jorge.ejercicio.domain.service.PurchaseService;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

	@Autowired
	private PurchaseService service;
	
	@GetMapping("/all")
	public ResponseEntity<List<Purchase>> getAll() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<List<Purchase>> getByClient(@PathVariable("clientId") String clienteId) {
		return service.getByClient(clienteId)
				.map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/save")
	public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
		return new ResponseEntity<>(service.save(purchase), HttpStatus.OK);
	}
}
