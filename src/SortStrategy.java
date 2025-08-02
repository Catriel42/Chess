import java.util.List;
import java.util.Comparator;

/**
 * Defines the contract for a sorting algorithm.
 * This interface is part of a Strategy design pattern, allowing for the dynamic selection
 * of a sorting algorithm at runtime.
 *
 * @param <T> The type of objects that this strategy can sort.
 */
public interface SortStrategy<T> {

    /**
     * Sorts a list of items according to a specified comparator.
     *
     * @param list The list of items to be sorted.
     * @param comparator The comparator to determine the order of the items.
     * @param pauseTime The time in milliseconds to pause after each significant step
     *                  of the algorithm, for visualization purposes.
     */
    void sort(List<T> list, Comparator<T> comparator, int pauseTime);
}
