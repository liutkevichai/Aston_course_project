package strategy;

import java.util.List;

/***
 * Class realise pattern 'strategy'.
 * Class help execute method for all classes who implement interface 'FillingList'
 */
public class ContextFillingList {
    private FillingList fillingList;
    public <T> List execute(T typeClass, int cout) {
         return fillingList.fillList(typeClass, cout);
    }
    public void setFillingList(FillingList fillingList) {
        this.fillingList = fillingList;
    }
}
