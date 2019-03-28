package sum;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = SumIntegers.addIntegers(new ArrayList<>());
        System.out.println(SumIntegers.sumIntegersByPortions(list));
    }
}
