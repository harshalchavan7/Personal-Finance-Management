import java.util.Date;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Account account;

    public UserInterface(Account account) {
        this.scanner = new Scanner(System.in);
        this.account = account;
    }

    public void start() {
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        // Set initial balance for the account
        account.setInitialBalance(initialBalance);

        boolean running = true;
        while (running) {
            System.out.println("1. Add Transaction");
            System.out.println("2. View Previous Transactions");
            System.out.println("3. Calculate Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTransaction();
                    break;
                case 2:
                    viewPreviousTransactions();
                    break;
                case 3:
                    calculateBalance();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println(); // Add blank space after each action
        }
        scanner.close();
    }

    private void addTransaction() {
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        System.out.print("Is it an income or expense? (income/expense): ");
        String type = scanner.nextLine();
        boolean isIncome = type.equalsIgnoreCase("income");

        // Assume current date for simplicity
        Date date = new Date();

        Transaction transaction = new Transaction(amount, date, category, isIncome);
        account.addTransaction(transaction);
        System.out.println("Transaction added successfully.");
    }

    private void viewPreviousTransactions() {
        System.out.println("Previous Transactions:");
        for (Transaction transaction : account.getTransactions()) {
            System.out.println(transaction);
        }
    }

    private void calculateBalance() {
        double balance = account.calculateBalance();
        System.out.println("Current balance: " + balance);
    }
}
