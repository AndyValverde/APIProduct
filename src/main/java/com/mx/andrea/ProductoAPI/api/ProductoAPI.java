/**
 * ProductoAPI.java
 * Fecha de creación: 22 oct. 2020, 17:33:14
 *
 * Copyright (c) 2020 andy 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad de
 * andy. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package com.mx.andrea.ProductoAPI.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mx.andrea.ProductoAPI.model.Producto;
import com.mx.andrea.ProductoAPI.service.ProductoService;

/**
 * TODO [Agregar documentacion de la clase]
 * @author andy lupy29@hotmail.com
 * @version 1.0
 * @since 
 */
@RestController
public class ProductoAPI {
	@Autowired
	private ProductoService productoService; 
	
	@PostMapping("/registrarProducto")
	public void save(@RequestBody Producto producto) {
		productoService.save(producto);
	}

}
