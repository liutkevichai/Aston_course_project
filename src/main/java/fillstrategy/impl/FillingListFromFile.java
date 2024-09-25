package fillstrategy.impl;

import model.Book;
import model.Car;
import model.RootVegetable;
import strategy.FillingList;
import strategy.utils.DeserializationObjectsFromFile;

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
        if (count > COUNT_OBJECT){
            return list;
        }
        if (typeClass.equals(Car.class)) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
                list = new ArrayList<>();
                while(count > 0){
                    Object o = inputStream.readObject();
                    if (o instanceof Car) {
                        list.add(o);
                        count--;
                    }
                }
                System.out.println(list);
            } catch (ClassNotFoundException | IOException e) {
                throw new RuntimeException(e);
            }
        } else if (typeClass.equals(Book.class)) {

        } else if (typeClass.equals(RootVegetable.class)) {

        }
        return list;
    }


}
