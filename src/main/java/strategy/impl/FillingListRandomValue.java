package strategy.impl;

import model.Book;
import model.Car;
import model.RootVegetable;
import strategy.utils.FillingObjectList;
import strategy.FillingList;

import java.util.List;
/***
 * Class creates and fill object list via random and prepared data
 */
public class FillingListRandomValue implements FillingList {
    /***
     * Method create and fill object list certain size
     * This method choose what type object will implement fill
     * object list in external class
     * @param typeClass potential class
     * @param count number element that will consist of object list
     * @return object list
     * @param <T> type typed class
     */
    @Override
    public <T> List fillList(T typeClass, int count) {
        FillingObjectList fillingObjectList = new FillingObjectList();

        return switch (typeClass) {
            case Car car -> fillingObjectList.fillCarList(count);
            case Book book -> fillingObjectList.fillBookList(count);
            case RootVegetable rootVegetable -> fillingObjectList.fillRootVegetableList(count);
            case null, default -> null;
        };
    }
}
