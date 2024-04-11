import java.util.Date;

public class Transaction {
    private double amount;
    private Date date;
    private String category;
    private boolean isIncome; // New field to represent income or expense

    public Transaction(double amount, Date date, String category, boolean isIncome) {
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.isIncome = isIncome;
    }

    // Getters and setters
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isIncome() {
        return isIncome;
    }

    public void setIncome(boolean income) {
        isIncome = income;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", date=" + date +
                ", category='" + category + '\'' +
                ", isIncome=" + isIncome +
                '}';
    }
}
