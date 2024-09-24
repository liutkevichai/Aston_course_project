package algorithms;

import model.HasNumField;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AltSorting {
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
