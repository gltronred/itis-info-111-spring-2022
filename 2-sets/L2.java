import java.util.*;

public class L2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> olds = new HashSet<>();
        Integer x = 0;
        do {
            x = sc.nextInt();
            // был ли x введён ранее?
            boolean wasAdded = olds.add(x);
            if (!wasAdded) {
                System.out.println("Was earlier: " + x);
            }
        } while (x != 0);
    }
}
