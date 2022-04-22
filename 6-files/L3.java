import java.io.*;
import java.nio.file.*;
import java.util.*;

/*
 * Рекурсивно пройтись по всем файлам в sourceDir,
 * скопировать их в подпапку targetDir, названную
 * по расширению файла.
 *
 * Если какие-то исходные файлы при этом
 * перезаписывают результат, вывести сообщение на
 * экран.
 *
 * Например, такая структура папок в source
 *
 *   source
 *   |
 *   +- dir1
 *   |
 *   +- dir2
 *   |  |
 *   |  +- f1.txt
 *   +- f2.bmp
 *   |
 *   +- L.java
 *   |
 *   +- f1.txt
 *
 * должна преобразоваться в следующую структуру в
 * target:
 *
 *   target
 *   |
 *   +- bmp
 *   |  |
 *   |  +- f2.bmp
 *   +- java
 *   |  |
 *   |  +- L.java
 *   +- txt
 *      |
 *      +- f1.txt
 *
 * При этом файл f1.txt будет перезаписан (он есть
 * два раза), поэтому во второй раз об этом должно
 * быть написано в консоль
 */
public class L3 {
    public static String getFileExt(Path path) {
        String[] components = path.getFileName()
            .toString()
            .split("\\.");
        return components[components.length-1];
    }
    public static Path makeTarget(Path targetDir, Path p) {
        return targetDir
            .resolve(getFileExt(p))
            .resolve(p.getFileName());
    }
    public static void task(Path sourceDir, Path targetDir) throws IOException {
        System.out.println("Copy by types from " +
                           sourceDir + " to " +
                           targetDir);
        Files.walk(sourceDir)
            .filter(Files::isRegularFile)
            .forEach(source -> {
                    Path target = makeTarget(targetDir, source);
                    try {
                        Files.createDirectories(target.getParent());
                        if (Files.exists(target)) {
                            System.out.println("File " + target + " is overwritten");
                        }
                        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                });
    }
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Usage: java L3 <source> <target>");
            return;
        }

        Path sourceDir = Path.of(args[0]);
        Path targetDir = Path.of(args[1]);

        task(sourceDir, targetDir);
    }
}
