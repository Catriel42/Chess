public enum WhitePieces implements Piece {
    KING      (4,  'a', "\u2654"), // ♔
    QUEEN     (5,  'b', "\u2655"), // ♕
    ROOK_1    (8,  'h', "\u2656"), // ♖
    ROOK_2    (1,  'a', "\u2656"), // ♖
    BISHOP_1  (2,  'e', "\u2657"), // ♗
    BISHOP_2  (7,  'f', "\u2657"), // ♗
    KNIGHT_1  (3,  'g', "\u2658"), // ♘
    KNIGHT_2  (6,  'h', "\u2658"), // ♘
    PAWN_1    (9,  'i', "\u2659"), // ♙
    PAWN_2    (10, 'j', "\u2659"), // ♙
    PAWN_3    (11, 'k', "\u2659"), // ♙
    PAWN_4    (12, 'l', "\u2659"), // ♙
    PAWN_5    (13, 'm', "\u2659"), // ♙
    PAWN_6    (14, 'n', "\u2659"), // ♙
    PAWN_7    (15, 'o', "\u2659"), // ♙
    PAWN_8    (16, 'p', "\u2659"); // ♙

    private final int number;
    private final char letter;
    private final String abbreviation;

    WhitePieces(int number, char letter, String abbreviation) {
        this.number = number;
        this.letter = letter;
        this.abbreviation = abbreviation;
    }

    public int getNumber() {
        return number;
    }

    public char getLetter() {
        return letter;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

}
