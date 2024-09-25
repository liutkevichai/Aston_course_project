package fillstrategy.impl;

import models.Book;
import models.Car;
import models.RootVegetable;
import fillstrategy.utils.FillingObjectList;
import fillstrategy.FillingList;

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
        List list = null;
        FillingObjectList fillingObjectList = new FillingObjectList();

        if (typeClass.equals(Car.class)) {
            list = fillingObjectList.fillCarList(count);
        } else if (typeClass.equals(Book.class)) {
            list = fillingObjectList.fillBookList(count);
        }
        else if (typeClass.equals(RootVegetable.class)) {
            list = fillingObjectList.fillRootVegetableList(count);
        }

        return list;
    }
}
