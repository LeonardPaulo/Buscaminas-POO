package com.buscaminas.main;

import com.buscaminas.controladores.ControladorJuego;
import com.buscaminas.excepciones.SalidaAnticipadaException;
import com.buscaminas.vista.VistaConsola;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VistaConsola vista = new VistaConsola();
        Scanner scanner = new Scanner(System.in);
        boolean ejecutando = true;

        while (ejecutando) {
            vista.limpiarPantalla();
            System.out.println("\n╔══════════ MENÚ PRINCIPAL ══════════════════╗");
            System.out.println("    1. Nueva partida                          ");
            System.out.println("    2. Cargar partida                         ");
            System.out.println("    3. Salir                                  ");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.println();
            System.out.print("Selecciona una opción: ");
            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1":
                    ControladorJuego juegoNuevo = new ControladorJuego(vista);
                    try {
                        juegoNuevo.iniciarJuego();
                    } catch (SalidaAnticipadaException e) {
                        vista.mostrarMensaje("Volviendo al menú principal...");
                    }
                    break;

                case "2":
                    ControladorJuego juegoCargado = new ControladorJuego(vista);
                    try {
                        juegoCargado.cargarYContinuar();
                    } catch (SalidaAnticipadaException e) {
                        vista.mostrarMensaje("Volviendo al menú principal...");
                    }
                    break;

                case "3":
                    ejecutando = false;
                    vista.mostrarMensaje("¡Hasta pronto!");
                    break;

                default:
                    vista.mostrarError("Opción inválida. Intenta de nuevo.");
            }
        }

        vista.cerrar();
    }
}
