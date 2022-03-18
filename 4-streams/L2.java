import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class Div2 implements Function<Integer,Integer> {
    public Integer apply(Integer x) {
        return x / 2;
    }
}

class Add3 implements Function<Integer,Integer> {
    public Integer apply(Integer x) {
        return x + 3;
    }
}

class Out implements Consumer<Integer> {
    public void accept(Integer n) {
        for (int i=0; i<n; i++) {
            System.out.print("a");
        }
        System.out.println();
    }
}

public class L2 {
    static void task2(List<Integer> list) {
        list.stream()
            .filter(new Predicate<Integer>() {
                    public boolean test(Integer x) {
                        return x % 2 == 0;
                    }
                })
            .map(new Div2())
            .map(new Add3())
            .forEach(new Out());
    }
    public static void main(String[] args){
        List<Integer> l = new LinkedList<>();
        l.add(2);
        l.add(3);
        l.add(4);
        task2(l);
    }
}
