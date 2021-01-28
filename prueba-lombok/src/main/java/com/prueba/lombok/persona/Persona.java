package com.prueba.lombok.persona;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Builder
@Entity
@Table(name = "personas")
@Data 
public class Persona implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nombre;
	private String apellido;
	
}
