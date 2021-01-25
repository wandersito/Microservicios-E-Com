//package com.ecommerce.app.facturas.client.rest;
//
//import java.util.List;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//
//import com.ecommerce.app.commons.entity.Producto;
//
////@FeignClient(name="ecommerce-servicio-productos")
//public interface IProductoRest {
//	
//	@GetMapping("/listar")
//	public List<Producto> read();
//	
//	@GetMapping("/ver/{id}")
//	public Producto readOnlyOne(Long id);
//	
//	@PostMapping("/crear")
//	public Producto create(Producto producto);
//	
//	@PutMapping("/editar/{id}")
//	public Producto update(Producto producto, Long id) throws Exception;
//	
//	@DeleteMapping("/eliminar/{id}")
//	public void deleteByid(Long id);
//
//}
