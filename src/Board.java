import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Board {

    private List<Cell> cells;

    public Board() {
        cells = new ArrayList<>();

        // Crear las 64 celdas vacías (sin pieza)
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                cells.add(new Cell(row, col, null));
            }
        }

        // Mezclar las celdas para distribuir las piezas aleatoriamente
        Collections.shuffle(cells);

        // Obtener las piezas negras (BlackPieces enum)
        BlackPieces[] pieces = BlackPieces.values();

        // Colocar las piezas en las primeras 16 celdas aleatorias
        for (int i = 0; i < pieces.length; i++) {
            cells.get(i).setPiece(pieces[i]);
        }

        // Ordenar la lista para que la impresión quede ordenada por fila y columna
        cells.sort((a, b) -> {
            if (a.row != b.row) return Integer.compare(a.row, b.row);
            return Integer.compare(a.col, b.col);
        });
    }

    public void printBoard() {
        System.out.println("   +----+----+----+----+----+----+----+----+");
        for (int i = 0; i < 8; i++) {
            System.out.print(" " + (i + 1) + " |");
            for (int j = 0; j < 8; j++) {
                Cell c = getCellAt(i, j);
                String content = c.getAbbreviation();
                if (content == null || content.trim().equals("-")) {
                    System.out.print("    |");
                } else {
                    System.out.printf(" %-2s |", content);
                }
            }
            System.out.println();
            System.out.println("   +----+----+----+----+----+----+----+----+");
        }
        System.out.println("     A    B    C    D    E    F    G    H\n");
    }

    private Cell getCellAt(int row, int col) {
        // Como la lista está ordenada por fila y columna, podemos calcular índice directo
        return cells.get(row * 8 + col);
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void applySort(SortStrategy<Cell> sorter, Comparator<Cell> comparator) {
        sorter.sort(cells, comparator);
    }
    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }


}
