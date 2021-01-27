package com.ecommerce.app.productos.service;

import org.springframework.stereotype.Service;

import com.ecommerce.app.commons.models.productos.Producto;
import com.ecommerce.app.commons.services.CommonService;
import com.ecommerce.app.productos.repository.ProductoRepository;

@Service
public class ProductoService extends CommonService<Producto, ProductoRepository> implements IServiceProductos {
	
	
}
