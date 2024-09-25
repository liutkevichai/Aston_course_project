package strategy.utils;

import model.Book;
import model.Car;
import model.RootVegetable;
import strategy.FillingList;
import strategy.impl.FillingListRandomValue;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

/***
 * Class realise serialization random object from folder 'model' in file
 */
public class FillingFileRandomObject {
    /**
     * Path to source file
     */
    private static final String FILE_NAME = "src/main/resources/sourceObject.rat";
    /***
     * Amount objects that will serialize in file
     */
    private static final int COUNT_OBJECT = 1000;

    /***
     * Contain classes from folder 'model'
     */
    private static final Map mapObject = Map.of(
            0, Car.class,
            1, Book.class,
            2, RootVegetable.class
    );

    /***
     * Method serialize certain amount objects in file.
     * It chooses random object from map and uses
     * external method for fill object random data.
     */
    public void fillFile() {
        int random;
        FillingList fillingList = new FillingListRandomValue();
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME, false))) {
            for (int i = 0; i < COUNT_OBJECT; i++) {
                random = (int) (Math.random() * (mapObject.size()));
                outputStream.writeObject(fillingList.fillList(mapObject.get(random), 1).getFirst());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
