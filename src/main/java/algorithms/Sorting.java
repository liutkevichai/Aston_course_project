package algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sorting<T> {

    public static <T> void merge(List<T> L1, List<T> L2, List<T> L, Comparator<T> C) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < L1.size() && j < L2.size()) {
            if (C.compare(L1.get(i), L2.get(j)) < 0) {
                L.set(k++, L1.get(i++));
            } else {
                L.set(k++, L2.get(j++));
            }
        }
        while (i < L1.size()) {
            L.set(k++, L1.get(i++));
        }
        while (j < L2.size()) {
            L.set(k++, L2.get(j++));
        }
    }

    public static <T> void mergeSort(List<T> L, Comparator<T> C) {
        int size = L.size();
        if (size < 2) {
            return;
        }
        int half = size / 2;
        List<T> L1 = new ArrayList<T>(L.subList(0, half));
        List<T> L2 = new ArrayList<T>(L.subList(half, size));

        mergeSort(L1, C);
        mergeSort(L2, C);

        merge(L1, L2, L, C);
    }
}