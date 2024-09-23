package strategy.impl;

import strategy.FillingList;

import utils.ConsoleInputBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FillingListFromConsole implements FillingList {
    @Override
    public <T> List fillList(T typeClass, int count) {
        List list = null;
        if (count > 0) {
            list = new ArrayList();
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < count; i++) {
                list.add(ConsoleInputBuilder.setupWithInput(typeClass.getClass(), scanner));
            }
        }
        return list;
    }
}
