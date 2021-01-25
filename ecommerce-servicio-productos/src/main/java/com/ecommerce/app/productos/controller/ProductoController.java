package com.ecommerce.app.productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.app.productos.entity.Producto;
import com.ecommerce.app.productos.service.IServiceProductos;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
public class ProductoController {
	
	@Autowired
	private IServiceProductos productoService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Producto>> listar(){
		
		List<Producto> lista = productoService.read(); 
		
		if(!lista.isEmpty()){
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(lista);
		}else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(lista);
		}
		
	}
	
	@GetMapping("/ver/{id}")
	public ResponseEntity<Producto> ver(@PathVariable Long id){
		Producto productoBD = productoService.readOnlyOne(id);
		if(productoBD != null ) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(productoBD);
		}
		else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(productoBD);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<Producto> guardar(@RequestBody Producto producto){
		Producto productoBD = productoService.create(producto);
		if(productoBD != null ) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(productoBD);
		}
		else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(productoBD);
		}
		
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<Producto> editar(@PathVariable Long id, @RequestBody Producto producto) throws Exception{
		Producto productoBD = productoService.update(producto, id);
		if(productoBD != null ) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(productoBD);
		}
		else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(productoBD);
		}
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Producto> eliminar(@PathVariable Long id){
		productoService.deleteByid(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	
	
	
}
