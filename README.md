# Sorting Algorithm Visualizer using a Chessboard Metaphor

![Java](https://img.shields.io/badge/Java-21-blue?style=for-the-badge&logo=java)

Welcome! This is a unique command-line tool, written in Java, that visualizes classic sorting algorithms in a highly original way: by using a chessboard and its pieces as the data to be sorted.

**Please Note:** This is an educational tool for visualizing algorithms and **not** a playable chess game.

## ✨ Core Concept

The program works by placing a specified number of chess pieces randomly onto an 8x8 board. It then sorts these pieces based on a chosen algorithm and comparison criteria (either by a number or a letter assigned to each piece).

The key feature is the visualization: after each significant step of the sorting algorithm (e.g., a swap), the entire board is reprinted to the console. This creates a step-by-step animation, allowing you to observe how each algorithm operates and manipulates the data.

## 🚀 Features

-   **Multiple Sorting Algorithms:** Visualize and compare different sorting strategies.
    -   Bubble Sort
    -   Insertion Sort
    -   Quick Sort
    -   Merge Sort
-   **Configurable Execution:** Tailor the visualization to your needs through command-line arguments:
    -   Choose the **sorting algorithm**.
    -   Select the **sorting criteria** (numeric or alphabetic).
    -   Define the **number of pieces** on the board.
    -   Control the **visualization speed** with a configurable pause between steps.
-   **Clean Architecture:** The project leverages fundamental design patterns:
    -   **Strategy Pattern:** To easily switch between different sorting algorithms.
    -   **Factory Pattern:** To decouple the main logic from the concrete algorithm implementations.

## ⚙️ How to Use

### Prerequisites

Ensure you have a Java Development Kit (JDK) installed on your system.

### Compilation

The project is structured to be compiled directly from the command line using the standard Java compiler, `javac`.

**Command:**
```bash
javac -d out/production/Chess src/*.java
```

### Running the Visualizer

After successful compilation, run the program using the `java` command, which executes the Java Virtual Machine (JVM).

**Command:**
```bash
java -cp out/production/Chess Main [ARGUMENTS]
```

#### Command-Line Arguments

All arguments are required and use a `key=value` format:

-   `a=<algorithm>`: The sorting algorithm to use.
    -   `b`: Bubble Sort
    -   `i`: Insertion Sort
    -   `q`: Quick Sort
    -   `m`: Merge Sort
-   `t=<type>`: The comparison criteria for sorting. Each piece, defined in `WhitePieces.java` and `BlackPieces.java`, has both a hard-coded number and a letter. This flag determines which of those attributes is used for comparison.
    -   `n`: Sort by the number associated with each piece.
    -   `c`: Sort by the letter associated with each piece.
-   `c=<color>`: The color of the pieces to use.
    -   `w`: White pieces
    -   `b`: Black pieces
-   `r=<number>`: The number of pieces to place on the board.
    -   Allowed values: `8`, `10`, `16`.
-   `s=<milliseconds>`: The pause time between each step of the algorithm.
    -   Allowed values: `0` to `1000`.

#### Example

To run a visualization of **Bubble Sort** (`a=b`) on **16 black pieces** (`r=16`, `c=b`), sorting them by **number** (`t=n`) with a **100ms pause** (`s=100`) between steps, use the following command:

```bash
java -cp out/production/Chess Main a=b t=n c=b r=16 s=100
```

https://github.com/user-attachments/assets/ce1e2ed5-219c-4b07-b3ad-423f7c9ccd22

## 📂 Project Structure

The project is organized with a clear separation of concerns:

-   `Main.java`: The entry point of the application.
-   `CLIInputValidator.java`: Parses and validates all command-line arguments.
-   `ChessManager.java`: The core class that orchestrates the setup and execution of the sorting visualization.
-   `Board.java` & `Cell.java`: Represent the chessboard and its individual cells.
-   `Piece.java`, `WhitePieces.java`, `BlackPieces.java`: Define the interface and concrete implementations for the chess pieces, which act as the data elements.
-   `SortStrategy.java`: The interface for all sorting algorithm implementations (Strategy Pattern).
-   `BubbleSort.java`, `InsertionSort.java`, etc.: Concrete implementations of the sorting algorithms.
-   `SortStrategyFactory.java`: A factory class to create the appropriate sorting strategy instance based on user input.
-   `CellComparators.java`: Provides `Comparator` objects used to define the sorting logic (by number or by letter).

## 🤝 Contributions

Contributions are welcome! If you have ideas for improvements, new features, or bug fixes, feel free to open an issue or submit a pull request.
