import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

/**
 * Represents the chessboard, which contains a collection of 64 cells.
 * This class is responsible for initializing the board, populating it with a
 * specified number of pieces, and printing its state to the console.
 */
public class Board {

    private List<Cell> cells;

    /**
     * Constructs a new Board.
     * The board is initialized with 64 empty cells, then populated with a random
     * distribution of a specified number of pieces.
     *
     * @param colorOfPiece The color of the pieces to place on the board ("w" for white, "b" for black).
     * @param numberOfPieces The number of pieces to place on the board.
     */
    public Board(String colorOfPiece, int numberOfPieces) {
        cells = new ArrayList<>();

        // Create 64 empty cells
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                cells.add(new Cell(row, col, null));
            }
        }

        populateBoard(colorOfPiece, numberOfPieces);

        // Sort the list to ensure printing is ordered by row and column
        cells.sort((a, b) -> {
            if (a.row != b.row) return Integer.compare(a.row, b.row);
            return Integer.compare(a.col, b.col);
        });
    }

    /**
     * Populates the board with a specified number of pieces of a given color.
     * The pieces are placed in random cells.
     *
     * @param colorOfPiece The color of the pieces ("w" or "b").
     * @param numberOfPieces The number of pieces to place.
     */
    private void populateBoard(String colorOfPiece, int numberOfPieces) {
        // Shuffle the cells to randomize piece placement
        Collections.shuffle(cells);

        Piece[] pieces;
        if ("w".equalsIgnoreCase(colorOfPiece)) {
            pieces = Arrays.copyOfRange(WhitePieces.values(), 0, numberOfPieces);
        } else if ("b".equalsIgnoreCase(colorOfPiece)) {
            pieces = Arrays.copyOfRange(BlackPieces.values(), 0, numberOfPieces);
        } else {
            throw new IllegalArgumentException("Invalid piece color: " + colorOfPiece);
        }

        // Place the pieces in the first N random cells
        for (int i = 0; i < pieces.length; i++) {
            cells.get(i).setPiece(pieces[i]);
        }
    }

    /**
     * Prints the current state of the board to the console, including row and column labels.
     */
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

    /**
     * Retrieves the cell at a specific row and column.
     *
     * @param row The row of the cell.
     * @param col The column of the cell.
     * @return The Cell object at the given coordinates.
     */
    private Cell getCellAt(int row, int col) {
        // Since the list is sorted by row and column, we can calculate the direct index
        return cells.get(row * 8 + col);
    }

    /**
     * Returns the list of all cells on the board.
     *
     * @return A list of Cell objects.
     */
    public List<Cell> getCells() {
        return cells;
    }

    /**
     * Sets the list of cells for the board.
     * This is used by the sorting algorithms to update the board state after each step.
     *
     * @param cells The new list of cells.
     */
    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }


}
