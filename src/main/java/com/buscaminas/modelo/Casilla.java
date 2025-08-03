package com.buscaminas.modelo;

import com.buscaminas.excepciones.CasillaMarcadaException;
import com.buscaminas.excepciones.CasillaYaDescubiertaException;

public abstract class Casilla extends ElementoJuego implements ICasilla {
    private static final long serialVersionUID = 1L;
    protected int minasAdyacentes;

    public Casilla() {
        super();
        this.minasAdyacentes = 0;
    }

    @Override
    public int getMinasAdyacentes() {
        return minasAdyacentes;
    }

    @Override
    public void setMinasAdyacentes(int minas) {
        this.minasAdyacentes = minas;
    }

    @Override
    public void descubrir() throws CasillaYaDescubiertaException, CasillaMarcadaException {
        if (estaMarcada()) {
            throw new CasillaMarcadaException();
        }
        if (estaDescubierta()) {
            throw new CasillaYaDescubiertaException();
        }
        this.descubierta = true;
    }

    @Override
    public void marcar() {
        this.marcada = !this.marcada;  // Alterna marcado/no marcado
    }
}
