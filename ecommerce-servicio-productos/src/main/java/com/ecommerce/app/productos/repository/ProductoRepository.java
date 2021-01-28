package com.ecommerce.app.productos.repository;

import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ecommerce.app.commons.models.productos.Producto;


public interface ProductoRepository extends PagingAndSortingRepository<Producto, Long>{

	@Query("select p from Producto p where p.nombre like %?1% or p.descripcion like %?1% ")
	public List<Producto> findByIdOrDescripcion(String term);
	
}
