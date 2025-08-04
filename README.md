# Buscaminas POO

---

## Descripción

Juego clásico de Buscaminas desarrollado en Java aplicando Programación Orientada a Objetos (POO) y el patrón MVC.  
La aplicación corre en consola y permite guardar y cargar partidas para continuar el juego.

El objetivo del juego es descubrir todas las casillas que no contienen minas en un tablero de 10x10 con 10 minas distribuidas aleatoriamente. El jugador puede descubrir o marcar casillas para evitar minas, y gana si descubre todas las casillas seguras.

---

## Estructura del Proyecto

buscaminas-poo/
- ├── src/
- │   ├── main/
- │   │   └── java/com/buscaminas/
- │   │       ├── controlador/      # Controladores de la lógica del juego
- │   │       ├── excepciones/      # Excepciones personalizadas
- │   │       ├── main/             # Punto de entrada (Main.java)
- │   │       ├── modelo/           # Clases del modelo (Tablero, Casilla, Jugador, etc.)
- │   │       ├── persistencia/     # Guardado y carga de partidas (GestorArchivos.java)
- │   │       └── vista/            # Interfaz de usuario (consola)
- │   └── test/
- │       └── java/com/buscaminas/test/  # Tests unitarios con JUnit 5
- ├── datos/                        # Archivos de guardado (crear manualmente)
- ├── pom.xml                      # Configuración Maven
- ├── README.md                    # Este archivo
- └── .gitignore

---

## Tecnologías usadas

- Java 17
- Maven (para compilación y ejecución)
- JUnit 5 (para testing)
- Consola / Terminal para la interfaz de usuario
- Git y GitHub para control de versiones

---

## Requisitos previos

- Tener instalado Java 17 o superior
- Tener Maven instalado y configurado en PATH
- IDE recomendado: IntelliJ IDEA, Eclipse o cualquier editor compatible con Java

---

## Instalación y compilación

1. Clonar el repositorio:  
   git clone https://github.com/tuusuario/buscaminas-poo.git

2. Entrar a la carpeta del proyecto:  
   cd buscaminas-poo

3. Compilar el proyecto con Maven:  
   mvn clean compile

---

## Uso / Cómo jugar

Para ejecutar el juego en consola, usa el siguiente comando:

mvn exec:java -Dexec.mainClass="com.buscaminas.main.Main"

Al iniciar, el juego pedirá tu nombre y luego podrás ingresar comandos para jugar.

---

## Comandos disponibles

Comando          | Descripción                                              | Ejemplo  
-----------------|----------------------------------------------------------|---------
R <coordenada>   | Revelar una casilla en la posición indicada              | R A5  
M <coordenada>   | Marcar o desmarcar una casilla como sospechosa de mina   | M B3  
GUARDAR          | Guardar la partida actual                                 | GUARDAR  
CARGAR           | Cargar la partida guardada                                | CARGAR  
AYUDA            | Mostrar las instrucciones y comandos                      | AYUDA  
SALIR            | Salir del juego y volver al menú principal                | SALIR  

---

## Formato de coordenadas

- La coordenada se compone de una letra (A-J) para la fila y un número (1-10) para la columna.
- Ejemplos válidos: A5, B10, J1.

---

## Cómo jugar

- Usa `R <coordenada>` para revelar una casilla.
- Si revelas una mina, pierdes y termina el juego.
- Si la casilla está vacía y sin minas alrededor, se revelarán automáticamente las casillas adyacentes vacías.
- Usa `M <coordenada>` para marcar una casilla donde creas que hay una mina, para evitar descubrirla accidentalmente.
- Puedes guardar la partida en cualquier momento con el comando `GUARDAR`.
- Carga una partida guardada con `CARGAR`.
- Consulta `AYUDA` si olvidas los comandos.
- Para salir del juego, escribe `SALIR`.

---

## Guardado y carga de partidas

- El estado del juego se guarda en archivos binarios en la carpeta `datos/`:

    - datos/partida_tablero.dat
    - datos/partida_jugador.dat

- Asegúrate de crear la carpeta `datos` en la raíz del proyecto antes de usar estas funciones.
- Si no hay archivos guardados o ocurre un error, el juego mostrará un mensaje y seguirá funcionando normalmente.

---

## Testing

Para ejecutar pruebas unitarias con JUnit 5, usa:

mvn test

El proyecto incluye pruebas para las clases principales como Casilla, Tablero y Jugador.

---

## Colaboración y Git

- El proyecto usa Git para control de versiones.
- Cada miembro del equipo debe hacer al menos 2 commits en fechas diferentes.
- Usa mensajes descriptivos para los commits, por ejemplo:

  git add .  
  git commit -m "Implementa lógica para descubrir casilla vacía"  
  git push origin main

---

## Licencia

Proyecto académico para la Universidad Politécnica Salesiana.  
No usar con fines comerciales sin autorización.

---

¡Gracias por jugar y colaborar con este proyecto!
