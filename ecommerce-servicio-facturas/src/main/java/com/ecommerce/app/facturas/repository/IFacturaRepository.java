package com.ecommerce.app.facturas.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ecommerce.app.commons.models.facturas.Factura;


public interface IFacturaRepository extends PagingAndSortingRepository<Factura, Long> {

	@Query("select f from Factura f join fetch f.productos p where p.id=?1")
	public Factura findFacturaByProducto(Long id);
	
}
