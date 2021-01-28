package com.ecommerce.app.facturas.restService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.app.commons.models.productos.Producto;

@FeignClient(name="ecommerce-servicio-productos")
public interface RestProducto {

	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id);
	
}
