package com.buscaminas.vista;

import java.util.Scanner;
import com.buscaminas.modelo.Tablero;
import com.buscaminas.modelo.Jugador;

public class VistaConsola {
    private Scanner scanner;

    public VistaConsola() {
        this.scanner = new Scanner(System.in);
    }

    public void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public void mostrarBienvenida() {
        limpiarPantalla();
        System.out.println("╔══════════ BUSCAMINAS ═════════════════╗");
        System.out.println("    Programación Orientada a Objetos     ");
        System.out.println("    Universidad Politécnica Salesiana    ");
        System.out.println("╚═══════════════════════════════════════╝");
        System.out.println();
        System.out.println("🎯 OBJETIVO: Descubre todas las casillas sin minas");
        System.out.println("💣 CUIDADO: Hay " + Tablero.CANTIDAD_MINAS + " minas ocultas en el tablero " +
                Tablero.TAMAÑO + "x" + Tablero.TAMAÑO);
        System.out.println();
    }

    public void mostrarInstrucciones() {
        System.out.println();
        System.out.println("┌────────── COMANDOS ──────────────────────────────┐");
        System.out.println("    R Coordenada   - Revelar casilla (ej: R A5)    ");
        System.out.println("    M Coordenada   - Marcar casilla (ej: M B3)     ");
        System.out.println("    GUARDAR        - Guardar partida actual        ");
        System.out.println("    CARGAR         - Cargar partida guardada       ");
        System.out.println("    AYUDA          - Mostrar comandos del juego    ");
        System.out.println("    SALIR          - Salir del juego               ");
        System.out.println("└─────────────────────────────────────────────────┘");
        System.out.println();
        System.out.println("COORDENADAS: Fila (A-J) + Columna (1-10)");
        System.out.println();
        System.out.println("┌────────── SÍMBOLOS ──────────────────┐");
        System.out.println("    ■ = Casilla sin revelar             ");
        System.out.println("    F = Casilla marcada                 ");
        System.out.println("    V = Casilla vacía                   ");
        System.out.println("    X = Mina                            ");
        System.out.println("    1-8 = Número de minas adyacentes    ");
        System.out.println("└──────────────────────────────────────┘");
    }

    public void mostrarEstadoJuego(Tablero tablero, Jugador jugador) {
        System.out.println();
        System.out.println("\n╔═════════ DATOS ════════════════════════════════════════════╗");
        System.out.println("    👤 Jugador: " + jugador.getNombre() +
                "         | 🏆 Puntaje: " + jugador.getPuntaje());
        System.out.println("    🎯 Partidas ganadas: " + jugador.getPartidasGanadas() +
                "      | 💣 Minas: " + Tablero.CANTIDAD_MINAS);
        System.out.println("    🔍 Casillas reveladas: " + tablero.getCasillasReveladas() +
                        "/" + (Tablero.TAMAÑO * Tablero.TAMAÑO - Tablero.CANTIDAD_MINAS) +
                " | 🚩 Casillas marcadas: " + tablero.getCasillasMarcadas());
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println();
    }

    public void mostrarTablero(Tablero tablero) {
        tablero.mostrarTablero();
    }

    public String pedirComando() {
        System.out.println();
        System.out.print("Ingrese su comando: ");
        return scanner.nextLine().trim().toUpperCase();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println();
        System.out.println(mensaje);
    }

    public void mostrarError(String error) {
        System.out.println();
        System.out.println("ERROR: " + error);
    }

    public void mostrarVictoria(Jugador jugador) {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("                ¡FELICIDADES!                     ");
        System.out.println("                ¡HAS GANADO!                        ");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println();
        System.out.println("Has descubierto todas las casillas sin minas");
        System.out.println("🏆 Puntaje obtenido: " + jugador.getPuntaje() + " puntos");
        System.out.println();
    }

    public void mostrarDerrota() {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("                   ¡BOOM!                         ");
        System.out.println("             Has pisado una mina                  ");
        System.out.println("              ¡Juego terminado!                   ");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println();
    }

    public boolean preguntarNuevoJuego() {
        System.out.print("¿Deseas jugar otra partida? (S/N): ");
        String respuesta = scanner.nextLine().trim().toUpperCase();
        return respuesta.equals("S") || respuesta.equals("SI") || respuesta.equals("SÍ");
    }

    public String pedirNombreJugador() {
        System.out.println();
        System.out.print("Ingresa tu nombre: ");
        String nombre = scanner.nextLine().trim();
        return nombre.isEmpty() ? "Jugador" : nombre;
    }

    public void mostrarCargando() {
        System.out.println();
        System.out.print("⏳ Cargando");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(500);
                System.out.print(".");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public boolean preguntarSiCargarPartida() {
        System.out.print("¿Deseas cargar la partida guardada? (S/N): ");
        String respuesta = scanner.nextLine().trim().toUpperCase();
        return respuesta.equals("S") || respuesta.equals("SI") || respuesta.equals("SÍ");
    }

    public void cerrar() {
        scanner.close();
    }
}
