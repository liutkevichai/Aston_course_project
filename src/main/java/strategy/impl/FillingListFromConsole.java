package strategy.impl;

import strategy.FillingList;

import strategy.utils.ConsoleInputBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/***
 * Class response for create and fill object list from console
 */
public class FillingListFromConsole implements FillingList {
    private static final Scanner scanner = new Scanner(System.in);

    /***
     * Method create and fill object list with type T certain size
     * This method implements external class for executes to fill
     * object list in real time
     * @param typeClass potential class
     * @param count number element that will consist of object list
     * @return object list with type T
     * @param <T> type typed class
     */
    @Override
    public <T> List fillList(T typeClass, int count) {
        List list = null;
        if (count > 0) {
            list = new ArrayList();
            for (int i = 0; i < count; i++) {
                list.add(ConsoleInputBuilder.setupWithInput((Class) typeClass));
            }
        }
        return list;
    }
}
