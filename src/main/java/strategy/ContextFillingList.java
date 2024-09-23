package strategy;

import java.util.List;

public class ContextFillingList {
    private FillingList fillingList;
    public <T> List execute(T typeClass, int cout) {
         return fillingList.fillList(typeClass, cout);
    }
    public void setFillingList(FillingList fillingList) {
        this.fillingList = fillingList;
    }
}
