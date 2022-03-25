
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
    public String getCurrency() { return currency; }
}

class Change {
    String account;
    String currency;
    int amount;

    public Change(String account, String currency, int amount) {
        this.account = account;
        this.currency = currency;
        this.amount = amount;
    }

    public String getAccount() { return account; }
    public int getAmount() { return amount; }
    public String getCurrency() { return currency; }
}

public class L5 {
    // Использовать java.util.stream.* существенным образом
    //
    // 1. Получить сумму всех транзакций в USD
    public static int task1(List<Transaction> txns) {
        return txns.stream()
            .filter(t -> t.getCurrency().equals("USD"))
            .mapToInt(t -> t.getAmount())
            .sum();
    }
    // 2. Вернуть всех получателей транзакций
    public static Set<String> task2(List<Transaction> txns) {
        return txns.stream()
            .map(Transaction::getTo)
            .collect(Collectors.toSet());
    }
    // 3. Считая, что вначале баланс у всех равен 0, подсчитать,
    // какой будет баланс после прохождения всех транзакций
    //                аккаунт     валюта   сумма
    //                   |          |        |
    //                   v          v        v
    public static Map<String, Map<String, Integer>> task3(List<Transaction> txns) {
        return txns.stream()
            .flatMap(t ->
                Stream.of(new Change(t.getFrom(), t.getCurrency(), -t.getAmount()),
                          new Change(t.getTo(), t.getCurrency(), t.getAmount())))
            .collect(Collectors.groupingBy(Change::getAccount,
                Collectors.groupingBy(Change::getCurrency,
                    Collectors.summingInt(Change::getAmount))));
    }
    public static void main(String[] args) {
        List<Transaction> txns = new LinkedList<>();
        txns.add(new Transaction("Alice","Bob",50,"USD"));
        txns.add(new Transaction("Bob","Charlie",50,"RUB"));
        txns.add(new Transaction("Charlie","Alice",20,"USD"));
        txns.add(new Transaction("Bob","Alice",20,"RUB"));
        System.out.println(task1(txns));
        System.out.println(task2(txns));
        System.out.println(task3(txns));
    }
}
