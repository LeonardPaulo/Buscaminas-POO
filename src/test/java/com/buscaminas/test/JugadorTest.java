package com.buscaminas.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.buscaminas.modelo.Jugador;

public class JugadorTest {

    private Jugador jugador;

    @BeforeEach
    public void setup() {
        jugador = new Jugador("Tester");
    }

    @Test
    public void testNombre() {
        assertEquals("Tester", jugador.getNombre());
    }

    @Test
    public void testPuntajeInicial() {
        assertEquals(0, jugador.getPuntaje());
    }

    @Test
    public void testIncrementarPuntaje() {
        jugador.incrementarPuntaje(10);
        assertEquals(10, jugador.getPuntaje());
    }

    @Test
    public void testPartidasGanadas() {
        jugador.incrementarPartidasGanadas();
        assertEquals(1, jugador.getPartidasGanadas());
    }
}
