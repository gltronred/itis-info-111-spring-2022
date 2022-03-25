
import java.util.*;
import java.util.stream.*;

class Transaction {
    String from;
    String to;
    int amount;
    String currency;

    public Transaction(String from, String to, int amount, String currency) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.currency = currency;
    }

    public String getFrom() { return from; }
    public String getTo() { return to; }
    public int getAmount() { return amount; }
    public int getCurrency() { return currency; }
}

public class L2 {
    // 1. Получить сумму всех транзакций в USD
    public static int task1(List<Transaction> txns) {
        return 0;
    }
    // 2. Получить всех получателей транзакций
    public static Set<String> task2(List<Transaction> txns) {
        return null;
    }
    // 3. Считая, что вначале баланс у всех равен 0, подсчитать,
    // какой будет баланс после прохождения всех транзакций
    public static Map<String, Map<String, Integer>> task3(List<Transaction> txns) {
        return null;
    }
    public static void main(String[] args) {
    }
}
