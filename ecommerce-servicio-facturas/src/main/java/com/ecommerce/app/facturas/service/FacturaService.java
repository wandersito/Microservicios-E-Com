package com.ecommerce.app.facturas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.app.facturas.entity.Factura;
import com.ecommerce.app.facturas.repository.IFacturaRepository;

@Service
public class FacturaService implements IFacturaService {

	@Autowired
	IFacturaRepository facturaRepository;
	
//	@Autowired
//	IProductoRest productoRest;
	
	@Override
	@Transactional(readOnly=true)
	public List<Factura> findAll() {
		return facturaRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Factura findById(Long id) {
		return facturaRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Factura create(Factura factura) {
		return facturaRepository.save(factura);
	}

	@Override
	@Transactional
	public Factura update(Factura factura, Long id) throws Exception {
		try {
			Factura facturaDB = facturaRepository.findById(id).orElse(null);
			if(facturaDB != null) {
//				factura.setId(id);
				return facturaRepository.save(factura);
			}else{
				throw new Exception("No se pudo encontrar informacion de la factura");
			}
		}catch(Exception e ) {
			throw new Exception("Error al actualizar la factura");
		}
			
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		facturaRepository.deleteById(id);
	}

}
