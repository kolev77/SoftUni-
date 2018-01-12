package LAB;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;

public class ReduceFunc {
    public static void main(String[] args) {
        List<String> somelist = new ArrayList<String>();
        List<Integer> otherlist = new ArrayList<>();
        somelist.add("10");
        somelist.add("5");
        somelist.add("4");
        somelist.add("6");
        otherlist.add(5);
        otherlist.add(10);
        otherlist.add(52);
        System.out.println(somelist.stream().mapToInt(x-> Integer.valueOf(x)).filter(x-> x > 5).reduce((x,y) -> x+ y));
        System.out.println(otherlist.stream().reduce((x,y)->x+y).get());
    }
}
