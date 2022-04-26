import java.io.*;
import java.nio.file.*;
import java.util.*;

class Datum {
    private String company;
    private String model;
    private int buildYear;
    private String color;
    private String city;
    private int buyYear;
    private int buyMonth;
    private int buyDay;
    private int sum;

    public String getCompany() { return company; }
    public String getModel() { return model; }
    public int getBuildYear() { return buildYear; }
    public String getColor() { return color; }
    public String getCity() { return city; }
    public int getBuyYear() { return buyYear; }
    public int getBuyMonth() { return buyMonth; }
    public int getBuyDay() { return buyDay; }
    public int getSum() { return sum; }

    public Datum parse(String[] array) {
        return null;
    }
    public String toString() {
        return company + " " +
            model + " " +
            buildYear + " " +
            color + " @ " +
            buyDay + "." +
            buyMonth + "." +
            buyYear;
    }
}

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
    public static void task3(Path input) throws IOException {
        Files.lines(input)
            .map(s -> s.split(" *\t *"))
            .map(Datum::parse)
            .forEach(System.out::println);
    }
    public static void main(String[] args) throws IOException {
        task1(Path.of("data.txt"));
        System.out.println(task2(Path.of("data.txt")));
    }
}
