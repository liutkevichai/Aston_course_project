package fillstrategy.impl;

import fillstrategy.FillingList;
import fillstrategy.utils.ReadPropertyFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/***
 * Class response for create list and fill it serialization objects from file
 */
public class FillingListFromFile implements FillingList {

    /***
     * Count objects that contain in File
     */
    private static final int COUNT_OBJECT = new ReadPropertyFile().getAmountObjectInFile();
    /***
     * Path to file where we read serialization objects
     */
    private static final String FILE_NAME = new ReadPropertyFile().getFilePath();
    /***
     * Message for exception
     */
    private static final String EXCEED_AMOUNT_MES = "Chosen amount of elements exceeds " +
            "the amount of elements in the file. MAX = " + COUNT_OBJECT;

    /***
     * Method create and fill object list from file via deserialization.
     * This method fill created object list only certain type and amount.
     * @param typeClass potential class
     * @param count number element that will consist of object list
     * @return object list
     * @param <T> type typed class
     * @throws IllegalArgumentException exception if count object in file less
     * than user want to get
     */
    @Override
    public <T> List fillList(T typeClass, int count) throws IllegalArgumentException {

        List list = null;
        if (count <= 0) {
            return list;
        }
        if (count > COUNT_OBJECT) {
            throw new IllegalArgumentException(EXCEED_AMOUNT_MES);
        }
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            list = new ArrayList<T>();
            for (int i = 0; i < COUNT_OBJECT && count > 0; i++) {
                Object o = inputStream.readObject();
                if (typeClass.equals(o.getClass())) {
                    list.add(o);
                    count--;
                }
            }
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
