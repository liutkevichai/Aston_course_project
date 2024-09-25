package algorithms;

import models.HasNumField;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The {@code AltSorting} class provides an alternative sorting algorithm for collections of objects
 * that implement the {@link Comparable} interface and the {@link HasNumField} interface.
 * This algorithm only sorts the objects with even-numbered fields.
 */
public class AltSorting {

    /**
     * Sorts the elements in the provided list that have an even value in their numeric field.
     *
     * @param list the list of elements to be sorted
     * @param <T>  the type of elements in the list, which must implement {@link Comparable} and {@link HasNumField}.
     */
    public static <T extends Comparable<T> & HasNumField<T>> void sort(List<T> list) {
        List<T> evenObjs = new ArrayList<>();
        List<Integer> evenIndices = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNumField() % 2 == 0) {
                evenObjs.add(list.get(i));
                evenIndices.add(i);
            }
        }

        Sorting.mergeSort(evenObjs, Comparator.comparing(T::getNumField));

        for (int i = 0; i < evenIndices.size(); i++) {
            list.set(evenIndices.get(i), evenObjs.get(i));
        }
    }
}

