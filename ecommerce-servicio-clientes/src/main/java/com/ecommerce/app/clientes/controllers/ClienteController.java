package com.ecommerce.app.clientes.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ecommerce.app.clientes.service.ClienteService;
import com.ecommerce.app.commons.controllers.CommonController;
import com.ecommerce.app.commons.models.cliente.Cliente;

public class ClienteController extends CommonController<Cliente, ClienteService>{

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
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
}
