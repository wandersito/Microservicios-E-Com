package com.ecommerce.app.productos.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.app.commons.models.productos.Producto;
import com.ecommerce.app.commons.services.CommonService;
import com.ecommerce.app.productos.repository.ProductoRepository;

@Service
public class ProductoService extends CommonService<Producto, ProductoRepository> implements IServiceProductos {

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByIdOrDescripcion(String term) {
		return repository.findByIdOrDescripcion(term);
	}

}
