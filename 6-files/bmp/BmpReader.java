
import java.io.*;
import java.util.*;

public class BmpReader {
    public static int toInt(byte[] a) {
        int b = 0;
        for (int i=3; i>=0; i--) {
            b *= 256;
            b += a[i];
            if (a[i] < 0)
                b += 256;
        }
        return b;
    }
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
            System.out.println(Arrays.toString(header));

            int filesize = toInt(Arrays.copyOfRange(header,2,6));
            System.out.println("File size: " + filesize);

            byte[] bitmapInfoSizeBuf = new byte[4];
            int r1 = in.read(bitmapInfoSizeBuf);
            System.out.println("R1:" + r1);
            int bitmapInfoSize = toInt(bitmapInfoSizeBuf);
            System.out.println("Ver: " + bitmapInfoSize);

            byte[] bitmapInfo = new byte[bitmapInfoSize-4];
            int r2 = in.read(bitmapInfo);
            if (bitmapInfoSize==12) {
                // CORE: width and height are 2 bytes
            } else {
                int w = toInt(Arrays.copyOfRange(bitmapInfo,0,4));
                int h = toInt(Arrays.copyOfRange(bitmapInfo,4,8));
                System.out.println(w + "x" + h);
            }
        }

    }
}
