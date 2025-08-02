/**
 * Represents a single cell on the chessboard.
 * A cell is defined by its row and column coordinates and may contain a chess piece.
 * It acts as a wrapper for a Piece, providing methods to access the piece's sorting attributes
 * even if the cell is empty, ensuring stable comparisons.
 */
public class Cell {
    public int row;
    public int col;
    private Piece piece;  // The piece occupying the cell, can be null.

    /**
     * Constructs a cell with specified coordinates and an optional piece.
     *
     * @param row The row of the cell (0-7).
     * @param col The column of the cell (0-7).
     * @param piece The piece to place in the cell, or null if the cell is empty.
     */
    public Cell(int row, int col, Piece piece) {
        this.row = row;
        this.col = col;
        this.piece = piece;
    }

    /**
     * Returns the piece currently in this cell.
     *
     * @return The Piece object, or null if the cell is empty.
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * Places a piece in this cell.
     *
     * @param piece The piece to set.
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    /**
     * Returns the visual representation (abbreviation) of the piece in the cell.
     *
     * @return The piece's abbreviation, or " - " if the cell is empty.
     */
    public String getAbbreviation() {
        return piece == null ? " - " : piece.getAbbreviation();
    }

    /**
     * Returns the sorting number of the piece in the cell.
     * If the cell is empty, it returns Integer.MAX_VALUE to ensure empty cells
     * are sorted to the end.
     *
     * @return The piece's number, or Integer.MAX_VALUE if empty.
     */
    public int getSortNumber() {
        return piece == null ? Integer.MAX_VALUE : piece.getNumber();
    }

    /**
     * Returns the sorting letter of the piece in the cell.
     * If the cell is empty, it returns a high-value character ((char)127) to ensure
     * empty cells are sorted to the end.
     *
     * @return The piece's letter, or a placeholder character if empty.
     */
    public char getSortLetter() {
        return piece == null ? (char)127 : piece.getLetter();
    }
}
