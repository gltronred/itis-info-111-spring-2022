import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Cars {
    public static void task1(Path input) throws IOException {
        Files.lines(input)
            //ср.: (" |\t"))
            //ср.: ("( |\t)+"))
            .map(s -> s.split(" *\t *"))
            .map(Arrays::toString)
            .forEach(System.out::println);
    }
    public static int task2(Path input) throws IOException {
        return (int)Files.lines(input)
            .map(s -> s.split("\t"))
            .filter(arr -> arr[3].equals("Черный"))
            .count();
    }
    public static void main(String[] args) throws IOException {
        task1(Path.of("data.txt"));
        System.out.println(task2(Path.of("data.txt")));
    }
}
