package com.ecommerce.app.facturas.service;

import java.util.List;

import com.ecommerce.app.facturas.entity.Factura;

public interface IFacturaService {
	
	public List<Factura> findAll();
	
	public Factura findById(Long id);
	
	public Factura create(Factura factura);
	
	public Factura update(Factura factura, Long id)  throws Exception;
	
	public void deleteById(Long id);

}
