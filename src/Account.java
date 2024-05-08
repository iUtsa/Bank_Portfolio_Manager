public class Account {
    private String accountNumber;
    private double balance;
    private String type;

    public Account(String accountNumber2, double balance2, String string) {
		// TODO Auto-generated constructor stub
	}

	public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getType() {
        return type;
    }

    public void initializeAccount(double balance, String type) {
        this.balance = balance;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", type='" + type + '\'' +
                '}';
    }
}
