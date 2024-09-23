package strategy;

import java.util.List;

/***
 * Interface for create and fill object list in certain amount
 */
public interface FillingList {
    <T> List fillList(T typeClass, int count);
}
