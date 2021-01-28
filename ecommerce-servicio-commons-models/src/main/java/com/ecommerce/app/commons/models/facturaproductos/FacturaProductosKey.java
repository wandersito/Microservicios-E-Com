package com.ecommerce.app.commons.models.facturaproductos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FacturaProductosKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "FK_PRODUCTO")
    Long productoId;

    @Column(name = "FK_FACTURA")
    Long facturaId;

	public FacturaProductosKey() {
	}

	public FacturaProductosKey(Long productoId, Long facturaId) {
		this.productoId = productoId;
		this.facturaId = facturaId;
	}

	public Long getProductoId() {
		return productoId;
	}

	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}

	public Long getFacturaId() {
		return facturaId;
	}

	public void setFacturaId(Long facturaId) {
		this.facturaId = facturaId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((facturaId == null) ? 0 : facturaId.hashCode());
		result = prime * result + ((productoId == null) ? 0 : productoId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FacturaProductosKey other = (FacturaProductosKey) obj;
		if (facturaId == null) {
			if (other.facturaId != null)
				return false;
		} else if (!facturaId.equals(other.facturaId))
			return false;
		if (productoId == null) {
			if (other.productoId != null)
				return false;
		} else if (!productoId.equals(other.productoId))
			return false;
		return true;
	}
	
    
}
