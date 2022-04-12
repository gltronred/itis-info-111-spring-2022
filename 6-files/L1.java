import java.io.*;
import java.util.*;

public class L1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(
            new FileInputStream("input.txt"));
        PrintWriter pw = new PrintWriter(
            new FileOutputStream("output.txt"));

        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            pw.println(a*b);
        }
        pw.close();
    }
}
