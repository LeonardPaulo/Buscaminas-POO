package com.buscaminas.modelo;

public interface ITablero {
    ICasilla obtenerCasilla(int fila, int columna);
    void descubrir(int fila, int columna) throws Exception;
    void marcar(int fila, int columna);
    boolean todasLasCasillasSegurasDescubiertas();
}
