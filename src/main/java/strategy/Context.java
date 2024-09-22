package strategy;

import java.util.List;

public class Context {
    private FillingList fillingList;

    public void execute(List list) {
        fillingList.fillList(list);
    }

    public void setFillingList(FillingList fillingList) {
        this.fillingList = fillingList;
    }
}
