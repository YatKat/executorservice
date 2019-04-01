package sum;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyExecutorService {

    public static BigDecimal sumIntegersByPortions(List<Integer> list) {
        BigDecimal sum = new BigDecimal(0);
        ExecutorService service = Executors.newFixedThreadPool(10);
        int portion = list.size() / 10;
        for (int i = 0; i < list.size(); i += portion) {
            List<Integer> portionList = list.subList(i, Math.min(list.size(), i + portion));
            Future<BigDecimal> future = service.submit(new CustomCallable(portionList));
            try {
                sum = sum.add(future.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        service.shutdown();
        return sum;
    }
}
