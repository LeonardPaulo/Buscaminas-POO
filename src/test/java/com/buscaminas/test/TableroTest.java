package com.buscaminas.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.buscaminas.modelo.Tablero;
import com.buscaminas.modelo.ICasilla;
import com.buscaminas.excepciones.CasillaYaDescubiertaException;

public class TableroTest {

    private Tablero tablero;

    @BeforeEach
    public void setup() {
        tablero = new Tablero();
    }

    @Test
    public void testInicializacion() {
        assertNotNull(tablero);
        // Validar que el tablero tenga el tamaño correcto
        ICasilla primeraCasilla = tablero.obtenerCasilla(0, 0);
        assertNotNull(primeraCasilla);
        assertTrue(primeraCasilla instanceof ICasilla);
    }

    @Test
    public void testCantidadDeMinas() {
        int minasContadas = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tablero.obtenerCasilla(i, j).tieneMina()) {
                    minasContadas++;
                }
            }
        }
        assertEquals(10, minasContadas);
    }

    @Test
    public void testDescubrirCasillaSegura() throws Exception {
        boolean descubierta = false;
        for (int i = 0; i < 10 && !descubierta; i++) {
            for (int j = 0; j < 10 && !descubierta; j++) {
                if (!tablero.obtenerCasilla(i, j).tieneMina()) {
                    tablero.descubrir(i, j);
                    assertTrue(tablero.obtenerCasilla(i, j).estaDescubierta());
                    descubierta = true;
                }
            }
        }
        assertTrue(descubierta, "No se encontró casilla sin mina para descubrir");
    }

    @Test
    public void testMarcarCasilla() {
        tablero.marcar(0, 0);
        assertTrue(tablero.obtenerCasilla(0, 0).estaMarcada());
        tablero.marcar(0, 0);
        assertFalse(tablero.obtenerCasilla(0, 0).estaMarcada());
    }

    @Test
    public void testTodasLasCasillasSegurasDescubiertas() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (!tablero.obtenerCasilla(i, j).tieneMina()) {
                    try {
                        tablero.descubrir(i, j);
                    } catch (CasillaYaDescubiertaException e) {
                    } catch (Exception e) {
                        fail("Se lanzó una excepción inesperada: " + e.getMessage());
                    }
                }
            }
        }
        assertTrue(tablero.todasLasCasillasSegurasDescubiertas());
    }
}
