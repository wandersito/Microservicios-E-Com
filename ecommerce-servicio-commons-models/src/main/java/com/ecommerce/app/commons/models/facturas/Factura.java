package com.ecommerce.app.commons.models.facturas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.ecommerce.app.commons.models.cliente.Cliente;
import com.ecommerce.app.commons.models.facturaproducto.FacturaProducto;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.CascadeType;

@Data
@AllArgsConstructor 
@Entity
@Table(name="facturas")
public class Factura implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String descripcion;
	
	private String observacion;
	
	@OneToMany( mappedBy="factura", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<FacturaProducto> productos;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	public Factura() {
		this.productos = new ArrayList<>();
	}
	
	public Factura(Long id) {
		this.productos = new ArrayList<>();
		this.id = id;
	}
	
	public void addProductos(FacturaProducto facturaProducto) {
		this.productos.add(facturaProducto);
	}

	public void removeProductos(FacturaProducto facturaProducto) {
		this.productos.remove(facturaProducto);
	}
	
}
