package com.ecommerce.app.facturas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.app.commons.models.facturas.Factura;


public interface IFacturaRepository extends JpaRepository<Factura, Long> {

}
