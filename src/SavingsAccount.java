public class SavingsAccount extends Account implements Valuable {
    public SavingsAccount(double balance, String accountNumber) {
        super(accountNumber, balance, "Savings");
    }

    @Override
    public String getDescription() {
        return "Savings Account";
    }

    @Override
    public double getValue() {
        return getBalance(); // Assuming the value is the same as the balance
    }
}
