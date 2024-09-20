package algorithms;

public class BinarySearch<T extends Comparable<T>> {
    public int search(T[] arr, T key) {
        return binarySearch(arr, key, 0, arr.length - 1);
    }

    private int binarySearch(T[] arr, T key, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = key.compareTo(arr[mid]);
            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                return binarySearch(arr, key, left, mid - 1);
            } else {
                return binarySearch(arr, key, mid + 1, right);
            }
        }
        return -1;
    }
}
