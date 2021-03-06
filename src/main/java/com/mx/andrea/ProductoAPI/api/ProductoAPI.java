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
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mx.andrea.ProductoAPI.exception.ProductoNotFoundException;
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
	 * @return en servlet
	 * @GET @Consumes(MediaType.APPLICATION_JSON) @Produces(MediaType.APPLICATION_XML)
	 */

	@GetMapping(path = "/obtieneProductosxmlfilter/{nombre}", produces = "application/xml",
		consumes = "application/json") // manda formato(no archivo) xml y recibe formato (no
																		// archivo) json
	public ResponseEntity<List<Producto>> getAllProductsXmlFilter(@PathVariable String nombre) {
		final long start = System.nanoTime();
		logger.info("ProductoAPI: inicia getAllProduct");
		try {
			List<Producto> products = productoService.getAllProductsFilter(nombre);
			if (products.isEmpty()) {
				throw new ProductoNotFoundException("products " + products);
			} else {
				return new ResponseEntity<>(products, HttpStatus.OK);
			}
		} catch(ProductoNotFoundException ex) {
			logger.info("Exception " + ex.getMessage());
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

		} catch(Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			final long end = System.nanoTime();
			logger.info("time " + (end - start) / 1000000 + "ms");
			logger.info("time " + (end - start) / 1000000000 + "s");
			logger.info("ProductoAPI: termina getAllProduct");
		}

	}

	/**
	 * TODO [Agregar documentacion al método]
	 * @author andy lupy29@hotmail.com
	 * @return
	 */
	@GetMapping("/obtieneProductosxml")
	public ResponseEntity<List<Producto>> getAllProductsXml() {
		final long start = System.nanoTime();
		logger.info("ProductoAPI: inicia getAllProduct");
		try {
			List<Producto> products = productoService.getAllProducts();
			if (products.isEmpty()) {
				throw new ProductoNotFoundException("products " + products);
			} else {
				return new ResponseEntity<>(products, HttpStatus.OK);
			}
		} catch(ProductoNotFoundException ex) {
			logger.info("Exception " + ex.getMessage());
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

		} catch(Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			final long end = System.nanoTime();
			logger.info("time " + (end - start) / 1000000 + "ms");
			logger.info("time " + (end - start) / 1000000000 + "s");
			logger.info("ProductoAPI: termina getAllProduct");
		}

	}

	/**
	 * TODO [Agregar documentacion al método]
	 * @author andy lupy29@hotmail.com
	 * @return
	 */
	@GetMapping("/obtieneProductosjson")
	public ResponseEntity<List<Producto>> getAllProductsJson() {
		final long start = System.nanoTime();
		logger.info("ProductoAPI: inicia getAllProduct");
		try {
			List<Producto> products = productoService.getAllProducts();
			if (products.isEmpty()) {
				throw new ProductoNotFoundException("products " + products);
			} else {
				return new ResponseEntity<>(products, HttpStatus.OK);
			}
		} catch(ProductoNotFoundException ex) {
			logger.info("Exception " + ex.getMessage());
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

		} catch(Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			final long end = System.nanoTime();
			logger.info("time " + (end - start) / 1000000 + "ms");
			logger.info("time " + (end - start) / 1000000000 + "s");
			logger.info("ProductoAPI: termina getAllProduct");
		}

	}

	/**
	 * TODO [Agregar documentacion al método]
	 * @author andy lupy29@hotmail.com
	 * @param name
	 * @return
	 */
	@GetMapping("/obtieneProductos/{nombre}")
	public ResponseEntity<List<Producto>> getProduct(@PathVariable String nombre) {
		final long start = System.nanoTime();
		logger.info("ProductoAPI: inicia getProduct");
		try {
			List<Producto> product = productoService.getProduct(nombre);
			if (product.isEmpty()) {
				throw new ProductoNotFoundException("product " + product);
			} else {
				return new ResponseEntity<>(product, HttpStatus.OK);
			}

		} catch(ProductoNotFoundException e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			final long end = System.nanoTime();
			logger.info("time " + (end - start) / 1000000 + "ms");
			logger.info("time " + (end - start) / 1000000000 + "s");
			logger.info("ProductoAPI: termina getProduct");
		}
	}

	@GetMapping("/obtieneProducto/{id}")
	public ResponseEntity<Producto> obtieneProductoById(@PathVariable String id) {
		final long start = System.nanoTime();
		logger.info("ProductoAPI: inicia obtieneProductoById");
		Optional<Producto> product = productoService.getProductById(id);
		try {
			if (product.isPresent()) {
				return new ResponseEntity<>(product.get(), HttpStatus.OK);
			} else {
				throw new ProductoNotFoundException("product " + product);
			}
		} catch(ProductoNotFoundException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);// product.get() no se puede
			// trairia
			// error, no encontro el recurso diferente a not_count (lista vacia)
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			final long end = System.nanoTime();
			logger.info("time " + (end - start) / 1000000 + "ms");
			logger.info("time " + (end - start) / 1000000000 + "s");
			logger.info("ProductoAPI: termina obtieneProductoById");
		}
	}

	@GetMapping("/obtieneProductoHATEOAS/{id}")
	public ResponseEntity<EntityModel<Optional<Producto>>> obtieneProductoByIdHATEOAS(
		@PathVariable("id") String id) {
		final long start = System.nanoTime();
		logger.info("ProductoAPI: inicia obtieneProductoById");
		try {
			Optional<Producto> product = productoService.getProductById(id);
			if (product.isPresent()) {
				// creacion de un modelo entitymodel es igual a mi modelo solo cambia el tipo
				EntityModel<Optional<Producto>> resource = EntityModel.of(product);
				// construye instancia del link que apunta al metodo del controller que se indica
				WebMvcLinkBuilder linkToJson = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllProductsJson());
				// le agrega el link y le pone un sobre nombre(withRel es sobrenombre)
				resource.add(linkToJson.withRel("all-product-json"));
				/**
				 * Esto no se podría por que se debe crear nueva variable para el nuevo link
				 */
				/**
				 * linkToJson = WebMvcLinkBuilder
				 * .linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllProductsXml());
				 * resource.add(linkToJson.withRel("all-product-xml"));
				 **/
				WebMvcLinkBuilder linkToXml = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllProductsXml());
				resource.add(linkToXml.withRel("all-product-xml"));

				return new ResponseEntity<>(resource, HttpStatus.OK);
			} else {
				throw new ProductoNotFoundException("product " + product);
			}
		} catch(ProductoNotFoundException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);// product.get() no se puede
			// trairia
			// error, no encontro el recurso diferente a not_count (lista vacia)
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			final long end = System.nanoTime();
			logger.info("time " + (end - start) / 1000000 + "ms");
			logger.info("time " + (end - start) / 1000000000 + "s");
			logger.info("ProductoAPI: termina obtieneProductoById");
		}
	}

	@DeleteMapping("/eliminaProducto/{id}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable String id) {
		final long start = System.nanoTime();
		logger.info("ProductoAPI: inicia deleteProduct");
		try {
			Optional<Producto> product = productoService.getProductById(id);
			if (product.isPresent()) {
				productoService.delete(id);
				return new ResponseEntity<HttpStatus>(HttpStatus.OK);
			} else {
				throw new ProductoNotFoundException("product " + product);
			}
		} catch(ProductoNotFoundException e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		} catch(Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
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
	public ResponseEntity<Producto> updateProduct(@PathVariable String id,
		@RequestBody Producto newProducto) {
		final long start = System.nanoTime();
		logger.info("ProductoAPI: inicia updateProduct");
		try {
			Optional<Producto> product = productoService.getProductById(id);
			if (product.isPresent()) {
				Producto producto = product.get();// pasa todo el productoy cuando lo regresa a la base
				producto.setNombre(newProducto.getNombre());
				producto.setDescripcion(newProducto.getDescripcion());;
				productoService.save(producto);// por PUTMAPPING y que traen el mismo id mongo entiende
																				// que estas reescribiendo
				return new ResponseEntity<Producto>(producto, HttpStatus.OK);
			} else {
				throw new ProductoNotFoundException("product " + product);
			}
		} catch(ProductoNotFoundException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			final long end = System.nanoTime();
			logger.info("time " + (end - start) / 1000000 + "ms");
			logger.info("time " + (end - start) / 1000000000 + "s");
			logger.info("ProductoAPI: finaliza updateProduct");
		}

	}

}