package StaticIdAndRate;

public class BankAccount {
    private static double INTEREST_RATE = 0.02;
    private static int counter = 1;
    private int id;
    private double balance;

    public BankAccount() {
        this.id = counter++;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount should be non negative");
        }
        this.balance += amount;
    }

    public double getInterestRate(int years) {
        return INTEREST_RATE * years * this.balance;
    }

    public static void setInterestRate(double interestRate) {
        INTEREST_RATE = interestRate;
    }

    @Override
    public String toString() {
        return "ID" + this.id;
    }
}
