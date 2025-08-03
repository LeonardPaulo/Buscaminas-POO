package com.buscaminas.excepciones;

public class CasillaYaDescubiertaException extends Exception {
    public CasillaYaDescubiertaException() {
        super("La casilla ya ha sido descubierta.");
    }

    public CasillaYaDescubiertaException(String mensaje) {
        super(mensaje);
    }
}
