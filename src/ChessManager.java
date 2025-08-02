/**
 * The main orchestrator of the sorting visualization process.
 * This class takes the validated command-line arguments, initializes the board,
 * selects the appropriate sorting strategy, and executes the sorting process,
 * printing the board state at each step.
 */
public class ChessManager {

    private final String sorterAlgorithm;
    private final String typeOfList;
    private final String colorOfPiece;
    private final int numberOfPieces;
    private final int pauseTime;

    private Board board;
    private SortStrategy<Cell> sortStrategy;

    /**
     * Constructs a ChessManager and initializes the entire sorting visualization process.
     *
     * @param validator The validated input arguments from the CLI.
     */
    public ChessManager(CLIInputValidator validator) {
        this.sorterAlgorithm = validator.getSorterAlgorithm();
        this.typeOfList = validator.getTypeOfList();
        this.colorOfPiece = validator.getColorOfPiece();
        this.numberOfPieces = validator.getNumberOfPieces();
        this.pauseTime = validator.getPauseTime();

        initializeChessGame();
    }

    /**
     * Sets up and runs the sorting visualization.
     * This involves creating the board, selecting the sorting strategy and comparator,
     * and then running the sort.
     */
    private void initializeChessGame() {
        // 1. Create the board with the specified pieces
        this.board = new Board(colorOfPiece, numberOfPieces);
        System.out.println("Initial board state:");
        board.printBoard();

        // 2. Create the sorting strategy using the factory
        try {
            // The onStep action updates the board and prints it
            java.util.function.Consumer<java.util.List<Cell>> onStepAction = list -> {
                board.setCells(list);
                board.printBoard();
            };
            this.sortStrategy = SortStrategyFactory.createSortStrategy(sorterAlgorithm, onStepAction);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return; // Stop if the algorithm is not supported
        }

        // 3. Select the comparator based on the type of list
        java.util.Comparator<Cell> comparator;
        if ("n".equalsIgnoreCase(typeOfList)) {
            System.out.println("\nSorting by piece number...");
            comparator = CellComparators.BY_NUMBER;
        } else { // "c" is the only other option thanks to the validator
            System.out.println("\nSorting by piece letter...");
            comparator = CellComparators.BY_LETTER;
        }

        // Adjust comparator based on piece color for ascending/descending order
        if ("w".equalsIgnoreCase(colorOfPiece)) {
            System.out.println("Sorting in descending order for white pieces...");
            comparator = comparator.reversed();
        } else { // "b" or any other case, default to ascending
            System.out.println("Sorting in ascending order for black pieces...");
        }

        // 4. Run the sorting algorithm
        System.out.println("Starting sort with " + sorterAlgorithm + " algorithm...");
        sortStrategy.sort(board.getCells(), comparator, pauseTime);
        System.out.println("\nSorting complete!");
        board.printBoard();
    }
}
