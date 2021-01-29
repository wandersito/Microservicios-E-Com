package com.ecommerce.app.commons.models.productos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
//import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.ecommerce.app.commons.models.facturas.Factura;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor 
@Entity
@Table(name = "productos")
public class Producto implements Serializable {
	
	private static final long serialVersionUID = -677498158644308816L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String nombre; 
	
	@NotEmpty
	private String descripcion;
	
	private String img;
	
	@NotNull
	private Double precio;
	
	@Lob
	@JsonIgnore
	private byte[] foto;
	
	public Integer getFotoHashCode() {
		return (this.foto != null)? this.foto.hashCode(): null;
	}

	@JsonManagedReference
	@ManyToMany(mappedBy = "productos")
    private List<Factura> facturas;

	public Producto() {
		this.facturas = new ArrayList<>();
	}

//	@Override
//	public boolean equals(Object obj) {
//
//		if (this == obj) {
//			return true;
//		}
//		if (!(obj instanceof Producto)) {
//			return false;
//		}
//		Producto p = (Producto) obj;
//		return this.id != null && this.id.equals(p.getId());
//
//	}

}
