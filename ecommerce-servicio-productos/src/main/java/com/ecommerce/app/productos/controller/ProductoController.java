package com.ecommerce.app.productos.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.app.commons.controllers.CommonController;
import com.ecommerce.app.commons.models.productos.Producto;
import com.ecommerce.app.productos.service.ProductoService;

//@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
public class ProductoController extends CommonController<Producto, ProductoService> {
	
	@GetMapping("/uploads/img/{id}")
	public ResponseEntity<?> verFoto(@PathVariable Long id) throws Exception{
		Producto productoDB = service.findById(id);
		
		if(productoDB == null || productoDB.getFoto() == null){
			return ResponseEntity.notFound().build();
		}
		
		Resource imagen = new ByteArrayResource(productoDB.getFoto()); 
		
		return ResponseEntity.ok()
				.contentType(MediaType.IMAGE_JPEG).body(imagen);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Producto producto, BindingResult result, @PathVariable Long id) throws Exception{
		if(result.hasErrors()) {
			return this.validar(result);
		}
		Producto productoBD = service.findById(id);
		if(productoBD != null ) {
			producto.setId(id);
			return ResponseEntity.status(HttpStatus.OK).body(service.save(producto));
		}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(producto);
	}
	
	@GetMapping("/buscar/{term}")
	public ResponseEntity<List<Producto>> buscar(@PathVariable String term){
		return ResponseEntity.ok(service.findByIdOrDescripcion(term));
	}

	@PostMapping("/crear-con-foto")
	public ResponseEntity<?> guardarConFoto(@Valid Producto producto, BindingResult result, @RequestParam MultipartFile archivo) throws IOException {	
		if(!archivo.isEmpty()) {
			producto.setFoto(archivo.getBytes());
		}
		return super.guardar(producto, result);
	}
	
	@PutMapping("/editar-con-foto/{id}")
	public ResponseEntity<?> editarConFoto(@Valid Producto producto, BindingResult result, @PathVariable Long id, 
											@RequestParam MultipartFile archivo) throws Exception{
		if(result.hasErrors()) {
			return this.validar(result);
		}
		Producto productoBD = service.findById(id);
		if(productoBD != null ) {
			producto.setId(id);
			if(!archivo.isEmpty()) {
				producto.setFoto(archivo.getBytes());
			}
			return ResponseEntity.status(HttpStatus.OK).body(service.save(producto));
		}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(producto);
	}
	
	
}
