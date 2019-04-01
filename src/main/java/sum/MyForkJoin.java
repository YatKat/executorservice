package sum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MyForkJoin extends RecursiveTask<BigDecimal> {
    private final List<Integer> list;
    private final int start;
    private final int end;
    private static final int portion = 10_000;

    public MyForkJoin(List<Integer> list) {
        this(list, 0, list.size());
    }

    public MyForkJoin(List<Integer> list, int start, int end) {
        this.list = list;
        this.start = start;
        this.end = end;
    }

    @Override
    protected BigDecimal compute() {
        int lenght = end - start;
        if(lenght <= portion){
            return makeSum();
        }else{
            MyForkJoin task_1 = new MyForkJoin(list, start, start + lenght/2);
            task_1.fork();
            MyForkJoin task_2 = new MyForkJoin(list, start + lenght/2, end);
            BigDecimal resultOfTask_2 = task_2.compute();
            BigDecimal resultOfTask_1 = task_1.join();

            return resultOfTask_1.add(resultOfTask_2);
        }
    }

    private BigDecimal makeSum(){
        BigDecimal sum = new BigDecimal(0);
        for (int i = start; i < end; i++) {
            sum = sum.add(BigDecimal.valueOf(list.get(i)));
        }
        return sum;
    }

    public static BigDecimal startMyForkJoin(){
        List<Integer> listOfResults = ListCreator.addIntegers(new ArrayList<>());
        MyForkJoin task = new MyForkJoin(listOfResults);
        return new ForkJoinPool().invoke(task);
    }
}
