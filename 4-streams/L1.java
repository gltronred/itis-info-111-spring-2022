import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class Mod2 implements Predicate<Integer> {
    public boolean test(Integer x) {
        return x % 2 == 0;
    }
}

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

public class L1 {
    static void task2(List<Integer> list) {
        list.stream()
            .filter(new Mod2())
            .map(new Div2())
            .map(new Add3())
            .forEach(new Out());
    }
    static void task1a(List<Integer> l) {
        ListIterator<Integer> it = l.listIterator();
        while (it.hasNext()) {
            Integer el = it.next();
            if (el % 2 == 0) {
                Integer n = el / 2 + 3;
                for (int i=0; i<n; i++) {
                    System.out.print("a");
                }
                System.out.println();
            }
        }
    }
    static void task1(List<Integer> l) {
        ListIterator<Integer> it;
        it = l.listIterator();
        while(it.hasNext()) {
            if (it.next() % 2 != 0) {
                it.remove();
            }
        }

        it = l.listIterator();
        while(it.hasNext()) {
            Integer el = it.next();
            it.set(el / 2);
        }

        it = l.listIterator();
        while(it.hasNext()) {
            Integer el = it.next();
            it.set(el + 3);
        }

        it = l.listIterator();
        while(it.hasNext()) {
            Integer el = it.next();
            for (int i=0; i<el; i++) {
                System.out.print("a");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        List<Integer> l = new LinkedList<>();
        l.add(2);
        l.add(3);
        l.add(4);
        task2(l);
        task1a(l);
        task1(l);
    }
}
