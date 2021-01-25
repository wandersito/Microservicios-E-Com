package com.ecommerce.app.productos.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ecommerce.app.productos.entity.Producto;

public interface IServiceProductos {

	public List<Producto> read();
	
	public Producto readOnlyOne(Long id);
	
	public Producto create(Producto producto);
	
	public Producto update(Producto producto, Long id) throws Exception;
	
	public void deleteByid(Long id);
	
	public Page<Producto> pageable(Integer pageNo, Integer pageSize, String sortBy);
	
}
