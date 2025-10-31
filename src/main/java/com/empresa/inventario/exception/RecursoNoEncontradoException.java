package com.empresa.inventario.exception;

/**
 * Excepción personalizada para recursos no encontrados en el sistema.
 */
public class RecursoNoEncontradoException extends RuntimeException {
    public RecursoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}