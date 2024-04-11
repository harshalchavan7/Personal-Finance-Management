import java.util.List;

public class ReportGenerator {
    public void generateTransactionReport(List<Transaction> transactions) {
        System.out.println("Transaction Report:");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public void generateBudgetReport(List<Budget> budgets) {
        System.out.println("Budget Report:");
        for (Budget budget : budgets) {
            System.out.println("Category: " + budget.getCategory() + ", Limit: " + budget.getLimit());
        }
    }
}
