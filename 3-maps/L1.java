import java.util.*;

class Bank {
    private Map<String,Map<String,Integer>> clients;

    public Bank() {
        clients = new HashMap<>();
    }

    public void deposit(String who, int amount) {deposit(who, amount, "RUB");}
    public void deposit(String who, int amount, String unit) {
        Map<String,Integer> account =
            clients.getOrDefault(who,new HashMap<>());
        int newAmount =
            account.getOrDefault(unit,0) + amount;
        account.put(unit,newAmount);
        clients.put(who,account);
    }
    public void transfer(String from, String to, int amount) {transfer(from,to,amount,"RUB");}
    public void transfer(String from, String to, int amount, String unit) {
        withdraw(from, amount, unit);
        deposit(to, amount, unit);
    }
    public void withdraw(String who, int amount) {withdraw(who,amount,"RUB");}
    public void withdraw(String who, int amount, String unit) {
        Map<String,Integer> account =
            clients.getOrDefault(who, new HashMap<>());
        if (account.getOrDefault(unit,0) < amount)
            throw new RuntimeException("Not enough money");
        int newAmount =
            account.getOrDefault(unit,0) - amount;
        account.put(unit,newAmount);
        clients.put(who, account);
    }

    public String toString() {
        return clients.toString();
    }
}

public class L1 {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.deposit("Alice", 1000, "USD");
        System.out.println(bank);
        bank.deposit("Alice", 2000);
        System.out.println(bank);
        bank.transfer("Alice", "Bob", 500);
        System.out.println(bank);
        bank.withdraw("Bob", 100);
        System.out.println(bank);
    }
}
