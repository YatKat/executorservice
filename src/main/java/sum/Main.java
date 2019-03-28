package sum;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        Callable<AtomicInteger> callable = new CustomCallable();
        Future<AtomicInteger> sum = service.submit(callable);
        try {
            System.out.println("--------------" + sum.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}
