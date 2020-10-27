/**
 * ProductoServiceImpl.java
 * Fecha de creación: 22 oct. 2020, 17:13:11
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mx.andrea.ProductoAPI.model.Producto;
import com.mx.andrea.ProductoAPI.repository.ProductoRepository;

/**
 * TODO [Agregar documentacion de la clase]
 * @author andy lupy29@hotmail.com
 * @version 1.0
 * @since 
 */
@Service
public class ProductoServiceImpl implements ProductoService{
	private static final Logger logger = LoggerFactory.getLogger(ProductoServiceImpl.class);
	
	@Autowired
	 private ProductoRepository productoRepository;

	@Override
	public int save(Producto producto) {
		
		logger.info("Inicia service registra producto");
		
		productoRepository.save(producto);
		
		logger.info("Termina service registra producto");
		
		return 0;
		// TODO [codificar el cuerpo del método]
	}

	@Override
	public int delete(Producto producto) {
		return 0;
		// TODO [codificar el cuerpo del método]
	}

	@Override
	public Producto getProducto(String nombre) {
		return null;
		// TODO [codificar el cuerpo del método]
	}

	@Override
	public List<Producto> getProductos() {
		return null;
		// TODO [codificar el cuerpo del método]
	}
	
	
}
