import java.io.*;
import java.util.*;

// Подумайте:
// - что может пойти не так?
// - где программист, использующий этот
//   код, может ошибиться?
// - когда этот подход не работает, как
//   ожидается?
// и прочие способы вызвать недоумение
// у пользователя

// Класс для пары значений
class Pair {
    private Object first;
    private Object second;

    public Pair(Object first, Object second) {
        this.first = first;
        this.second = second;
    }

    public Object getFirst() { return first; }
    public Object getSecond() { return second; }

    public void setFirst(Object first) { this.first = first; }
    public void setSecond(Object second) { this.second = second; }
}

public class L1 {
    public static void main(String[] args) {
        // Входной массив
        Integer[] a = {1,2,3,4,5,4,3,2,1};

        // Поиск среднего и максимума
        Pair ans = new Pair(new Double(0.0), new Integer(-1001));
        for (Integer x : a) {
            if (x > (Integer)ans.getSecond()) {
                ans.setSecond(x);
            }
            ans.setFirst((Double)ans.getFirst() + x);
        }
        ans.setFirst((Double)ans.getFirst() / a.length);

        // Выводим ответы
        System.out.println(ans.getFirst());
        System.out.println(ans.getSecond());
    }
}
