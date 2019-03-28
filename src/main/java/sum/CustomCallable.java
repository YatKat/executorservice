package sum;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomCallable implements Callable<AtomicInteger> {
    private  List<Integer> list = SumIntegers.addIntegers(new CopyOnWriteArrayList<>());

    @Override
    public AtomicInteger call() throws Exception {
        return SumIntegers.sumIntegersByPortions(SumIntegers.addIntegers(list));
    }
}
