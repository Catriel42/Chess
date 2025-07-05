import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class BubbleSort<T> implements SortStrategy<T> {

    private final Consumer<List<T>> onStep;

    public BubbleSort(Consumer<List<T>> onStep) {
        this.onStep = onStep; // función que se ejecuta tras cada paso (swap)
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

                    // Mostrar el estado actual del tablero
                    onStep.accept(list);

                    // Pequeña pausa visual (opcional)
                    try {
                        Thread.sleep(pauseTime); // 200ms de espera
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }

            if (!swapped) break; // ya está ordenado
        }
    }
}
