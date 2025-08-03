package com.buscaminas.modelo;

import com.buscaminas.excepciones.CasillaYaDescubiertaException;

public class CasillaVacia implements ICasilla {

    private static final long serialVersionUID = 1L;

    private boolean descubierta;
    private boolean marcada;
    private int minasAdyacentes;

    public CasillaVacia() {
        this.descubierta = false;
        this.marcada = false;
        this.minasAdyacentes = 0;
    }

    @Override
    public boolean tieneMina() {
        return false;
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
        this.marcada = false;  // Al descubrir, si estaba marcada se desmarca
    }

    @Override
    public void marcar() {
        if (!descubierta) {
            marcada = !marcada; // Alterna entre marcada y no marcada
        }
    }

    @Override
    public int getMinasAdyacentes() {
        return minasAdyacentes;
    }

    @Override
    public void setMinasAdyacentes(int cantidad) {
        this.minasAdyacentes = cantidad;
    }

    @Override
    public String mostrar() {
        if (marcada) {
            return "M";  // Casilla marcada con bandera
        }
        if (!descubierta) {
            return "■";  // Casilla sin descubrir
        }
        if (minasAdyacentes == 0) {
            return "□";  // Casilla descubierta y vacía (sin minas cercanas)
        }
        return Integer.toString(minasAdyacentes);  // Número de minas adyacentes
    }
}
