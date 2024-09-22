package model;

import java.util.ArrayList;
import java.util.Comparator;

public class MergeSort <T> {

    public ArrayList<T> sortArray(ArrayList<T> array) {
        if (array == null) {
            return null;
        }
        if (array.size() < 2) {
            return array;
        }

        ArrayList<T> arrayB = new ArrayList<>(array.size() / 2);
        System.arraycopy(array, 0, arrayB, 0, array.size() / 2);

        ArrayList<T> arrayC = new ArrayList<>(array.size() - arrayB.size());
        System.arraycopy(array, arrayB.size(), arrayC, 0, array.size() - arrayB.size());

        sortArray(arrayB);
        sortArray(arrayC);

        mergeArray(array, arrayB, arrayC);

        return array;
    }

    private static void mergeArray(ArrayList<T> array, ArrayList<T> arrayB, ArrayList<T> arrayC) {

        int positionB = 0;
        int positionC = 0;

        for (int c = 0; c < array.size(); c++) {
            if (positionB == arrayB.size()) {
                array(c) = arrayC(positionC);
                positionC++;
            } else if (positionC == arrayC.size()) {
                array(c) = arrayB(positionB);
                positionB++;
            } else if (arrayB(positionB) < arrayC(positionC)) {
                array(c) = arrayB(positionB);
                positionB++;
            } else {
                array(c) = arrayC(positionC);
                positionC++;
            }
        }
    }

}
