package sum;

import java.util.List;

public class ListCreator {

    public static List<Integer> addIntegers(List<Integer> list) {
        for (int i = 1; i <= 1_000_000; i++) {
            list.add(i);
        }
        return list;
    }
}
