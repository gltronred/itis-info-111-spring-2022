import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class L4 {
    static void task2(List<Integer> list) {
        list.stream()
            .filter(x -> x % 2 == 0)
            .map(x -> {return x / 2;})
            .map(x -> {return x + 3;})
            .forEach(n -> {
                    for (int i=0; i<n; i++) {
                        System.out.print("a");
                    }
                    System.out.println();
                });
    }
    public static void main(String[] args){
        List<Integer> l = new LinkedList<>();
        l.add(2);
        l.add(3);
        l.add(4);
        task2(l);
    }
}
