package fillstrategy.impl;

import fillstrategy.FillingList;
import fillstrategy.utils.ReadPropertyFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class FillingListFromFile implements FillingList {
    private static final int COUNT_OBJECT = new ReadPropertyFile().getAmountObjectInFile();
    private static final String FILE_NAME = new ReadPropertyFile().getFilePath();
    private static final String EXCEED_AMOUNT_MES = "Chosen amount of elements exceeds " +
            "the amount of elements in the file. MAX = " + COUNT_OBJECT;

    @Override
    public <T> List fillList(T typeClass, int count) throws IllegalArgumentException{

        List list = null;
        if (count <= 0){
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
