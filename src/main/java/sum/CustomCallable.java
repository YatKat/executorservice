package sum;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.Callable;

public class CustomCallable implements Callable<BigDecimal> {
    private final List<Integer> numbers;

    public CustomCallable(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public BigDecimal call() throws Exception {
        return new BigDecimal(numbers.stream().mapToDouble(Integer::intValue).sum());
    }
}
