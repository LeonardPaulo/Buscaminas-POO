package com.buscaminas.modelo;

import java.io.Serializable;

public abstract class ElementoJuego implements Serializable {
    private static final long serialVersionUID = 1L;

    protected boolean descubierta;
    protected boolean marcada;

    public ElementoJuego() {
        this.descubierta = false;
        this.marcada = false;
    }

    public boolean estaDescubierta() {
        return descubierta;
    }

    public void setDescubierta(boolean descubierta) {
        this.descubierta = descubierta;
    }

    public boolean estaMarcada() {
        return marcada;
    }

    public void setMarcada(boolean marcada) {
        this.marcada = marcada;
    }
}
