/**
 * productoRepository.java Fecha de creación: 22 oct. 2020, 16:58:58 Copyright (c) 2020 andy
 * Todos los derechos reservados. Este software es información confidencial, propiedad de andy.
 * Esta información confidencial no deberá ser divulgada y solo se podrá utilizar de acuerdo a
 * los términos que determine la propia empresa.
 */
package com.mx.andrea.ProductoAPI.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.mx.andrea.ProductoAPI.model.Producto;

/**
 * TODO [Agregar documentacion de la clase]
 * @author andy lupy29@hotmail.com
 * @version 1.0
 * @since
 */
/**
 * Tipo y ID (en este caso nombre(del producto) es tipo string )
 **/
@Repository
public interface ProductoRepository extends MongoRepository<Producto, String> {

	List<Producto> findByNombre(String nombre);

	void updateProduct();

}
