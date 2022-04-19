import java.nio.file.*;

/*
 * Рекурсивно пройтись по всем файлам в sourceDir,
 * скопировать их в подпапку targetDir, названную
 * по расширению файла.
 *
 * Если какие-то исходные файлы при этом
 * перезаписывают результат, вывести сообщение на
 * экран.
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
