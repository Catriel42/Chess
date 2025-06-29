public enum BlackPieces {
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

    BlackPieces(int number, char letter, String abbreviation) {
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
