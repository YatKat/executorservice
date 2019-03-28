package sum;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SumIntegers {

    public static List<Integer> addIntegers(List<Integer> list) {
        for (int i = 1; i <= 1_000_000; i++) {
            list.add(i);
        }
        return list;
    }

    public static BigDecimal sumIntegersByPortions(List<Integer> list) {
        BigDecimal sum = new BigDecimal(0);
        ExecutorService service = Executors.newFixedThreadPool(10);
        int portion = list.size() / 10;
        for (int i = 0; i < list.size(); i += portion) {
            List<Integer> portionList = list.subList(i, Math.min(list.size(), i + portion));
            Future<Integer> future = service.submit(() -> portionList.stream().mapToInt(Integer::intValue).sum());
            try {
                BigDecimal portionSum = new BigDecimal(future.get());
                sum = sum.add(portionSum);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        service.shutdown();
        return sum;
    }
}
