package com.mx.andrea.ProductoAPI.exception;

public class ProductoNotFoundException extends RuntimeException {

	/**
	 * TODO [Agregar documentación del atributo]
	 */
	private static final long serialVersionUID = 1L;

	public ProductoNotFoundException(String message) {
		super(message);
	}

	public ProductoNotFoundException(String message, Throwable t) {
		super(message, t);
	}

}
