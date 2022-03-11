import java.util.*;

class Bank {
    private Map<String,Integer> clients;

    public Bank() {
        clients = new HashMap<>();
    }

    public void deposit(String who, int amount) {
        int newAmount =
            clients.getOrDefault(who,0) + amount;
        clients.put(who,newAmount);
    }
    public void transfer(String from, String to, int amount) {
        withdraw(from, amount);
        deposit(to, amount);
    }
    public void withdraw(String who, int amount) {
        if (clients.getOrDefault(who,0) < amount)
            throw new RuntimeException("Not enough money");
        int newAmount =
            clients.getOrDefault(who,0) - amount;
        clients.put(who, newAmount);
    }

    public String toString() {
        return clients.toString();
    }
}

public class L1 {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.deposit("Alice", 1000);
        System.out.println(bank);
        bank.deposit("Alice", 2000);
        System.out.println(bank);
        bank.transfer("Alice", "Bob", 500);
        System.out.println(bank);
        bank.withdraw("Bob", 100);
        System.out.println(bank);
    }
}
