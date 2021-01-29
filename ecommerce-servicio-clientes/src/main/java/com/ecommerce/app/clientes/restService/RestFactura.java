package com.ecommerce.app.clientes.restService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.app.commons.models.facturas.Factura;

@FeignClient(name="ecommerce-servicio-facturas")
public interface RestFactura {
	
	@GetMapping("/ver/{id}")
	public Factura ver(@PathVariable Long id);

}
