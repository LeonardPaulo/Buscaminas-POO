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
- │ ├── main/
- │ │ └── java/com/buscaminas/
- │ │ ├── controlador/ # Controladores de la lógica del juego
- │ │ ├── excepciones/ # Excepciones personalizadas
- │ │ ├── main/ # Punto de entrada (Main.java)
- │ │ ├── modelo/ # Clases del modelo (Tablero, Casilla, Jugador, etc.)
- │ │ ├── persistencia/ # Guardado y carga de partidas (GestorArchivos.java)
- │ │ └── vista/ # Interfaz de usuario (consola)
- │ └── test/
- │ └── java/com/buscaminas/test/ # Tests unitarios con JUnit 5
- ├── datos/ # Archivos de guardado (crear manualmente)
- ├── pom.xml # Configuración Maven
- ├── README.md # Este archivo
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
- IDE recomendado: IntelliJ IDEA o cualquier editor compatible con Java

---
## Instalación y compilación
1. Clonar el repositorio:
   git clone https://github.com/tuusuario/buscaminas-poo.git
2. Entrar a la carpeta del proyecto:
   cd buscaminas-poo
3. Compilar el proyecto con Maven:
   mvn clean compile

---
## Uso
Para ejecutar el juego en consola, usa el comando:

mvn exec:java -Dexec.mainClass="com.buscaminas.main.Main"

El juego te pedirá tu nombre y luego podrás ingresar comandos como:

- `R A5` — Revelar la casilla en fila A columna 5
- `M B3` — Marcar la casilla en fila B columna 3
- `GUARDAR` — Guardar la partida actual
- `CARGAR` — Cargar la partida guardada
- `AYUDA` — Mostrar las instrucciones
- `SALIR` — Salir del juego

---
## Guardado y carga de partidas
El juego guarda el estado de la partida (tablero y jugador) en archivos binarios dentro de la carpeta `datos/`:

- `datos/partida_tablero.dat`
- `datos/partida_jugador.dat`

Para usar esta función:
- Asegúrate que la carpeta `datos` exista en la raíz del proyecto.
- Usa el comando `GUARDAR` para guardar el estado actual.
- Usa el comando `CARGAR` para cargar la partida guardada.

Si no hay archivos guardados o hay error, el juego mostrará un mensaje en consola y continuará normalmente.

---
## Testing
Para ejecutar los tests unitarios con JUnit 5:

- mvn test

Incluye pruebas para las clases principales como `Casilla`, `Tablero` y `Jugador`.

---
## Colaboración y Git
- El proyecto usa Git para control de versiones.
- Cada miembro del equipo debe hacer al menos 2 commits en fechas distintas.
- Usa mensajes descriptivos en los commits, por ejemplo:
  - git add .
  - git commit -m "Implementa lógica para descubrir casilla vacía"
  - git push origin main

---
## Licencia
Proyecto académico para la Universidad Politécnica Salesiana.  
No usar con fines comerciales sin autorización.

---
¡Gracias por jugar y colaborar con este proyecto!
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
- │ ├── main/
- │ │ └── java/com/buscaminas/
- │ │ ├── controlador/ # Controladores de la lógica del juego
- │ │ ├── excepciones/ # Excepciones personalizadas
- │ │ ├── main/ # Punto de entrada (Main.java)
- │ │ ├── modelo/ # Clases del modelo (Tablero, Casilla, Jugador, etc.)
- │ │ ├── persistencia/ # Guardado y carga de partidas (GestorArchivos.java)
- │ │ └── vista/ # Interfaz de usuario (consola)
- │ └── test/
- │ └── java/com/buscaminas/test/ # Tests unitarios con JUnit 5
- ├── datos/ # Archivos de guardado (crear manualmente)
- ├── pom.xml # Configuración Maven
- ├── README.md # Este archivo
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
- IDE recomendado: IntelliJ IDEA o cualquier editor compatible con Java

---
## Instalación y compilación
1. Clonar el repositorio:
   git clone https://github.com/tuusuario/buscaminas-poo.git
2. Entrar a la carpeta del proyecto:
   cd buscaminas-poo
3. Compilar el proyecto con Maven:
   mvn clean compile

---
## Uso
Para ejecutar el juego en consola, usa el comando:

mvn exec:java -Dexec.mainClass="com.buscaminas.main.Main"

El juego te pedirá tu nombre y luego podrás ingresar comandos como:

- `R A5` — Revelar la casilla en fila A columna 5
- `M B3` — Marcar la casilla en fila B columna 3
- `GUARDAR` — Guardar la partida actual
- `CARGAR` — Cargar la partida guardada
- `AYUDA` — Mostrar las instrucciones
- `SALIR` — Salir del juego

---
## Guardado y carga de partidas
El juego guarda el estado de la partida (tablero y jugador) en archivos binarios dentro de la carpeta `datos/`:

- `datos/partida_tablero.dat`
- `datos/partida_jugador.dat`

Para usar esta función:
- Asegúrate que la carpeta `datos` exista en la raíz del proyecto.
- Usa el comando `GUARDAR` para guardar el estado actual.
- Usa el comando `CARGAR` para cargar la partida guardada.

Si no hay archivos guardados o hay error, el juego mostrará un mensaje en consola y continuará normalmente.

---
## Testing
Para ejecutar los tests unitarios con JUnit 5:

- mvn test

Incluye pruebas para las clases principales como `Casilla`, `Tablero` y `Jugador`.

---
## Colaboración y Git
- El proyecto usa Git para control de versiones.
- Cada miembro del equipo debe hacer al menos 2 commits en fechas distintas.
- Usa mensajes descriptivos en los commits, por ejemplo:
  - git add .
  - git commit -m "Implementa lógica para descubrir casilla vacía"
  - git push origin main

---
## Licencia
Proyecto académico para la Universidad Politécnica Salesiana.  
No usar con fines comerciales sin autorización.

---
¡Gracias por jugar y colaborar con este proyecto!
