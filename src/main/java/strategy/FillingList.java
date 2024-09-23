package strategy;

import java.util.List;

public interface FillingList {
    <T> List fillList(T typeClass, int count);
}
