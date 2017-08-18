/**
 * Created by Rostislav Kolev on 03-Jul-17.
 */
public class BankAccount {
    private int id;
    private double balance;

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getBalance() {
        return this.balance;
    }

    public void deposit(Double amount) {
        this.balance += amount;
    }

    public void withdraw(Double amount) {
        this.balance -= amount;
    }

    @Override
    public String toString() {
        return "Account ID" + this.id + ", balance " + this.getBalance();
    }
}
