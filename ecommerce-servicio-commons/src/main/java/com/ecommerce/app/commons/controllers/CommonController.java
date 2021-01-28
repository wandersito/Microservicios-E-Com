package com.ecommerce.app.commons.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ecommerce.app.commons.services.ICommonService;

//@CrossOrigin(origins= {"http://localhost:4200"})
public class CommonController<T, S extends ICommonService<T>> {
	
	@Autowired
	protected S service;
	
	@GetMapping("/listar")
	public ResponseEntity<List<T>> listar() throws Exception{
		
		List<T> lista = service.findAll(); 
		
		if(!lista.isEmpty()){
			return ResponseEntity.status(HttpStatus.OK).body(lista);
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@GetMapping("/ver/{id}")
	public ResponseEntity<T> ver(@PathVariable Long id) throws Exception{
		T entityBD = service.findById(id);
		if(service != null ) {
			return ResponseEntity.status(HttpStatus.OK).body(entityBD);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> guardar(@Valid @RequestBody T entity, BindingResult result){
		if(result.hasErrors()) {
			return this.validar(result);
		}
		
		T entityBD = service.save(entity);
		if(entityBD != null ) {
			return ResponseEntity.status(HttpStatus.CREATED).body(entityBD);
		}
		else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<T> eliminar(@PathVariable Long id){
		service.deleteByid(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	protected ResponseEntity<?> validar(BindingResult result){
		Map<String, Object> errores = new HashMap<>();
		result.getFieldErrors().forEach( err -> {
			errores.put(err.getField(), err.getDefaultMessage() );
		});
		return ResponseEntity.badRequest().body(errores);
	}
	
}
