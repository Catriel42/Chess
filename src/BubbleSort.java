import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Implements the Bubble Sort algorithm.
 * This strategy sorts a list by repeatedly stepping through it, comparing adjacent elements
 * and swapping them if they are in the wrong order.
 *
 * @param <T> The type of elements to be sorted.
 */
public class BubbleSort<T> implements SortStrategy<T> {

    private final Consumer<List<T>> onStep;

    /**
     * Constructs a BubbleSort strategy.
     *
     * @param onStep A consumer function that is called after each swap, allowing for visualization.
     */
    public BubbleSort(Consumer<List<T>> onStep) {
        this.onStep = onStep; // Function to execute after each step (swap)
    }

    @Override
    public void sort(List<T> list, Comparator<T> comparator, int pauseTime) {
        int n = list.size();
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(list.get(j), list.get(j + 1)) > 0) {
                    Collections.swap(list, j, j + 1);
                    swapped = true;

                    // Show the current state of the board
                    onStep.accept(list);

                    // Optional visual pause
                    try {
                        Thread.sleep(pauseTime);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }

            if (!swapped) break; // Already sorted
        }
    }
}
