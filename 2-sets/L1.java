import java.util.*;

public class L1 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("hello");
        set.add("world");
        set.add("some");
        set.add("order");
        set.add("when");
        set.add("iterating");
        set.add("over");
        set.add("set");

        for (String s : set) {
            System.out.println(s);
        }
    }
}
