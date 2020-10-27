/**
 * ProductoService.java
 * Fecha de creación: 22 oct. 2020, 17:04:15
 *
 * Copyright (c) 2020 andy 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad de
 * andy. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package com.mx.andrea.ProductoAPI.service;

import java.util.List;
import com.mx.andrea.ProductoAPI.model.Producto;

/**
 * TODO [Agregar documentacion de la clase]
 * @author andy lupy29@hotmail.com
 * @version 1.0
 * @since 
 */
/**
 * Los atributos en una interface son publicos
 * **/

public interface ProductoService {
	
	/**
	 *  TODO [Agregar documentacion al método]
	 *  @author andy lupy29@hotmail.com
	 *  @param producto
	 *  @return
	 */
	int save(Producto producto);
	/**
	 *  TODO [Agregar documentacion al método]
	 *  @author andy lupy29@hotmail.com
	 *  @param producto
	 *  @return
	 */
	int delete(Producto producto);
	/**
	 *  TODO [Agregar documentacion al método]
	 *  @author andy lupy29@hotmail.com
	 *  @param nombre
	 *  @return
	 */
	Producto getProducto(String nombre);
	List <Producto> getProductos();

}
