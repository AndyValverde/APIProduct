/**
 * ProductoService.java Fecha de creación: 22 oct. 2020, 17:04:15 Copyright (c) 2020 andy Todos
 * los derechos reservados. Este software es información confidencial, propiedad de andy. Esta
 * información confidencial no deberá ser divulgada y solo se podrá utilizar de acuerdo a los
 * términos que determine la propia empresa.
 */
package com.mx.andrea.ProductoAPI.service;

import java.util.List;
import java.util.Optional;
import com.mx.andrea.ProductoAPI.model.Producto;

/**
 * TODO [Agregar documentacion de la clase]
 * @author andy lupy29@hotmail.com
 * @version 1.0
 * @since
 */
/**
 * Los atributos en una interface son publicos
 **/

public interface ProductoService {

	/**
	 * TODO [Agregar documentacion al método]
	 * @author andy lupy29@hotmail.com
	 * @param producto
	 * @return
	 */
	Producto save(Producto producto);

	/**
	 * TODO [Agregar documentacion al método]
	 * @author andy lupy29@hotmail.com
	 * @param id
	 * @return
	 */
	void delete(String id);

	/**
	 * TODO [Agregar documentacion al método]
	 * @author andy lupy29@hotmail.com
	 * @param nombre
	 * @return
	 */
	List<Producto> getProduct(String nombre);

	/**
	 * TODO [Agregar documentacion al método]
	 * @author andy lupy29@hotmail.com
	 * @return
	 */
	List<Producto> getAllProducts();

	// void updateProduct();

	Optional<Producto> getProductById(String id);

}
