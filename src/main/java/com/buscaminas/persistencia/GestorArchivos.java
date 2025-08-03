package com.buscaminas.persistencia;

import com.buscaminas.modelo.Jugador;
import com.buscaminas.modelo.Tablero;

import java.io.*;

public class GestorArchivos {
    private static final String RUTA_CARPETA = "datos";
    private static final String RUTA_ARCHIVO = RUTA_CARPETA + File.separator + "partida.dat";

    /**
     * Guarda la partida serializando el tablero y el jugador.
     */
    public static void guardarPartida(Tablero tablero, Jugador jugador) throws IOException {
        File carpeta = new File(RUTA_CARPETA);
        if (!carpeta.exists() && !carpeta.mkdirs()) {
            throw new IOException("No se pudo crear la carpeta para guardar los datos.");
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA_ARCHIVO))) {
            oos.writeObject(tablero);
            oos.writeObject(jugador);
        }
    }

    /**
     * Carga la partida desde el archivo serializado.
     * @return Un arreglo con dos elementos: [Tablero, Jugador]
     */
    public static Object[] cargarPartida() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RUTA_ARCHIVO))) {
            Tablero tablero = (Tablero) ois.readObject();
            Jugador jugador = (Jugador) ois.readObject();
            return new Object[]{tablero, jugador};
        }
    }

    /**
     * Verifica si existe un archivo de partida guardada.
     * @return true si existe y tiene contenido válido
     */
    public static boolean existePartidaGuardada() {
        File archivo = new File(RUTA_ARCHIVO);
        return archivo.exists() && archivo.isFile() && archivo.length() > 0;
    }

    /**
     * Elimina la partida guardada (opcional si lo quieres usar más adelante).
     */
    public static void eliminarPartidaGuardada() {
        File archivo = new File(RUTA_ARCHIVO);
        if (archivo.exists()) {
            archivo.delete();
        }
    }
}
