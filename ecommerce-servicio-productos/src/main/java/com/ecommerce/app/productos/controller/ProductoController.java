package com.ecommerce.app.productos.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.app.commons.controllers.CommonController;
import com.ecommerce.app.commons.models.productos.Producto;
import com.ecommerce.app.productos.service.ProductoService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
public class ProductoController extends CommonController<Producto, ProductoService> {
	
	
}
