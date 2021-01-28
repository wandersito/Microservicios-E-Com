package com.ecommerce.app.commons.models.cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ecommerce.app.commons.models.facturas.Factura;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "clientes")
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String apellido;
	private String email;
	
	private List<Factura> facturas;
	
	public Cliente() {
		this.facturas = new ArrayList<>();
	}
	
	public void addFacturas(Factura factura) {
		this.facturas.add(factura);
		factura.setCliente(this);
	}
	
	public void setFacturas(List<Factura> facturas) {
		this.facturas.clear();
		facturas.forEach( factura -> {
			this.facturas.add(factura);
		});
	}
	
	public void removeFacturas(Factura factura) {
		this.facturas.remove(factura);
		factura.setCliente(null);
	}
	
}
