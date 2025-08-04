package com.buscaminas.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.buscaminas.modelo.CasillaMina;
import com.buscaminas.modelo.CasillaVacia;
import com.buscaminas.modelo.ICasilla;
import com.buscaminas.excepciones.CasillaYaDescubiertaException;

public class CasillaTest {

    private ICasilla casillaVacia;
    private ICasilla casillaMina;

    @BeforeEach
    public void setup() {
        casillaVacia = new CasillaVacia();
        casillaMina = new CasillaMina();
    }

    @Test
    public void testCasillaVaciaInicial() {
        assertFalse(casillaVacia.tieneMina());
        assertFalse(casillaVacia.estaDescubierta());
        assertFalse(casillaVacia.estaMarcada());
        assertEquals("■", casillaVacia.mostrar());
        assertEquals(0, casillaVacia.getMinasAdyacentes());
    }

    @Test
    public void testCasillaVaciaDescubrirYMarcar() throws Exception {
        casillaVacia.marcar();
        assertTrue(casillaVacia.estaMarcada());
        assertEquals("M", casillaVacia.mostrar());

        casillaVacia.marcar();
        assertFalse(casillaVacia.estaMarcada());
        assertEquals("■", casillaVacia.mostrar());

        casillaVacia.descubrir();
        assertTrue(casillaVacia.estaDescubierta());
        assertEquals("□", casillaVacia.mostrar());

        assertThrows(CasillaYaDescubiertaException.class, () -> {
            casillaVacia.descubrir();
        });
    }

    @Test
    public void testCasillaVaciaMinasAdyacentes() throws Exception {
        casillaVacia.setMinasAdyacentes(3);
        assertEquals(3, casillaVacia.getMinasAdyacentes());

        casillaVacia.descubrir();
        assertEquals("3", casillaVacia.mostrar());
    }

    @Test
    public void testCasillaMina() throws Exception {
        assertTrue(casillaMina.tieneMina());
        assertFalse(casillaMina.estaDescubierta());
        assertFalse(casillaMina.estaMarcada());
        assertEquals("■", casillaMina.mostrar());

        casillaMina.marcar();
        assertTrue(casillaMina.estaMarcada());
        assertEquals("M", casillaMina.mostrar());

        casillaMina.marcar();
        assertFalse(casillaMina.estaMarcada());
        assertEquals("■", casillaMina.mostrar());

        casillaMina.descubrir();
        assertTrue(casillaMina.estaDescubierta());
        assertEquals("X", casillaMina.mostrar());

        assertThrows(CasillaYaDescubiertaException.class, () -> {
            casillaMina.descubrir();
        });
    }
}
