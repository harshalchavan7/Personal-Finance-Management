public class Main {
    public static void main(String[] args) {
        // Create an account
        Account account = new Account();

        // Start the user interface
        UserInterface ui = new UserInterface(account);
        ui.start();
    }
}
