
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class Calc {
    public static int addWrong(int x, int y) {
        return x-y;
    }
    public static int add(int x, int y) {
        return x+y;
    }
}

public class L1 {
    @Test
    void additionWrong() {
        assertEquals(1, Calc.addWrong(1,0));
        assertEquals(4, Calc.addWrong(2,2));
    }

    @Test
    void addition() {
        assertEquals(2, Calc.add(1,1));
        assertEquals(4, Calc.add(2,2));
    }
}
