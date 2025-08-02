/**
 * The Piece interface represents a chess piece with specific attributes.
 * It defines the essential properties that every piece on the board must have,
 * such as a number for sorting, a letter for identification, and an abbreviation
 * for display on the board.
 */
public interface Piece {

    /**
     * Returns the number associated with the piece.
     * This number is used for sorting purposes, allowing pieces to be ordered
     * based on a predefined numerical value.
     *
     * @return The sorting number of the piece.
     */
    int getNumber();

    /**
     * Returns the letter associated with the piece.
     * This letter provides a character-based identifier for the piece, which can be
     * used for alternative sorting or identification methods.
     *
     * @return The identification letter of the piece.
     */
    char getLetter();

    /**
     * Returns the abbreviation of the piece.
     * This abbreviation is a short string, often a Unicode character, that visually
     * represents the piece on the chessboard when printed to the console.
     *
     * @return The string abbreviation of the piece.
     */
    String getAbbreviation();
}
