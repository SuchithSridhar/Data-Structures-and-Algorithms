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

    /**
     * Merge another ordered list with the current instance.
     */
    public void merge(OrderedList<T> otherList) {
        int i = 0, j = 0;

        // Create a new list to hold the merged result
        ArrayList<T> mergedArray = new ArrayList<T>(this.array.size() + otherList.array.size());

        // Use two-finger walk algorithm to merge
        while (i < this.array.size() && j < otherList.array.size()) {
            if (this.array.get(i).compareTo(otherList.array.get(j)) <= 0) {
                mergedArray.add(this.array.get(i++));
            } else {
                mergedArray.add(otherList.array.get(j++));
            }
        }

        // If there are remaining elements in this array, add them to mergedArray
        while (i < this.array.size()) {
            mergedArray.add(this.array.get(i++));
        }

        // If there are remaining elements in otherList, add them to mergedArray
        while (j < otherList.array.size()) {
            mergedArray.add(otherList.array.get(j++));
        }

        // Replace the old array with the merged array
        this.array = mergedArray;
    }

}
