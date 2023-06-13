import java.util.List;

/** 
 * A class to perform Binary search on a list.
 * Assumes that the List provided is ordered.
 * Unknown behaviour on List being unordered.
 */
public class BinarySearch {
    /**
     * Find the index of an element in an ordered list.
     * Returns -1 if the element is not found.
     */
    public static <T extends Comparable<T>> int indexOf (List<T> list, T data) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = list.get(mid).compareTo(data);

            if (comparison < 0) {
                low = mid + 1;
            } else if (comparison > 0) {
                high = mid - 1;
            } else {
                return mid; // item found
            }
        }

        return -1; // item not found
    }
}
