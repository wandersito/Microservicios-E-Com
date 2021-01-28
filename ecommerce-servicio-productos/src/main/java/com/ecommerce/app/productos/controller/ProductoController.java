package com.ecommerce.app.productos.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.app.commons.controllers.CommonController;
import com.ecommerce.app.commons.models.productos.Producto;
import com.ecommerce.app.productos.service.ProductoService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
public class ProductoController extends CommonController<Producto, ProductoService> {
	
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<Producto> editar(@PathVariable Long id, @RequestBody Producto producto) throws Exception{
		Producto productoBD = service.findById(id);
		if(productoBD != null ) {
			producto.setId(id);
			return ResponseEntity.status(HttpStatus.OK).body(service.save(producto));
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(producto);
		}
	}
	
	@GetMapping("/buscar/{term}")
	public ResponseEntity<List<Producto>> buscar(@PathVariable String term){
		return ResponseEntity.ok(service.findByIdOrDescripcion(term));
	}
	
	
	
}
