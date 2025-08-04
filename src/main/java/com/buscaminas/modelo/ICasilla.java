package com.buscaminas.modelo;

import java.io.Serializable;

public interface ICasilla extends Serializable {
    boolean tieneMina();
    boolean estaDescubierta();
    boolean estaMarcada();
    void descubrir() throws Exception;
    void marcar();
    int getMinasAdyacentes();
    void setMinasAdyacentes(int cantidad);
    String mostrar();
}
