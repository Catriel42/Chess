
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class QuickSort<T> implements SortStrategy<T> {

    private final Consumer<List<T>> onStep;

    public QuickSort(Consumer<List<T>> onStep) {
        this.onStep = onStep;
    }

    @Override
    public void sort(List<T> list, Comparator<T> comparator, int pauseTime) {
        quickSort(list, 0, list.size() - 1, comparator, pauseTime);
    }

    private void quickSort(List<T> list, int low, int high, Comparator<T> comparator, int pauseTime) {
        if (low < high) {
            int pi = partition(list, low, high, comparator, pauseTime);

            quickSort(list, low, pi - 1, comparator, pauseTime);
            quickSort(list, pi + 1, high, comparator, pauseTime);
        }
    }

    private int partition(List<T> list, int low, int high, Comparator<T> comparator, int pauseTime) {
        T pivot = list.get(high);
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (comparator.compare(list.get(j), pivot) < 0) {
                i++;
                Collections.swap(list, i, j);
                
                // Visualization step after each swap
                onStep.accept(list);
                try {
                    Thread.sleep(pauseTime);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        Collections.swap(list, i + 1, high);
        onStep.accept(list);
        try {
            Thread.sleep(pauseTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return i + 1;
    }
}
