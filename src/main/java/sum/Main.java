package sum;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //List<Integer> list = ListCreator.addIntegers(new ArrayList<>());
        //System.out.println(MyExecutorService.sumIntegersByPortions(list));

        System.out.println(MyForkJoin.startMyForkJoin());
    }
}
