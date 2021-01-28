package com.ecommerce.app.commons.models.facturaproductos;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.ecommerce.app.commons.models.facturas.Factura;
import com.ecommerce.app.commons.models.productos.Producto;

@Entity
@Table(name="factura_producto")
public class FacturaProductos {
	
	@EmbeddedId
	FacturaProductosKey id;
	
	@ManyToOne()
	@MapsId("productoId")
    @JoinColumn(name = "FK_PRODUCTO")
	Producto producto;
	
	@ManyToOne()
	@MapsId("facturaId")
    @JoinColumn(name = "FK_FACTURA")
	Factura factura;
	
	private int cantidad;

	public FacturaProductos() {
	}

	public FacturaProductos(FacturaProductosKey id, Producto producto, Factura factura) {
		this.id = id;
		this.producto = producto;
		this.factura = factura;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public FacturaProductosKey getId() {
		return id;
	}

	public void setId(FacturaProductosKey id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

}
