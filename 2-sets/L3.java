import java.util.*;

/*
Дерево поиска:

           5
      3         7
    1   4     6   8

 */

public class L3 {
    public static void main(String[] args) {
        NavigableSet<String> set = new TreeSet<>();

        set.add("hello");
        set.add("world");
        set.add("some");
        set.add("order");
        set.add("when");
        set.add("iterating");
        set.add("over");
        set.add("set");

        for (String s : set.subSet("iterating", "some")) {
            System.out.println(s);
        }
        System.out.println("---");
        System.out.println(set.higher("order"));
        System.out.println("---");
        System.out.println("abc".compareTo("abd"));
        System.out.println("abc".compareTo("abca"));
        System.out.println("abc".compareTo("abc"));
        System.out.println("---");
    }
}
