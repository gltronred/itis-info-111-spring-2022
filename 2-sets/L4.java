import java.util.*;

/*
Дерево поиска:

           5
      3         7
    1   4     6   8

 */

class MyStringComp implements Comparator<String> {
        public int compare(String s1, String s2) {
                if (s1.length() < s2.length())
                        return -1;
                if (s1.length() > s2.length())
                        return 1;
                return s1.compareTo(s2);
        }
}

public class L4 {
    public static void main(String[] args) {
        NavigableSet<String> set = new TreeSet<>(new MyStringComp());

        set.add("hello");
        set.add("helloo");
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
