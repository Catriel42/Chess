public class Cell {
    public int row;
    public int col;
    private Piece piece;  // Guarda la pieza completa

    public Cell(int row, int col, Piece piece) {
        this.row = row;
        this.col = col;
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
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
