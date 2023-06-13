import java.util.ArrayList;

/**
 * An Ordered list implemented using Array lists.
 * We want comparable defined for T since we want
 * a way to sort the elements in the list.
 */
class OrderedList <T extends Comparable<T>> {
    public ArrayList<T> array;

    public OrderedList() {
        array = new ArrayList<T>();
    }

    public OrderedList(int initSize) {
        array = new ArrayList<T>(initSize);
    }

    public int indexOf(T data) {
        int low = 0;
        int high = array.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            T midValue = array.get(mid);
            int comparison = midValue.compareTo(data);

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

    public void add(T data) {
        int low = 0;
        int high = array.size();

        while (low < high) {
            int mid = (low + high) / 2;
            if (array.get(mid).compareTo(data) < 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        array.add(low, data);
    }

    public T remove(T item) {
        int index = indexOf(item);
        if (index != -1) {
            return array.remove(index);
        }
        return null;
    }

    public T remove(int index) {
        return array.remove(index);
    }

}
