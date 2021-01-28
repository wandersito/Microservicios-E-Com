package com.ecommerce.app.commons.models.productos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.ecommerce.app.commons.models.facturas.Factura;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Producto implements Serializable {
	
	private static final long serialVersionUID = -677498158644308816L;

	private Long id;

	@NotEmpty
	private String nombre; 
	
	@NotEmpty
	private String descripcion;
	
	private String img;
	
	@NotNull
	private Double precio;

    private List<Factura> facturas;

	public Producto() {
		this.facturas = new ArrayList<>();
	}
	
}
