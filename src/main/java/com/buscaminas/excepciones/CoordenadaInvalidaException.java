package com.buscaminas.excepciones;

public class CoordenadaInvalidaException extends Exception {
    public CoordenadaInvalidaException() {
        super("Coordenada inválida.");
    }

    public CoordenadaInvalidaException(String mensaje) {
        super(mensaje);
    }
}
