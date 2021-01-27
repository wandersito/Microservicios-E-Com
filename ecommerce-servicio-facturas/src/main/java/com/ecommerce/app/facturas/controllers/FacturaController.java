package com.ecommerce.app.facturas.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.app.commons.controllers.CommonController;
import com.ecommerce.app.facturas.entity.Factura;
import com.ecommerce.app.facturas.service.FacturaService;

@RestController
public class FacturaController extends CommonController<Factura, FacturaService>{
	
//	@Autowired
//	FacturaService facturaService;
//	
//	@GetMapping("/listar")
//	public ResponseEntity<List<Factura>> listar() throws Exception{
//		
//		List<Factura> lista = facturaService.read(); 
//		
//		if(!lista.isEmpty()){
//			return ResponseEntity.status(HttpStatus.OK).body(lista);
//		}else {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(lista);
//		}
//		
//	}
//	
//	@GetMapping("/ver/{id}")
//	public ResponseEntity<Factura> ver(@PathVariable Long id) throws Exception{
//		Factura facturaBD = facturaService.readOnlyOne(id);
//		if(facturaBD != null ) {
//			return ResponseEntity.status(HttpStatus.OK).body(facturaBD);
//		}
//		else {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(facturaBD);
//		}
//	}
//	
//	@PostMapping("/crear")
//	public ResponseEntity<Factura> guardar(@RequestBody Factura factura){
//		Factura facturaBD = facturaService.create(factura);
//		if(facturaBD != null ) {
//			return ResponseEntity.status(HttpStatus.CREATED).body(facturaBD);
//		}
//		else {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(facturaBD);
//		}
//		
//	}
//	
//	@PutMapping("/editar/{id}")
//	public ResponseEntity<Factura> editar(@PathVariable Long id, @RequestBody Factura factura) throws Exception{
//		Factura facturaBD = facturaService.update(factura, id);
//		if(facturaBD != null ) {
//			return ResponseEntity.status(HttpStatus.OK).body(facturaBD);
//		}
//		else {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(facturaBD);
//		}
//	}
//	
//	@DeleteMapping("/eliminar/{id}")
//	public ResponseEntity<Factura> eliminar(@PathVariable Long id){
//		facturaService.deleteById(id);
//		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
//	}

}
