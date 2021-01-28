package com.ecommerce.app.commons.models.facturas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Transient;

import com.ecommerce.app.commons.models.cliente.Cliente;
import com.ecommerce.app.commons.models.productos.Producto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Factura implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotEmpty
	private String descripcion;
	
	private String observacion;

	private List<Producto> productos;
	
	@Transient
	private Cliente cliente;
	
	private Long clienteId;
	
	public Factura() {
		this.productos = new ArrayList<>();
	}
	
	public void addProductos(Producto producto) {
		this.productos.add(producto);
	}

	public void removeProductos(Producto producto) {
		this.productos.remove(producto);
	}

}
