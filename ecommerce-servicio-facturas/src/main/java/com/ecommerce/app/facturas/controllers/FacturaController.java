package com.ecommerce.app.facturas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.app.facturas.entity.Factura;
import com.ecommerce.app.facturas.service.FacturaService;

@RestController
public class FacturaController {
	
	@Autowired
	FacturaService facturaService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Factura>> listar(){
		
		List<Factura> lista = facturaService.findAll(); 
		
		if(!lista.isEmpty()){
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(lista);
		}else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(lista);
		}
		
	}
	
	@GetMapping("/ver/{id}")
	public ResponseEntity<Factura> ver(@PathVariable Long id){
		Factura facturaBD = facturaService.findById(id);
		if(facturaBD != null ) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(facturaBD);
		}
		else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(facturaBD);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<Factura> guardar(@RequestBody Factura factura){
		Factura facturaBD = facturaService.create(factura);
		if(facturaBD != null ) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(facturaBD);
		}
		else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(facturaBD);
		}
		
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<Factura> editar(@PathVariable Long id, @RequestBody Factura factura) throws Exception{
		Factura facturaBD = facturaService.update(factura, id);
		if(facturaBD != null ) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(facturaBD);
		}
		else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(facturaBD);
		}
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Factura> eliminar(@PathVariable Long id){
		facturaService.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

}
