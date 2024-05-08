import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Client implements Serializable {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private List<Portfolio> portfolios;

    public Client() {
        portfolios = new ArrayList<>();
    }

    public Client(String firstName, String lastName, String phoneNumber) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Client(String firstName, String lastName, String phoneNumber, Portfolio... portfolios) {
        this(firstName, lastName, phoneNumber);
        for (Portfolio portfolio : portfolios) {
            this.portfolios.add(portfolio);
        }
    }

    public void addPortfolio(Portfolio portfolio) {
        this.portfolios.add(portfolio);
    }

    public Portfolio getClientPortfolioByName(String name) {
        for (Portfolio portfolio : portfolios) {
            if (portfolio.getName().equals(name)) {
                return portfolio;
            }
        }
        return null; // or throw an exception if that's more appropriate
    }

    public ArrayList<String> getClientPortfolioNames() {
        ArrayList<String> names = new ArrayList<>();
        for (Portfolio portfolio : portfolios) {
            names.add(portfolio.getName());
        }
        return names;
    }

    public double getClientPortfolioValue() {
        double totalValue = 0;
        for (Portfolio portfolio : portfolios) {
            totalValue += portfolio.getValue();
        }
        return totalValue;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getId() {
        return firstName + "-" + lastName; // Assuming ID is composed of firstName-lastName
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getPortfolioCount() {
        return portfolios.size();
    }

    public List<Portfolio> getPortfolios() {
        return new ArrayList<>(portfolios);
    }

    public boolean removePortfolio(Portfolio portfolio) {
        return portfolios.remove(portfolio);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPortfolios(ArrayList<Portfolio> portfolios) {
        this.portfolios = portfolios;
    }
    
    // Override toString, equals, and hashCode if necessary.
}
