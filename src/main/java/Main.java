import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Account> accounts = new ArrayList<>();
        List<User> users = new ArrayList<>();

        boolean running = true;
        while (running) {
            System.out.println("\n1. Create New User");
            System.out.println("2. Use Existing User");
            System.out.println("3. Show Existing Users");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();
                    User newUser = new User(userName, users.size() + 1);
                    users.add(newUser);
                    System.out.println("New user created successfully.");
                    break;
                case 2:
                    if (users.isEmpty()) {
                        System.out.println("No existing users found. Please create a new user.");
                    } else {
                        System.out.println("Existing Users:");
                        for (int i = 0; i < users.size(); i++) {
                            System.out.println((i + 1) + ". " + users.get(i).getName());
                        }
                        System.out.print("Enter the user number to use: ");
                        int userNumber = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        if (userNumber > 0 && userNumber <= users.size()) {
                            Account newAccount = new Account();
                            System.out.print("Enter initial balance: ");
                            double initialBalance = scanner.nextDouble();
                            scanner.nextLine(); // Consume newline
                            newAccount.setInitialBalance(initialBalance);
                            accounts.add(newAccount);
                            System.out.println("New account created successfully.");
                            running = false; // Exit loop after creating the account
                        } else {
                            System.out.println("Invalid user number.");
                        }
                    }
                    break;
                case 3:
                    if (users.isEmpty()) {
                        System.out.println("No existing users found.");
                    } else {
                        System.out.println("Existing Users:");
                        for (int i = 0; i < users.size(); i++) {
                            System.out.println((i + 1) + ". " + users.get(i).getName());
                        }
                    }
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        // Once the user has created an account, the user interface can be started.
        if (!accounts.isEmpty()) {
            Account selectedAccount = accounts.get(accounts.size() - 1); // Select the latest created account
            UserInterface ui = new UserInterface(selectedAccount);
            ui.start();
        }
        
        scanner.close();
    }
}
