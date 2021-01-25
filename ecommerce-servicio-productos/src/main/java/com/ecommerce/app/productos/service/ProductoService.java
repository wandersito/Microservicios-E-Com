package com.ecommerce.app.productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.app.productos.entity.Producto;
import com.ecommerce.app.productos.repository.ProductoRepository;

@Service
public class ProductoService implements IServiceProductos {
	
	@Autowired
	private ProductoRepository productos;

	@Override
	@Transactional(readOnly=true)
	public List<Producto> read() {
		return productos.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Producto readOnlyOne(Long id) {
		return productos.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Producto create(Producto producto) {
		return productos.save(producto);
	}

	@Override
	@Transactional
	public Producto update(Producto producto, Long id) throws Exception {
	
		try {
			Producto productoBD = productos.findById(id).orElse(null);
			if(productoBD != null) {
				producto.setId(id);
				return productos.save(producto);
			}else{
				throw new Exception("No se pudo encontrar informacion del producto");
			}
		}catch(Exception e) {
			throw new Exception("Error al actualizar el producto");
		}
		
	}

	@Override
	@Transactional
	public void deleteByid(Long id) {
		productos.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Producto> pageable(Integer pageNo, Integer pageSize, String sortBy) {
		// TODO Auto-generated method stub
		return null;
	}



}
