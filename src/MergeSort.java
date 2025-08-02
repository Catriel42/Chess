import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Implements the Merge Sort algorithm.
 * This strategy uses a divide-and-conquer approach, dividing the list into two halves,
 * recursively sorting them, and then merging the sorted halves.
 *
 * @param <T> The type of elements to be sorted.
 */
public class MergeSort<T> implements SortStrategy<T> {

    private final Consumer<List<T>> onStep;

    /**
     * Constructs a MergeSort strategy.
     *
     * @param onStep A consumer function that is called after each merge operation, allowing for visualization.
     */
    public MergeSort(Consumer<List<T>> onStep) {
        this.onStep = onStep;
    }

    @Override
    public void sort(List<T> list, Comparator<T> comparator, int pauseTime) {
        mergeSort(list, new ArrayList<>(list), 0, list.size() - 1, comparator, pauseTime);
    }

    private void mergeSort(List<T> list, List<T> temp, int left, int right, Comparator<T> comparator, int pauseTime) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(list, temp, left, mid, comparator, pauseTime);
            mergeSort(list, temp, mid + 1, right, comparator, pauseTime);
            merge(list, temp, left, mid, right, comparator, pauseTime);
        }
    }

    private void merge(List<T> list, List<T> temp, int left, int mid, int right, Comparator<T> comparator, int pauseTime) {
        for (int i = left; i <= right; i++) {
            temp.set(i, list.get(i));
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (comparator.compare(temp.get(i), temp.get(j)) <= 0) {
                list.set(k, temp.get(i));
                i++;
            } else {
                list.set(k, temp.get(j));
                j++;
            }
            k++;

            onStep.accept(list);
            try {
                Thread.sleep(pauseTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        while (i <= mid) {
            list.set(k, temp.get(i));
            k++;
            i++;

            onStep.accept(list);
            try {
                Thread.sleep(pauseTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
