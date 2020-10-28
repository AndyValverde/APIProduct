/**
 * ProductoServiceImpl.java Fecha de creación: 22 oct. 2020, 17:13:11 Copyright (c) 2020 andy
 * Todos los derechos reservados. Este software es información confidencial, propiedad de andy.
 * Esta información confidencial no deberá ser divulgada y solo se podrá utilizar de acuerdo a
 * los términos que determine la propia empresa.
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
public class ProductoServiceImpl implements ProductoService {

	private static final Logger logger = LoggerFactory.getLogger(ProductoServiceImpl.class);

	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public void save(Producto producto) {
		logger.info("ProductoServiceImpl: inicia save");
		productoRepository.save(producto);
		logger.info("ProductoServiceImpl: termina save");
	}

	@Override
	public void delete(String id) {
		logger.info("ProductoServiceImpl: inicia delete");
		productoRepository.deleteById(id);
		logger.info("ProductoServiceImpl: termina delete");
	}

	@Override
	public List<Producto> getProduct(String nombre) {
		logger.info("ProductoServiceImpl: inicia getProduct");
		List<Producto> producto = productoRepository.findByNombre(nombre);
		logger.info("ProductoServiceImpl: termina getProduct");
		return producto;

	}

	@Override
	public List<Producto> getAllProducts() {
		logger.info("ProductoServiceImpl: inicia getAllProduct");
		List<Producto> productos = productoRepository.findAll();
		logger.info("ProductoServiceImpl: termina getAllProduct");
		return productos;
	}

}
