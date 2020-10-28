/**
 * ProductoAPI.java Fecha de creación: 22 oct. 2020, 17:33:14 Copyright (c) 2020 andy Todos los
 * derechos reservados. Este software es información confidencial, propiedad de andy. Esta
 * información confidencial no deberá ser divulgada y solo se podrá utilizar de acuerdo a los
 * términos que determine la propia empresa.
 */
package com.mx.andrea.ProductoAPI.api;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	private final Logger logger = LoggerFactory.getLogger(ProductoAPI.class);

	@Autowired
	private ProductoService productoService;

	/**
	 * TODO [Agregar documentacion al método]
	 * @author andy lupy29@hotmail.com
	 * @param producto
	 */
	@PostMapping("/registrarProducto")
	public ResponseEntity<Producto> save(@RequestBody Producto producto) {
		final long start = System.nanoTime();
		logger.info("ProductoAPI: inicia save");
		try {
			Producto newProducto = productoService.save(producto);
			return new ResponseEntity<>(newProducto, HttpStatus.CREATED);
		} catch(Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			final long end = System.nanoTime();
			logger.info("time " + (end - start) / 1000000 + "ms");
			logger.info("time " + (end - start) / 1000000000 + "s");
			logger.info("ProductoAPI: termina save");
		}

	}

	/**
	 * TODO [Agregar documentacion al método]
	 * @author andy lupy29@hotmail.com
	 * @return
	 */
	@GetMapping("/obtieneProductos")
	public List<Producto> getAllProducts() {
		final long start = System.nanoTime();
		logger.info("ProductoAPI: inicia getAllProduct");
		List<Producto> products = productoService.getAllProducts();
		final long end = System.nanoTime();
		logger.info("time " + (end - start) / 1000000 + "ms");
		logger.info("time " + (end - start) / 1000000000 + "s");
		logger.info("ProductoAPI: termina getAllProduct");
		return products;
	}

	/**
	 * TODO [Agregar documentacion al método]
	 * @author andy lupy29@hotmail.com
	 * @param name
	 * @return
	 */
	@GetMapping("/obtieneProducto/{nombre}")
	public List<Producto> getProduct(@PathVariable String nombre) {
		final long start = System.nanoTime();
		logger.info("ProductoAPI: inicia getProduct");
		List<Producto> product = productoService.getProduct(nombre);
		final long end = System.nanoTime();
		logger.info("time " + (end - start) / 1000000 + "ms");
		logger.info("time " + (end - start) / 1000000000 + "s");
		logger.info("ProductoAPI: termina getProduct");
		return product;
	}

	@GetMapping("/obtieneProducto/{id}")
	public ResponseEntity<Producto> obtieneProductoById(@PathVariable String id) {
		final long start = System.nanoTime();
		logger.info("ProductoAPI: inicia obtieneProductoById");
		Optional<Producto> product = productoService.getProductById(id);
		if (product.isPresent()) {
			final long end = System.nanoTime();
			logger.info("time " + (end - start) / 1000000 + "ms");
			logger.info("time " + (end - start) / 1000000000 + "s");
			logger.info("ProductoAPI: termina obtieneProductoById");
			return new ResponseEntity<>(product.get(), HttpStatus.OK);
		} else {
			final long end = System.nanoTime();
			logger.info("time " + (end - start) / 1000000 + "ms");
			logger.info("time " + (end - start) / 1000000000 + "s");
			logger.info("ProductoAPI: termina obtieneProductoById");
			return new ResponseEntity<>(null, HttpStatus.OK);// product.get() no se puede trairia
																												// error
		}
	}

	@DeleteMapping("/eliminaProducto/{id}")
	public void deleteProduct(@PathVariable String id) {
		final long start = System.nanoTime();
		logger.info("ProductoAPI: inicia deleteProduct");
		Optional<Producto> product = productoService.getProductById(id);
		if (product.isPresent()) {
			productoService.delete(id);
			final long end = System.nanoTime();
			logger.info("time " + (end - start) / 1000000 + "ms");
			logger.info("time " + (end - start) / 1000000000 + "s");
			logger.info("ProductoAPI: termina deleteProduct");
		}

	}

	/**
	 * PUT -> Cambia todo el objeto PAT -> Cambia un atributo
	 * @author andy lupy29@hotmail.com
	 */
	@PutMapping("/actualizaProducto/{id}")
	public void updateProduct(@PathVariable String id, @RequestBody Producto newProducto) {
		final long start = System.nanoTime();
		logger.info("ProductoAPI: inicia updateProduct");
		Optional<Producto> product = productoService.getProductById(id);
		if (product.isPresent()) {
			productoService.save(newProducto);
			final long end = System.nanoTime();
			logger.info("time " + (end - start) / 1000000 + "ms");
			logger.info("time " + (end - start) / 1000000000 + "s");
			logger.info("ProductoAPI: finaliza updateProduct");
		}
	}

}
