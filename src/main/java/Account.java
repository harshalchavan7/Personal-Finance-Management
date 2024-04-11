import java.util.ArrayList;
import java.util.List;

public class Account {
    private List<Transaction> transactions;
    private double initialBalance; // New field to store initial balance

    public Account() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public double calculateBalance() {
        double balance = initialBalance; // Initialize balance with initial balance
        for (Transaction transaction : transactions) {
            if (transaction.isIncome()) {
                balance += transaction.getAmount();
            } else {
                balance -= transaction.getAmount();
            }
        }
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
    }
}
