import java.nio.file.*;

public class L3 {
    public static void task(Path sourceDir, Path targetDir) {
        System.out.println("Move by types from " + sourceDir + " to " + targetDir);
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
