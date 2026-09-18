import java.util.Scanner;

public class ATM {

    private Bank bank;
    private Scanner scanner;

    public ATM(Bank bank) {
        this.bank = bank;
        scanner = new Scanner(System.in);
    }

    public Account login() {

        int attempts = 0;

        while (attempts < 3) {

            System.out.print("Enter User ID: ");
            String userId = scanner.nextLine();

            System.out.print("Enter PIN: ");
            int pin = scanner.nextInt();
            scanner.nextLine();

            Account account = bank.findAccount(userId, pin);

            if (account != null) {
                System.out.println("\nLogin Successful!");
                return account;
            }

            attempts++;

            System.out.println("Invalid User ID or PIN.");
            System.out.println("Attempts remaining: " + (3 - attempts));
        }

        System.out.println("\nAccess Denied. Too many incorrect attempts.");
        return null;
    }

    public void start() {

        Account currentAccount = login();

        if (currentAccount == null) {
            return;
        }

        int choice;

        do {

            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    showHistory(currentAccount);
                    break;

                case 2:
                    withdraw(currentAccount);
                    break;

                case 3:
                    deposit(currentAccount);
                    break;

                case 4:
                    transfer(currentAccount);
                    break;

                case 5:
                    System.out.println("Thank you for using the ATM!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);
    }

    private void withdraw(Account account) {

        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        if (account.withdraw(amount)) {

            account.addTransaction(
                new Transaction(
                    "WITHDRAW",
                    amount,
                    "Cash withdrawn"
                )
            );

            System.out.println("Withdrawal successful.");
            System.out.println("Current Balance: ₹" + account.getBalance());

        } else {

            System.out.println("Insufficient Funds.");
        }
    }

    private void deposit(Account account) {

        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        account.deposit(amount);

        account.addTransaction(
            new Transaction(
                "DEPOSIT",
                amount,
                "Money deposited"
            )
        );

        System.out.println("Deposit successful.");
        System.out.println("Current Balance: ₹" + account.getBalance());
    }

    private void transfer(Account sender) {

        scanner.nextLine();

        System.out.print("Enter recipient account ID: ");
        String recipientId = scanner.nextLine();

        Account recipient = bank.findAccountById(recipientId);

        if (recipient == null) {
            System.out.println("Recipient account not found.");
            return;
        }

        if (recipient == sender) {
            System.out.println("Cannot transfer to the same account.");
            return;
        }

        System.out.print("Enter transfer amount: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        if (!sender.withdraw(amount)) {
            System.out.println("Insufficient Funds.");
            return;
        }

        recipient.deposit(amount);

        sender.addTransaction(
            new Transaction(
                "TRANSFER",
                amount,
                "Sent to " + recipientId
            )
        );

        recipient.addTransaction(
            new Transaction(
                "RECEIVED",
                amount,
                "Received from " + sender.getAccountId()
            )
        );

        System.out.println("Transfer successful.");
        System.out.println("Current Balance: ₹" + sender.getBalance());
    }

    private void showHistory(Account account) {

        System.out.println("\n===== TRANSACTION HISTORY =====");

        if (account.getTransactions().isEmpty()) {

            System.out.println("No transactions yet.");

        } else {

            for (Transaction transaction : account.getTransactions()) {
                System.out.println(transaction);
            }
        }

        System.out.println("Current Balance: ₹" + account.getBalance());
    }
}