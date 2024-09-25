package algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The {@code Sorting} class provides the implementation of the merge sort algorithm for sorting
 * collections of objects that implement the {@link Comparable} interface.
 */
public class Sorting {

    /**
     * Merges two sorted sublists into a single sorted list based on the provided comparator.
     *
     * @param l1 the first sorted sublist
     * @param l2 the second sorted sublist
     * @param l the list where the merged result will be stored
     * @param comparator the comparator used to define the sorting order
     * @param <T> the type of elements in the lists, which must extend {@link Comparable}.
     */
    private static <T extends Comparable<T>> void merge(List<T> l1, List<T> l2, List<T> l, Comparator<T> comparator) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < l1.size() && j < l2.size()) {
            if (comparator.compare(l1.get(i), l2.get(j)) < 0) {
                l.set(k++, l1.get(i++));
            } else {
                l.set(k++, l2.get(j++));
            }
        }

        while (i < l1.size()) {
            l.set(k++, l1.get(i++));
        }

        while (j < l2.size()) {
            l.set(k++, l2.get(j++));
        }
    }

    /**
     * Sorts the provided list using the merge sort algorithm.
     *
     * @param l the list to be sorted
     * @param comparator the comparator used to define the sorting order
     * @param <T> the type of elements in the list, which must extend {@link Comparable}
     */
    public static <T extends Comparable<T>> void mergeSort(List<T> l, Comparator<T> comparator) {
        int size = l.size();
        if (size < 2) {
            return;
        }

        int half = size / 2;
        List<T> l1 = new ArrayList<>(l.subList(0, half));
        List<T> l2 = new ArrayList<>(l.subList(half, size));

        mergeSort(l1, comparator);
        mergeSort(l2, comparator);

        merge(l1, l2, l, comparator);
    }
}

