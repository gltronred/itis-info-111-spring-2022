import java.nio.file.*;

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
    public static void task(Path sourceDir, Path targetDir) {
        System.out.println("Copy by types from " +
                           sourceDir + " to " +
                           targetDir);
    }
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java L3 <source> <target>");
            return;
        }

        Path sourceDir = Path.of(args[0]);
        Path targetDir = Path.of(args[1]);

        task(sourceDir, targetDir);
    }
}
