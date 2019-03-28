package sum;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SumIntegers {

    public static List<Integer> addIntegers(List<Integer> list) {
        for (int i = 1; i < 101; i++) {
            list.add(i);
        }
        return list;
    }

    public static AtomicInteger sumIntegersByPortions(List<Integer> list) {
        AtomicInteger sum = new AtomicInteger(0);
        int portion = list.size() / 10;
        for (int i = 0; i < list.size(); i += portion) {
            List<Integer> portionList = list.subList(i, Math.min(list.size(), i + portion));
            sum.addAndGet(portionList.stream().mapToInt(Integer::intValue).sum());
            System.out.println(sum);
        }
        return sum;
    }
}
