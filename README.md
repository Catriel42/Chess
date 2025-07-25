# ♟️ Proyecto de Ajedrez con Visualización de Algoritmos de Ordenación ♟️

¡Bienvenido al proyecto de Ajedrez! Este es un juego de ajedrez implementado en Java, diseñado para ser jugado a través de la línea de comandos. Lo que hace a este proyecto único es la **integración de algoritmos de ordenación**, que pueden ser visualizados o aplicados a las celdas del tablero, ofreciendo una perspectiva educativa y técnica más allá del juego tradicional.

## ✨ Características Principales

### Juego de Ajedrez

-   **Juego Completo de Ajedrez:** Implementación de las reglas básicas del ajedrez.
-   **Movimientos de Piezas:** Soporte para los movimientos de todas las piezas (Peón, Torre, Caballo, Alfil, Reina, Rey).
-   **Validación de Movimientos:** El juego valida los movimientos para asegurar que se ajusten a las reglas del ajedrez.
-   **Interfaz de Línea de Comandos (CLI):** Juega directamente en tu terminal con una interfaz clara y sencilla.

### Visualización de Algoritmos de Ordenación

-   **Algoritmos Implementados:** Incluye implementaciones de algoritmos de ordenación como Bubble Sort, Insertion Sort, Merge Sort y Quick Sort.
-   **Estrategia de Ordenación:** Utiliza un patrón Strategy para aplicar diferentes algoritmos de ordenación de manera flexible.
-   **Aplicación a Celdas del Tablero:** Los algoritmos de ordenación pueden ser aplicados o visualizados en las celdas del tablero de ajedrez, lo que sugiere una funcionalidad de demostración o análisis.

## 🚀 Tecnologías Utilizadas

-   **Java:** El lenguaje principal de desarrollo.

## ⚙️ Configuración y Ejecución

Para poner en marcha este proyecto en tu máquina local, sigue los siguientes pasos:

### Prerrequisitos

Asegúrate de tener instalado el Java Development Kit (JDK) en tu sistema. Puedes descargarlo desde el sitio oficial de Oracle o usar un gestor de paquetes como `sdkman`.

### Clonar el Repositorio

```bash
git clone https://github.com/tu-usuario/Chess.git # Reemplaza con la URL de tu repositorio
cd Chess
```

### Compilar y Ejecutar

Dado que este es un proyecto Java, puedes compilarlo y ejecutarlo usando `javac` y `java`.

```bash
# Compilar los archivos fuente
javac -d out/production/Chess src/*.java src/**/*.java

# Ejecutar el juego (o la demostración de ordenación, dependiendo de los argumentos)
java -cp out/production/Chess Main [argumentos_para_ordenacion]
```

**Nota:** Si estás utilizando un IDE como IntelliJ IDEA (como sugiere el archivo `Chess.iml`), puedes simplemente abrir el proyecto y ejecutar la clase `Main` directamente. Los argumentos de línea de comandos para la funcionalidad de ordenación se pasarían a través de la configuración de ejecución del IDE.

## 🎮 Cómo Jugar / Usar

Una vez que el juego se inicie, verás el tablero de ajedrez en tu terminal. El juego te pedirá que ingreses tus movimientos. Los movimientos se ingresan típicamente en notación de ajedrez (por ejemplo, `e2 e4` para mover un peón de e2 a e4).

Para la funcionalidad de ordenación, el programa puede aceptar argumentos de línea de comandos para especificar el algoritmo a utilizar y cómo se visualiza. Consulta la ayuda de la línea de comandos (`java -cp out/production/Chess Main --help`) o el código fuente de `CLIInputValidator` para más detalles sobre los argumentos disponibles.

## 📂 Estructura del Proyecto

```
Chess/
├───.git/
├───.idea/ # Archivos de configuración de IntelliJ IDEA
├───out/ # Clases compiladas
└───src/
    ├───BlackPieces.java
    ├───Board.java
    ├───BubbleSort.java
    ├───Cell.java
    ├───CellComparators.java
    ├───ChessManager.java
    ├───CLIInputValidator.java
    ├───InsertionSort.java
    ├───Main.java
    ├───MergeSort.java
    ├───Piece.java
    ├───QuickSort.java
    ├───SortStrategy.java
    ├───SortStrategyFactory.java
    └───WhitePieces.java
```

## 🤝 Contribuciones

¡Las contribuciones son bienvenidas! Si tienes ideas para mejorar el juego, reportar errores o añadir nuevas características, no dudes en abrir un *issue* o enviar un *pull request*.

## 📄 Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo `LICENSE` para más detalles. (Si no tienes uno, considera añadirlo).