package com.jorge.ejercicio.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.jorge.ejercicio.domain.Purchase;
import com.jorge.ejercicio.persistence.entity.Compra;

@Mapper(componentModel = "spring", uses = { PurchaseItemMapper.class })
public interface PurchaseMapper {

	@Mappings({
		@Mapping(source = "idCompra", target = "purchaseId"),
		@Mapping(source = "idCliente", target = "clienteId"),
		@Mapping(source = "fecha", target = "date"),
		@Mapping(source = "medioPago", target = "paymentMethod"),
		@Mapping(source = "comentario", target = "comment"),
		@Mapping(source = "estado", target = "state"),
		@Mapping(source = "productos", target = "item")
	})
	Purchase toPurchase(Compra compra);
	List<Purchase> toPurchases(List<Compra> compras);
	
	@InheritInverseConfiguration
	@Mapping(target = "cliente", ignore = true)
	Compra toCompra(Purchase purchase);
}
