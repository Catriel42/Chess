/**
 * This enum represents the set of black chess pieces, implementing the Piece interface.
 * Each piece is defined as a constant with its specific attributes: a number and a letter for sorting,
 * and a Unicode character for its abbreviation on the board.
 */
public enum BlackPieces implements Piece {
    KING      (5,  'e', "\u265A"), // ♚
    QUEEN     (4,  'd', "\u265B"), // ♛
    ROOK_1    (8,  'h', "\u265C"), // ♜
    ROOK_2    (1,  'a', "\u265C"), // ♜
    BISHOP_1  (3,  'c', "\u265D"), // ♝
    BISHOP_2  (6,  'f', "\u265D"), // ♝
    KNIGHT_1  (2,  'b', "\u265E"), // ♞
    KNIGHT_2  (7,  'g', "\u265E"), // ♞
    PAWN_1    (9,  'i', "\u265F"), // ♟
    PAWN_2    (10, 'j', "\u265F"), // ♟
    PAWN_3    (11, 'k', "\u265F"), // ♟
    PAWN_4    (12, 'l', "\u265F"), // ♟
    PAWN_5    (13, 'm', "\u265F"), // ♟
    PAWN_6    (14, 'n', "\u265F"), // ♟
    PAWN_7    (15, 'o', "\u265F"), // ♟
    PAWN_8    (16, 'p', "\u265F"); // ♟

    private final int number;
    private final char letter;
    private final String abbreviation;

    /**
     * Constructs a BlackPiece with its sorting attributes and abbreviation.
     *
     * @param number The number used for numerical sorting.
     * @param letter The letter used for alphabetical sorting.
     * @param abbreviation The Unicode character representing the piece.
     */
    BlackPieces(int number, char letter, String abbreviation) {
        this.number = number;
        this.letter = letter;
        this.abbreviation = abbreviation;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public char getLetter() {
        return letter;
    }

    @Override
    public String getAbbreviation() {
        return abbreviation;
    }
}
