# Visualizador de Algoritmos de Ordenamiento con Metáfora de Ajedrez

[English](README.md)

![Java](https://img.shields.io/badge/Java-21-blue?style=for-the-badge&logo=java)

¡Bienvenido! Esta es una herramienta de línea de comandos única, escrita en Java, que visualiza algoritmos de ordenamiento clásicos de una manera muy original: usando un tablero de ajedrez y sus piezas como los datos a ordenar.

**Nota Importante:** Esta es una herramienta educativa para visualizar algoritmos y **no** un juego de ajedrez funcional.

## ✨ Concepto Principal

El programa funciona colocando un número específico de piezas de ajedrez de forma aleatoria en un tablero de 8x8. Luego, ordena estas piezas basándose en un algoritmo y un criterio de comparación elegidos (ya sea por un número o una letra asignada a cada pieza).

La característica clave es la visualización: después de cada paso significativo del algoritmo de ordenamiento (por ejemplo, un intercambio), el tablero completo se vuelve a imprimir en la consola. Esto crea una animación paso a paso, permitiéndote observar cómo cada algoritmo opera y manipula los datos.

## 🚀 Características

-   **Múltiples Algoritmos de Ordenamiento:** Visualiza y compara diferentes estrategias de ordenamiento.
    -   Bubble Sort (Burbuja)
    -   Insertion Sort (Inserción)
    -   Quick Sort (Rápido)
    -   Merge Sort (Fusión)
-   **Ejecución Configurable:** Adapta la visualización a tus necesidades mediante argumentos de línea de comandos:
    -   Elige el **algoritmo de ordenamiento**.
    -   Selecciona el **criterio de ordenamiento** (numérico o alfabético).
    -   Define el **número de piezas** en el tablero.
    -   Controla la **velocidad de visualización** con una pausa configurable entre pasos.
-   **Arquitectura Limpia:** El proyecto aprovecha patrones de diseño fundamentales:
    -   **Patrón Strategy:** Para cambiar fácilmente entre diferentes algoritmos de ordenamiento.
    -   **Patrón Factory:** Para desacoplar la lógica principal de las implementaciones concretas de los algoritmos.

## ⚙️ Cómo Usarlo

### Prerrequisitos

Asegúrate de tener un Java Development Kit (JDK) instalado en tu sistema.

### Compilación

El proyecto está estructurado para ser compilado directamente desde la línea de comandos usando el compilador estándar de Java, `javac`.

**Comando:**
```bash
javac -d out/production/Chess src/*.java
```

### Ejecución del Visualizador

Después de una compilación exitosa, ejecuta el programa usando el comando `java`, que activa la Máquina Virtual de Java (JVM).

**Comando:**
```bash
java -cp out/production/Chess Main [ARGUMENTOS]
```

#### Argumentos de Línea de Comandos

Todos los argumentos son obligatorios y deben usar el formato `clave=valor`:

-   `a=<algoritmo>`: El algoritmo de ordenamiento a utilizar.
    -   `b`: Bubble Sort
    -   `i`: Insertion Sort
    -   `q`: Quick Sort
    -   `m`: Merge Sort
-   `t=<tipo>`: El criterio de comparación para el ordenamiento. Cada pieza, definida en `WhitePieces.java` y `BlackPieces.java`, tiene tanto un número como una letra asignados. Esta bandera determina cuál de esos atributos se usa para la comparación.
    -   `n`: Ordenar por el número asociado a cada pieza.
    -   `c`: Ordenar por la letra asociada a cada pieza.
-   `c=<color>`: El color de las piezas a utilizar.
    -   `w`: Piezas blancas
    -   `b`: Piezas negras
-   `r=<número>`: El número de piezas a colocar en el tablero.
    -   Valores permitidos: `8`, `10`, `16`.
-   `s=<milisegundos>`: El tiempo de pausa entre cada paso del algoritmo.
    -   Valores permitidos: `0` a `1000`.

#### Ejemplo

Para ejecutar una visualización de **Bubble Sort** (`a=b`) con **16 piezas negras** (`r=16`, `c=b`), ordenándolas por **número** (`t=n`) con una **pausa de 100ms** (`s=100`) entre pasos, usa el siguiente comando:

```bash
java -cp out/production/Chess Main a=b t=n c=b r=16 s=100
```

https://github.com/user-attachments/assets/ce1e2ed5-219c-4b07-b3ad-423f7c9ccd22

## 📂 Estructura del Proyecto

El proyecto está organizado con una clara separación de responsabilidades:

-   `Main.java`: El punto de entrada de la aplicación.
-   `CLIInputValidator.java`: Analiza y valida todos los argumentos de la línea de comandos.
-   `ChessManager.java`: La clase principal que orquesta la configuración y ejecución de la visualización del ordenamiento.
-   `Board.java` & `Cell.java`: Representan el tablero de ajedrez y sus casillas individuales.
-   `Piece.java`, `WhitePieces.java`, `BlackPieces.java`: Definen la interfaz y las implementaciones concretas de las piezas de ajedrez, que actúan como los elementos de datos.
-   `SortStrategy.java`: La interfaz para todas las implementaciones de algoritmos de ordenamiento (Patrón Strategy).
-   `BubbleSort.java`, `InsertionSort.java`, etc.: Implementaciones concretas de los algoritmos de ordenamiento.
-   `SortStrategyFactory.java`: Una clase fábrica para crear la instancia de la estrategia de ordenamiento apropiada según la entrada del usuario.
-   `CellComparators.java`: Provee objetos `Comparator` utilizados para definir la lógica de ordenamiento (por número o por letra).

## 🤝 Contribuciones

¡Las contribuciones son bienvenidas! Si tienes ideas para mejoras, nuevas características o correcciones de errores, no dudes en abrir un *issue* o enviar un *pull request*.
