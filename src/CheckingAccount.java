public class CheckingAccount extends Account implements Valuable {

    private static final String TYPE = "Checking";

    public CheckingAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance, TYPE);
    }

    @Override
    public String getDescription() {
        return "Checking Account: " + getAccountNumber();
    }

    @Override
    public double getValue() {
        return getBalance(); // The value might be simply the balance for a checking account.
    }

    // Any additional behaviors specific to a checking account would be added here
}
