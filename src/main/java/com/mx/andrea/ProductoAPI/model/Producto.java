/**
 * Producto.java
 * Fecha de creación: 22 oct. 2020, 16:35:02
 *
 * Copyright (c) 2020 andy 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad de
 * andy. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package com.mx.andrea.ProductoAPI.model;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * TODO [Agregar documentacion de la clase]
 * @author andy lupy29@hotmail.com
 * @version 1.0
 * @since 
 */

/**
 * serializable protege el objeto
 * **/
@Document(collection = "Producto")
public class Producto implements Serializable{

	/**
	 * Identica
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	private String nombre;
	
	private String descripcion;

	public Producto() {
		
	}
	
	/**
	 *  TODO [Agregar documentacion al método]
	 *  @author 
	 *  @param nombre
	 *  @param descripcion
	 */
	public Producto(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public String getNombre() {
		return nombre;
	}

	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public String getDescripcion() {
		return descripcion;
	}

	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
	

}
