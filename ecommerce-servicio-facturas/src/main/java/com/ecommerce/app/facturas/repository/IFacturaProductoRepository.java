package com.ecommerce.app.facturas.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ecommerce.app.commons.models.facturaproducto.FacturaProducto;

public interface IFacturaProductoRepository extends PagingAndSortingRepository<FacturaProducto, Long> {

}
