package com.ecommerce.app.facturas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.app.facturas.entity.Factura;

public interface IFacturaRepository extends JpaRepository<Factura, Long> {

}
