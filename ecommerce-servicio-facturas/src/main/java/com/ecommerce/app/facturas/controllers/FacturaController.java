package com.ecommerce.app.facturas.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.app.commons.controllers.CommonController;
import com.ecommerce.app.commons.models.facturas.Factura;
import com.ecommerce.app.commons.models.productos.Producto;
import com.ecommerce.app.facturas.service.FacturaService;

@RestController
public class FacturaController extends CommonController<Factura, FacturaService>{
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<Factura> editar(@PathVariable Long id, 
			@RequestBody Factura factura) throws Exception{
		
		Factura facturaBD = service.findById(id);
		if(facturaBD != null ) {
			factura.setId(id);
			return ResponseEntity.status(HttpStatus.OK).body(service.save(factura));
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@PutMapping("/{id}/agregar-productos")
	public ResponseEntity<Factura> agregarProductos(@PathVariable Long id, 
			@RequestBody List<Producto> productos) throws Exception{
		
		Factura factura = service.findById(id);
		
		if(factura != null) {
			factura.setId(id);
			productos.forEach( producto -> {
			factura.addProductos(producto);
		});
		
		return ResponseEntity.status(HttpStatus.OK).body(service.save(factura));
		}
		return ResponseEntity.status(HttpStatus.OK).body(null);	
	}
	
	@PutMapping("/{id}/eliminar-productos")
	public ResponseEntity<Factura> eliminarProductos(@PathVariable Long id, 
			@RequestBody Producto producto) throws Exception{
		
		Factura factura = service.findById(id);
		if(factura != null) {
			factura.setId(id);
			factura.removeProductos(producto);
		return ResponseEntity.status(HttpStatus.OK).body(service.save(factura));
		}
		return ResponseEntity.status(HttpStatus.OK).body(null);	
	}
	
	@GetMapping("/producto/{id}")
	public ResponseEntity<Factura> buscarFacturaPorProductoId(@PathVariable Long id){
		return ResponseEntity.ok(service.findFacturaByProducto(id));
	}

}
