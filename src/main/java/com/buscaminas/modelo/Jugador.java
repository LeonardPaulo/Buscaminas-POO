package com.buscaminas.modelo;

import java.io.Serializable;

public class Jugador implements Serializable {
    private String nombre;
    private int puntaje;
    private int partidasGanadas;
    private boolean perdio;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = 0;
        this.partidasGanadas = 0;
        this.perdio = false;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public boolean haPerdido() {
        return perdio;
    }

    // Setters y modificadores
    public void perder() {
        this.perdio = true;
    }

    public void incrementarPartidasGanadas() {
        this.partidasGanadas++;
    }

    public void incrementarPuntaje(int puntos) {
        this.puntaje += puntos;
    }

    public void reiniciar() {
        this.puntaje = 0;
        this.perdio = false;
    }
}
