package com.ecommerce.app.commons.models.cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.ecommerce.app.commons.models.facturas.Factura;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor 
@Entity
@Table(name="clientes")
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String apellido;
	private String email;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "cliente" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
