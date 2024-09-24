package algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sorting<T> {

    public static <T> void merge(List<T> l1, List<T> l2, List<T> l, Comparator<T> c) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < l1.size() && j < l2.size()) {
            if (c.compare(l1.get(i), l2.get(j)) < 0) {
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

    public static <T> void mergeSort(List<T> l, Comparator<T> c) {
        int size = l.size();
        if (size < 2) {
            return;
        }
        int half = size / 2;
        List<T> l1 = new ArrayList<T>(l.subList(0, half));
        List<T> l2 = new ArrayList<T>(l.subList(half, size));

        mergeSort(l1, c);
        mergeSort(l2, c);

        merge(l1, l2, l, c);
    }
}