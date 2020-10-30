/**
 * ProductoServiceImpl.java Fecha de creación: 22 oct. 2020, 17:13:11 Copyright (c) 2020 andy
 * Todos los derechos reservados. Este software es información confidencial, propiedad de andy.
 * Esta información confidencial no deberá ser divulgada y solo se podrá utilizar de acuerdo a
 * los términos que determine la propia empresa.
 */
package com.mx.andrea.ProductoAPI.service;

import java.util.List;
import java.util.Optional;
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
	public Producto save(Producto producto) {
		logger.info("ProductoServiceImpl: inicia save");
		Producto newProducto = productoRepository.save(producto);
		logger.info("ProductoServiceImpl: termina save");
		return newProducto;
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

	@Override
	public Optional<Producto> getProductById(String id) {
		logger.info("ProductoServiceImpl: inicia getAllProduct");
		Optional<Producto> producto = productoRepository.findById(id);
		logger.info("ProductoServiceImpl: termina getAllProduct");
		return producto;
	}
	/*
	 * @Override public void updateProduct() {
	 * logger.info("ProductoServiceImpl: inicia updateProduct");
	 * productoRepository.updateProduct();
	 * logger.info("ProductoServiceImpl: termina updateProduct"); }
	 */
}
