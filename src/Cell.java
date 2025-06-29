public class Cell {
    public int row;
    public int col;
    private BlackPieces piece;  // Guarda la pieza completa

    public Cell(int row, int col, BlackPieces piece) {
        this.row = row;
        this.col = col;
        this.piece = piece;
    }

    public BlackPieces getPiece() {
        return piece;
    }

    public void setPiece(BlackPieces piece) {
        this.piece = piece;
    }

    public String getAbbreviation() {
        return piece == null ? " - " : piece.getAbbreviation();
    }

    public int getSortNumber() {
        return piece == null ? Integer.MAX_VALUE : piece.getNumber();
    }

    public char getSortLetter() {
        return piece == null ? (char)127 : piece.getLetter();
    }
}
