package com.buscaminas.modelo;

import com.buscaminas.excepciones.CasillaYaDescubiertaException;

public class CasillaMina implements ICasilla {

    private static final long serialVersionUID = 1L;

    private boolean descubierta;
    private boolean marcada;

    public CasillaMina() {
        this.descubierta = false;
        this.marcada = false;
    }

    @Override
    public boolean tieneMina() {
        return true;
    }

    @Override
    public boolean estaDescubierta() {
        return descubierta;
    }

    @Override
    public boolean estaMarcada() {
        return marcada;
    }

    @Override
    public void descubrir() throws CasillaYaDescubiertaException, Exception {
        if (marcada) {
            throw new Exception("No puedes descubrir una casilla marcada.");
        }
        if (descubierta) {
            throw new CasillaYaDescubiertaException();
        }
        this.descubierta = true;
        this.marcada = false;  // Al descubrir, se quita la marca si existía
    }

    @Override
    public void marcar() {
        if (!descubierta) {
            marcada = !marcada;  // Alterna marcada/no marcada
        }
    }

    @Override
    public int getMinasAdyacentes() {
        return -1;  // No aplica para mina
    }

    @Override
    public void setMinasAdyacentes(int cantidad) {
        // No aplica para mina, método vacío
    }

    @Override
    public String mostrar() {
        if (marcada) {
            return "M";  // Casilla marcada con bandera
        }
        if (!descubierta) {
            return "■";  // Casilla sin descubrir
        }
        return "X";  // Casilla descubierta que tiene mina
    }
}
