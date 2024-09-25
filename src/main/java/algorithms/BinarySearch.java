package algorithms;

import java.util.List;

/**
 * The {@code BinarySearch} class provides a generic implementation of the binary search algorithm
 * for collections of objects that implement the {@link Comparable} interface.
 */
public class BinarySearch {

    /**
     * Searches for the specified key in a sorted list using the binary search algorithm.
     *
     * @param list the sorted list of elements to search
     * @param key  the element to search for
     * @param <T>  the type of elements in the list, which must implement {@link Comparable}
     * @return the index of the key in the list if found, or -1 if the key is not in the list
     */
    public static <T extends Comparable<T>> int search(List<T> list, T key) {
        return binarySearch(list, key, 0, list.size() - 1);
    }

    /**
     * A helper method that performs the binary search recursively.
     *
     * @param list  the sorted list of elements to search
     * @param key   the element to search for
     * @param left  the left boundary of the current search space
     * @param right the right boundary of the current search space
     * @param <T>   the type of elements in the list, which must implement {@link Comparable}
     * @return the index of the key if found, or -1 if the key is not in the list
     */
    private static <T extends Comparable<T>> int binarySearch(List<T> list, T key, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = key.compareTo(list.get(mid));

            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                return binarySearch(list, key, left, mid - 1);
            } else {
                return binarySearch(list, key, mid + 1, right);
            }
        }
        return -1;
    }
}


