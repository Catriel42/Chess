
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class InsertionSort<T> implements SortStrategy<T> {

    private final Consumer<List<T>> onStep;

    public InsertionSort(Consumer<List<T>> onStep) {
        this.onStep = onStep;
    }

    @Override
    public void sort(List<T> list, Comparator<T> comparator, int pauseTime) {
        int n = list.size();
        for (int i = 1; i < n; ++i) {
            T key = list.get(i);
            int j = i - 1;

            // Move elements of list[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && comparator.compare(list.get(j), key) > 0) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }
            list.set(j + 1, key);

            // Visualization step after each insertion
            onStep.accept(list);
            try {
                Thread.sleep(pauseTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
