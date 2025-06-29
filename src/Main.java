public class Main{

    public static void main(String[] args) {
        Board board = new Board();
        board.printBoard();

        System.out.println("Ordenando paso a paso...\n");

        SortStrategy<Cell> sorter = new BubbleSort<>(cells -> {
            board.setCells(cells);     // actualiza la lista de celdas
            board.printBoard();        // imprime el tablero en cada paso
        });

        sorter.sort(board.getCells(), CellComparators.BY_NUMBER);  // o BY_LETTER

    }
}