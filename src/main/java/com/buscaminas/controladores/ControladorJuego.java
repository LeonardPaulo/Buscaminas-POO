package com.buscaminas.controladores;

import com.buscaminas.modelo.Jugador;
import com.buscaminas.modelo.Tablero;
import com.buscaminas.excepciones.CasillaMarcadaException;
import com.buscaminas.excepciones.CoordenadaInvalidaException;
import com.buscaminas.excepciones.SalidaAnticipadaException;
import com.buscaminas.persistencia.GestorArchivos;
import com.buscaminas.vista.VistaConsola;

import java.io.IOException;

public class ControladorJuego {

    private Tablero tablero;
    private Jugador jugador;
    private VistaConsola vista;

    public ControladorJuego(VistaConsola vista) {
        this.vista = vista;
    }

    public void iniciarJuego() throws SalidaAnticipadaException {
        vista.mostrarBienvenida();

        if (GestorArchivos.existePartidaGuardada() && vista.preguntarSiCargarPartida()) {
            vista.mostrarCargando();
            try {
                Object[] partida = GestorArchivos.cargarPartida();
                tablero = (Tablero) partida[0];
                jugador = (Jugador) partida[1];
                vista.mostrarMensaje("Partida cargada correctamente.");
            } catch (IOException | ClassNotFoundException e) {
                vista.mostrarError("No se pudo cargar la partida: " + e.getMessage());
                jugador = new Jugador(vista.pedirNombreJugador());
                nuevoTablero();
            }
        } else {
            jugador = new Jugador(vista.pedirNombreJugador());
            nuevoTablero();
        }

        iniciarBucleJuego();
        vista.mostrarMensaje("Gracias por jugar Buscaminas!");
    }

    public void cargarYContinuar() throws SalidaAnticipadaException {
        if (GestorArchivos.existePartidaGuardada()) {
            vista.mostrarCargando();
            try {
                Object[] partida = GestorArchivos.cargarPartida();
                tablero = (Tablero) partida[0];
                jugador = (Jugador) partida[1];
                vista.mostrarMensaje("Partida cargada correctamente.");
                iniciarBucleJuego();
            } catch (IOException | ClassNotFoundException e) {
                vista.mostrarError("Error al cargar la partida: " + e.getMessage());
            }
        } else {
            vista.mostrarMensaje("No hay partida guardada.");
        }
    }

    private void iniciarBucleJuego() throws SalidaAnticipadaException {
        boolean jugando = true;

        while (jugando) {
            vista.mostrarEstadoJuego(tablero, jugador);
            vista.mostrarTablero(tablero);

            String comando = vista.pedirComando();
            try {
                procesarComando(comando);

                if (tablero.todasLasCasillasSegurasDescubiertas()) {
                    finalizarVictoria();
                    jugando = vista.preguntarNuevoJuego();
                    if (jugando) {
                        vista.mostrarCargando();
                        nuevoTablero();
                    }
                }
            } catch (SalidaAnticipadaException e) {
                throw e;
            } catch (Exception e) {
                vista.mostrarError(e.getMessage());
            }

            if (jugador.haPerdido()) {
                tablero.revelarTodasLasMinas();
                vista.mostrarEstadoJuego(tablero, jugador);
                vista.mostrarTablero(tablero);
                vista.mostrarDerrota();

                jugando = vista.preguntarNuevoJuego();
                if (jugando) {
                    vista.mostrarCargando();
                    nuevoTablero();
                }
            }
        }
    }

    private void nuevoTablero() {
        tablero = new Tablero();
        jugador.reiniciar();
    }

    private void procesarComando(String comando) throws Exception {
        if (comando.isEmpty()) throw new IllegalArgumentException("Comando vacío");

        String[] partes = comando.trim().split("\\s+");
        String accion = partes[0].toUpperCase();

        switch (accion) {
            case "R":
                if (partes.length < 2) throw new IllegalArgumentException("Falta coordenada para revelar");
                int[] coordsR = parsearCoordenada(partes[1]);
                revelarCasilla(coordsR[0], coordsR[1]);
                break;

            case "M":
                if (partes.length < 2) throw new IllegalArgumentException("Falta coordenada para marcar");
                int[] coordsM = parsearCoordenada(partes[1]);
                marcarCasilla(coordsM[0], coordsM[1]);
                break;

            case "GUARDAR":
                vista.mostrarCargando();
                try {
                    GestorArchivos.guardarPartida(tablero, jugador);
                    vista.mostrarMensaje("Partida guardada exitosamente.");
                } catch (IOException e) {
                    vista.mostrarError("Error al guardar la partida: " + e.getMessage());
                }
                break;

            case "CARGAR":
                vista.mostrarCargando();
                try {
                    if (GestorArchivos.existePartidaGuardada()) {
                        Object[] partida = GestorArchivos.cargarPartida();
                        tablero = (Tablero) partida[0];
                        jugador = (Jugador) partida[1];
                        vista.mostrarMensaje("Partida cargada correctamente.");
                        vista.mostrarEstadoJuego(tablero, jugador);
                        vista.mostrarTablero(tablero);
                    } else {
                        vista.mostrarMensaje("No hay partida guardada.");
                    }
                } catch (IOException | ClassNotFoundException e) {
                    vista.mostrarError("Error al cargar la partida: " + e.getMessage());
                }
                break;

            case "AYUDA":
                vista.mostrarInstrucciones();
                break;

            case "SALIR":
                throw new SalidaAnticipadaException("Saliendo al menú principal...");

            default:
                throw new IllegalArgumentException("Comando desconocido: " + accion);
        }
    }

    private int[] parsearCoordenada(String coordenada) throws CoordenadaInvalidaException {
        coordenada = coordenada.toUpperCase().trim();
        if (coordenada.length() < 2 || coordenada.length() > 3) {
            throw new CoordenadaInvalidaException("Formato de coordenada inválido.");
        }

        char filaChar = coordenada.charAt(0);
        if (filaChar < 'A' || filaChar > 'J') {
            throw new CoordenadaInvalidaException("Fila inválida: debe ser entre A y J.");
        }
        int fila = filaChar - 'A';

        int columna;
        try {
            columna = Integer.parseInt(coordenada.substring(1)) - 1;
        } catch (NumberFormatException e) {
            throw new CoordenadaInvalidaException("Columna inválida.");
        }
        if (columna < 0 || columna > 9) {
            throw new CoordenadaInvalidaException("Columna fuera de rango.");
        }

        return new int[]{fila, columna};
    }

    private void revelarCasilla(int fila, int columna) throws Exception {
        if (tablero.obtenerCasilla(fila, columna).estaMarcada()) {
            throw new CasillaMarcadaException("No puedes descubrir una casilla marcada.");
        }

        tablero.descubrir(fila, columna);

        if (tablero.obtenerCasilla(fila, columna).tieneMina()) {
            jugador.perder();
        } else {
            jugador.incrementarPuntaje(1);
        }
    }

    private void marcarCasilla(int fila, int columna) {
        tablero.marcar(fila, columna);
    }

    private void finalizarVictoria() {
        jugador.incrementarPartidasGanadas();
        vista.mostrarVictoria(jugador);
    }
}
