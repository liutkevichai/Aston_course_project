package algorithms;

import java.util.List;

public class BinarySearch {
    public static <T extends Comparable<T>> int search(List<T> list, T key) {
        return binarySearch(list, key, 0, list.size() - 1);
    }

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

