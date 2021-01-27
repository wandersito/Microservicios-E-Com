package com.ecommerce.app.commons.controllers;

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

import com.ecommerce.app.commons.services.ICommonService;

//@CrossOrigin(origins= {"http://localhost:4200"})
public class CommonController<T, S extends ICommonService<T>> {
	
	@Autowired
	protected S service;
	
	@GetMapping("/listar")
	public ResponseEntity<List<T>> listar() throws Exception{
		
		List<T> lista = service.read(); 
		
		if(!lista.isEmpty()){
			return ResponseEntity.status(HttpStatus.OK).body(lista);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(lista);
		}
		
	}
	
	@GetMapping("/ver/{id}")
	public ResponseEntity<T> ver(@PathVariable Long id) throws Exception{
		T entityBD = service.readOnlyOne(id);
		if(service != null ) {
			return ResponseEntity.status(HttpStatus.OK).body(entityBD);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(entityBD);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<T> guardar(@RequestBody T entity){
		T entityBD = service.create(entity);
		if(entityBD != null ) {
			return ResponseEntity.status(HttpStatus.CREATED).body(entityBD);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(entityBD);
		}
		
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<T> editar(@PathVariable Long id, @RequestBody T entity) throws Exception{
		T entityBD = service.update(entity, id);
		if(entityBD != null ) {
			return ResponseEntity.status(HttpStatus.OK).body(entityBD);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(entityBD);
		}
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<T> eliminar(@PathVariable Long id){
		service.deleteByid(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	
	
	
}
