
import java.io.*;
import java.util.*;

public class BmpReader {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("/tmp/some.bmp");

        byte[] header = new byte[14];

        int r0 = in.read(header);
        System.out.println("R0:" + r0);

        if (header[0] != 0x42 || header[1] != 0x4d ) {
            System.out.println("Not a BMP!");
            return;
        } else {
            System.out.println("BMP");
        }

    }
}
