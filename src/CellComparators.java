import java.util.Comparator;

public class CellComparators {

    // Compara dos celdas por su número asociado a la pieza (menor primero)
    public static final Comparator<Cell> BY_NUMBER = (a, b) -> {
        return Integer.compare(a.getSortNumber(), b.getSortNumber());
    };

    // Compara dos celdas por su letra asociada (ej: 'a', 'b', ..., 'p')
    public static final Comparator<Cell> BY_LETTER = (a, b) -> {
        return Character.compare(a.getSortLetter(), b.getSortLetter());
    };
}
