
import java.util.List;
import java.util.function.Consumer;

/**
 * A factory class for creating instances of SortStrategy.
 * This class decouples the client (ChessManager) from the concrete implementation
 * of the sorting algorithms.
 */
public class SortStrategyFactory {

    /**
     * Creates and returns a sorting strategy based on the provided algorithm identifier.
     *
     * @param algorithm The short identifier for the algorithm (e.g., "b" for BubbleSort).
     * @param onStep    The action to perform after each significant step of the algorithm.
     * @return An instance of a class that implements SortStrategy.
     * @throws IllegalArgumentException if the algorithm identifier is unknown or unsupported.
     */
    public static SortStrategy<Cell> createSortStrategy(String algorithm, Consumer<List<Cell>> onStep) {
        if (algorithm == null) {
            throw new IllegalArgumentException("Algorithm identifier cannot be null.");
        }

        switch (algorithm.toLowerCase()) {
            case "b":
                return new BubbleSort<>(onStep);
            case "i":
                return new InsertionSort<>(onStep);
            case "q":
                return new QuickSort<>(onStep);
            
            case "m":
                return new MergeSort<>(onStep);
            // --- Future algorithms will be added here ---
            // case "s":
            //     return new SelectionSort<>(onStep);
            
            default:
                throw new IllegalArgumentException("Unknown or unsupported sort algorithm: '" + algorithm + "'");
        }
    }
}
