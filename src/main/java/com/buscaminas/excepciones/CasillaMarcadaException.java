package com.buscaminas.excepciones;

public class CasillaMarcadaException extends Exception {
    public CasillaMarcadaException() {
        super("La casilla está marcada y no puede ser descubierta.");
    }

    public CasillaMarcadaException(String mensaje) {
        super(mensaje);
    }
}
