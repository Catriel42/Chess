public enum WhitePieces{
    KING      (4,  'a', "KW"),
    QUEEN     (5,  'b', "QW"),
    ROOK_1    (8,  'h', "RW"),
    ROOK_2    (1,  'a', "RW"),
    BISHOP_1  (2,  'e', "BW"),
    BISHOP_2  (7,  'f', "BW"),
    KNIGHT_1  (3,  'g', "HW"),
    KNIGHT_2  (6,  'h', "HW"),
    PAWN_1    (9,  'i', "PW"),
    PAWN_2    (10, 'j', "PW"),
    PAWN_3    (11, 'k', "PW"),
    PAWN_4    (12, 'l', "PW"),
    PAWN_5    (13, 'm', "PW"),
    PAWN_6    (14, 'n', "PW"),
    PAWN_7    (15, 'o', "PW"),
    PAWN_8    (16, 'p', "PW");

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
