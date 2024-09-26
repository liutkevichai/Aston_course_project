package fillstrategy.impl;

import fillstrategy.FillingList;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class FillingListFromFile implements FillingList {
    private static final int COUNT_OBJECT = 1000;
    private static final String FILE_NAME = "src/main/resources/sourceObject.rat";

    @Override
    public <T> List fillList(T typeClass, int count) {

        List list = null;
        if (count > COUNT_OBJECT || count <= 0){
            return list;
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
            for (int i = 0; i < count; i++) {
                //TODO: add empty Object i list
//                list.add(typeClass
            }
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
