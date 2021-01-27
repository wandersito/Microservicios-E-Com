package com.ecommerce.app.facturas.service;

import org.springframework.stereotype.Service;

import com.ecommerce.app.commons.services.CommonService;
//import com.ecommerce.app.facturas.client.rest.IProductoRest;
import com.ecommerce.app.facturas.entity.Factura;
import com.ecommerce.app.facturas.repository.IFacturaRepository;

@Service
public class FacturaService extends CommonService<Factura, IFacturaRepository> implements IFacturaService {

//	@Autowired
//	IFacturaRepository facturaRepository;
//	
////	@Autowired
////	IProductoRest productoRest;
//	
//	@Override
//	@Transactional(readOnly=true)
//	public List<Factura> findAll() {
//		return facturaRepository.findAll();
//	}
//	
////	@Transactional(readOnly=true)
////	public List<Producto> findProductos() {
////		return productoRest.read();
////	}
//
//	@Override
//	@Transactional(readOnly=true)
//	public Factura findById(Long id) {
//		return facturaRepository.findById(id).orElse(null);
//	}
//
//	@Override
//	@Transactional
//	public Factura create(Factura factura) {
//		return facturaRepository.save(factura);
//	}
//
//	@Override
//	@Transactional
//	public Factura update(Factura factura, Long id) throws Exception {
//		try {
//			Factura facturaDB = facturaRepository.findById(id).orElse(null);
//			if(facturaDB != null) {
////				factura.setId(id);
//				return facturaRepository.save(factura);
//			}else{
//				throw new Exception("No se pudo encontrar informacion de la factura");
//			}
//		}catch(Exception e ) {
//			throw new Exception("Error al actualizar la factura");
//		}
//			
//	}
//
//	@Override
//	@Transactional
//	public void deleteById(Long id) {
//		facturaRepository.deleteById(id);
//	}

}
