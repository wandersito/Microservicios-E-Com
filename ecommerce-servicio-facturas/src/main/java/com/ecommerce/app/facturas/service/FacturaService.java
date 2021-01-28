package com.ecommerce.app.facturas.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.app.commons.models.facturas.Factura;
import com.ecommerce.app.commons.services.CommonService;
//import com.ecommerce.app.facturas.client.rest.IProductoRest;
import com.ecommerce.app.facturas.repository.IFacturaRepository;

@Service
public class FacturaService extends CommonService<Factura, IFacturaRepository> implements IFacturaService {

	@Override
	@Transactional(readOnly = true)
	public Factura findFacturaByProducto(Long id) {
		return repository.findFacturaByProducto(id);
	}

}
