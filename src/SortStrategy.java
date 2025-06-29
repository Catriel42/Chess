import java.util.List;
import java.util.Comparator;

public interface SortStrategy<T> {
    void sort(List<T> list, Comparator<T> comparator);
}
