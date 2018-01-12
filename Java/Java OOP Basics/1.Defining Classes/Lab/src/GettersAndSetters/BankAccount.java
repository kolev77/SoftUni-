package GettersAndSetters;

public class BankAccount {
    private Integer id;
    private Double balance = 0d;

    public void setId(Integer id) {
        this.id = id;
    }

    public void deposit(Double amount) {
        this.balance = balance+ amount;
    }


    public void withdraw(Double amount) {
        this.balance-= amount;
    }

    public Double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "ID"+this.id;
    }
}
