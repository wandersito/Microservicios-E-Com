package com.ecommerce.app.commons.models.facturas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.ecommerce.app.commons.models.productos.Producto;
//import com.fasterxml.jackson.annotation.JsonBackReference;

//import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;


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
	
	@JoinTable(
	        name = "FACTURA_PRODUCTO",
	        joinColumns = @JoinColumn(name = "FK_FACTURA", nullable = false),
	        inverseJoinColumns = @JoinColumn(name="FK_PRODUCTO", nullable = false)
	)
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Producto> productos;
	
	public Factura() {
		this.productos = new ArrayList<>();
	}
	
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public void addProductos(Producto producto) {
		this.productos.add(producto);
	}
	
	public void removeProductos(Producto producto) {
		this.productos.remove(producto);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Factura(Long id, String descripcion, String observacion) {
		this.id = id;
		this.descripcion = descripcion;
		this.observacion = observacion;
	}
	
}
