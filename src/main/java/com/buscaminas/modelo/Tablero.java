package com.buscaminas.modelo;

import java.io.Serializable;
import java.util.Random;
import com.buscaminas.excepciones.CasillaYaDescubiertaException;

public class Tablero implements ITablero, Serializable {
    private static final long serialVersionUID = 1L;
    public static final int TAMAÑO = 10;
    public static final int CANTIDAD_MINAS = 10;

    private ICasilla[][] casillas;

    public Tablero() {
        casillas = new ICasilla[TAMAÑO][TAMAÑO];
        inicializarCasillas();
        colocarMinas();
        calcularMinasAdyacentes();
    }

    private void inicializarCasillas() {
        for (int i = 0; i < TAMAÑO; i++) {
            for (int j = 0; j < TAMAÑO; j++) {
                casillas[i][j] = new CasillaVacia();
            }
        }
    }

    private void colocarMinas() {
        Random rnd = new Random();
        int minasColocadas = 0;
        while (minasColocadas < CANTIDAD_MINAS) {
            int fila = rnd.nextInt(TAMAÑO);
            int col = rnd.nextInt(TAMAÑO);
            if (!casillas[fila][col].tieneMina()) {
                casillas[fila][col] = new CasillaMina();
                minasColocadas++;
            }
        }
    }

    private void calcularMinasAdyacentes() {
        for (int fila = 0; fila < TAMAÑO; fila++) {
            for (int col = 0; col < TAMAÑO; col++) {
                if (!casillas[fila][col].tieneMina()) {
                    int minasCercanas = contarMinasAlrededor(fila, col);
                    casillas[fila][col].setMinasAdyacentes(minasCercanas);
                }
            }
        }
    }

    private int contarMinasAlrededor(int fila, int col) {
        int minas = 0;
        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < TAMAÑO && j >= 0 && j < TAMAÑO) {
                    if (casillas[i][j].tieneMina()) {
                        minas++;
                    }
                }
            }
        }
        return minas;
    }

    @Override
    public ICasilla obtenerCasilla(int fila, int columna) {
        return casillas[fila][columna];
    }

    @Override
    public void descubrir(int fila, int columna) throws Exception {
        ICasilla casilla = casillas[fila][columna];

        if (casilla.estaDescubierta()) {
            // En vez de lanzar excepción, simplemente ignorar la llamada
            return;
        }

        casilla.descubrir();

        if (!casilla.tieneMina() && casilla.getMinasAdyacentes() == 0) {
            for (int i = fila - 1; i <= fila + 1; i++) {
                for (int j = columna - 1; j <= columna + 1; j++) {
                    if (i >= 0 && i < TAMAÑO && j >= 0 && j < TAMAÑO) {
                        ICasilla vecino = casillas[i][j];
                        if (!vecino.estaDescubierta() && !vecino.tieneMina()) {
                            descubrir(i, j);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void marcar(int fila, int columna) {
        casillas[fila][columna].marcar();
    }

    @Override
    public boolean todasLasCasillasSegurasDescubiertas() {
        for (int i = 0; i < TAMAÑO; i++) {
            for (int j = 0; j < TAMAÑO; j++) {
                ICasilla c = casillas[i][j];
                if (!c.tieneMina() && !c.estaDescubierta()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void mostrarTablero() {
        System.out.print("   ");
        for (int col = 1; col <= TAMAÑO; col++) {
            System.out.printf("%2d ", col);
        }
        System.out.println();

        for (int fila = 0; fila < TAMAÑO; fila++) {
            char letra = (char) ('A' + fila);
            System.out.print(" " + letra + " ");
            for (int col = 0; col < TAMAÑO; col++) {
                System.out.print(" " + casillas[fila][col].mostrar() + " ");
            }
            System.out.println();
        }
    }

    public void revelarTodasLasMinas() {
        for (int i = 0; i < TAMAÑO; i++) {
            for (int j = 0; j < TAMAÑO; j++) {
                ICasilla c = casillas[i][j];
                if (c.tieneMina()) {
                    try {
                        c.descubrir();
                    } catch (Exception e) {
                        // Ignorar excepción si está marcada
                    }
                }
            }
        }
    }

    public int getCasillasReveladas() {
        int cont = 0;
        for (int i = 0; i < TAMAÑO; i++) {
            for (int j = 0; j < TAMAÑO; j++) {
                if (casillas[i][j].estaDescubierta()) {
                    cont++;
                }
            }
        }
        return cont;
    }

    public int getCasillasMarcadas() {
        int contador = 0;
        for (int i = 0; i < TAMAÑO; i++) {
            for (int j = 0; j < TAMAÑO; j++) {
                if (casillas[i][j].estaMarcada()) {
                    contador++;
                }
            }
        }
        return contador;
    }
}
