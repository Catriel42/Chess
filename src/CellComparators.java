import java.util.Comparator;

/**
 * A utility class that provides static {@link Comparator} instances for sorting {@link Cell} objects.
 * These comparators define the logic for ordering cells based on the attributes of the pieces they contain.
 */
public class CellComparators {

    /**
     * A comparator that sorts cells based on the piece's number in ascending order.
     * Cells without a piece are treated as having a value of {@link Integer#MAX_VALUE},
     * effectively placing them at the end of the sorted list.
     */
    public static final Comparator<Cell> BY_NUMBER = (a, b) -> {
        return Integer.compare(a.getSortNumber(), b.getSortNumber());
    };

    /**
     * A comparator that sorts cells based on the piece's letter in alphabetical order.
     * Cells without a piece are treated as having a high character value ((char)127),
     * placing them at the end of the sorted list.
     */
    public static final Comparator<Cell> BY_LETTER = (a, b) -> {
        return Character.compare(a.getSortLetter(), b.getSortLetter());
    };
}
