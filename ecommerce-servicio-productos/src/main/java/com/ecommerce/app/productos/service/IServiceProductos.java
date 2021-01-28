package com.ecommerce.app.productos.service;

import java.util.List;

import com.ecommerce.app.commons.models.productos.Producto;
import com.ecommerce.app.commons.services.ICommonService;

public interface IServiceProductos extends ICommonService<Producto>{

	public List<Producto> findByIdOrDescripcion(String term);
	
}
