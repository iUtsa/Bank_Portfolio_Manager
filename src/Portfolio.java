
import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private List<Account> accounts;
    private String name;

    public Portfolio(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public Portfolio(String name, Account... accounts) {
        this(name);
        for (Account account : accounts) {
            this.accounts.add(account);
        }
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public Account getAccountByNumber(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    // Other getter methods based on the list operations
    // ...

    public double getPortfolioTotalValue() {
        double totalValue = 0;
        for (Account acc : accounts) {
            if (acc instanceof Valuable) {
                totalValue += ((Valuable) acc).getValue();
            }
        }
        return totalValue;
    }

    // Assume that getValue() simply returns the value of the account if it is valuable.
    public double getValue() {
        return getPortfolioTotalValue();
    }

    public String getName() {
        return name;
    }
    

    public void setName(String name) {
        this.name = name;
    }

    public boolean removeAccountByNumber(String accountNumber) {
        return accounts.removeIf(acc -> acc.getAccountNumber().equals(accountNumber));
    }

    @Override
    public String toString() {
        // Implement a suitable toString representation for Portfolio
        return "Portfolio{" +
                "name='" + name + '\'' +
                ", accounts=" + accounts +
                '}';
    }

    public List<Account> getAccounts() { // Method to return accounts
        return accounts;
    }

    // Implement other methods that provide ArrayLists of descriptions, names with types, etc.
}
