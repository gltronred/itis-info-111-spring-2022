import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Cars {
    public static void task1(Path input) throws IOException {
        Files.lines(input)
            .map(s -> s.split("\t"))
            .map(Arrays::toString)
            .forEach(System.out::println);
    }
    public static void main(String[] args) throws IOException {
        task1(Path.of("data.txt"));
    }
}
