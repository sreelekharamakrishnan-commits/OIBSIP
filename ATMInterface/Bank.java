import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> accounts;

    public Bank() {

        accounts = new ArrayList<>();

        accounts.add(new Account("ACC001", "user1", 1234, 10000));
        accounts.add(new Account("ACC002", "user2", 5678, 5000));
    }

    public Account findAccount(String userId, int pin) {

        for (Account account : accounts) {

            if (account.getUserId().equals(userId)
                    && account.getPin() == pin) {

                return account;
            }
        }

        return null;
    }

    public Account findAccountById(String accountId) {

        for (Account account : accounts) {

            if (account.getAccountId().equals(accountId)) {
                return account;
            }
        }

        return null;
    }
}