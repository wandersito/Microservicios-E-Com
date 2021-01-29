package com.ecommerce.app.clientes.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.app.clientes.restService.RestFactura;
import com.ecommerce.app.clientes.service.ClienteService;
import com.ecommerce.app.commons.controllers.CommonController;
import com.ecommerce.app.commons.models.cliente.Cliente;
import com.ecommerce.app.commons.models.facturas.Factura;

@RestController
public class ClienteController extends CommonController<Cliente, ClienteService>{
	
	@Autowired
	private RestFactura facturaRest;

	@PutMapping("/editar/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Cliente cliente, BindingResult result, @PathVariable Long id)
			 throws Exception{
		
		if(result.hasErrors()) {
			return this.validar(result);
		}
		
		Cliente clienteBD = service.findById(id);
		if(clienteBD != null ) {
			cliente.setId(id);
			return ResponseEntity.status(HttpStatus.OK).body(service.save(cliente));
		}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	@PutMapping("/{id}/agregar-facturas")
	public ResponseEntity<Cliente> agregarProductos(@PathVariable Long id, 
			@RequestBody List<Factura> facturas) throws Exception{
		
		Cliente cliente = service.findById(id);
		if(cliente != null) {
			cliente.setId(id);
			facturas.forEach( factura -> {
					cliente.addFacturas(facturaRest.ver(id));
		});
		
		return ResponseEntity.status(HttpStatus.OK).body(service.save(cliente));
		}
		return ResponseEntity.status(HttpStatus.OK).body(null);	
	}
	
}
